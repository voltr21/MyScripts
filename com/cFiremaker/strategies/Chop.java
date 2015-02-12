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
		SceneObject[] TREE_ID = SceneObjects.getNearest(Constants.TREE_ID);
		if (TREE_ID.length > 0 && TREE_ID != null
				&& TREE_ID[0].distanceTo() > 0
				&& Players.getMyPlayer().getAnimation() == -1) {
			TREE_ID[0].interact(TREE_ID[0].getHash());
		}
		if (Inventory.getCount(Constants.SEED_ID) >= 1) {
			Item SEED_ID = Inventory.getItem(Constants.SEED_ID);
			Menu.sendAction(847, Constants.SEED_ID - 1, SEED_ID.getSlot(), 3214, 2);
			Time.sleep(500);
			Time.sleep(new SleepCondition() {
				@Override
				public boolean isValid() {
					return Inventory.getCount(Constants.SEED_ID) == 0;
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
