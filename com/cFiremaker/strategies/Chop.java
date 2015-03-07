package com.cFiremaker.strategies;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.wrappers.Item;
import org.rev317.min.api.wrappers.SceneObject;

import com.cFiremaker.data.Constants;

public class Chop implements Strategy {

	@Override
	public boolean activate() {
		return !Inventory.isFull();
	}

	@Override
	public void execute() {
		SceneObject[] treeId = SceneObjects.getNearest(Constants.treeId);
		if (treeId.length > 0 && treeId != null
				&& treeId[0].distanceTo() > 0
				&& Players.getMyPlayer().getAnimation() == -1) {
			treeId[0].interact(treeId[0].getHash());
		}
		if (Inventory.getCount(Constants.seedId) >= 1) {
			Item seedId = Inventory.getItem(Constants.seedId);
			Menu.sendAction(847, Constants.seedId - 1, seedId.getSlot(), 3214, 2);
			Time.sleep(new SleepCondition() {
				@Override
				public boolean isValid() {
					return Inventory.getCount(Constants.seedId) == 0;
				}
			}, 500);
		}
		Time.sleep(new SleepCondition() {
			@Override
			public boolean isValid() {
				return Players.getMyPlayer().getAnimation() != -1;
			}
		}, 500);
	}

}
