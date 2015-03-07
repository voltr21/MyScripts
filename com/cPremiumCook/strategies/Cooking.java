package com.cPremiumCook.strategies;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.wrappers.Item;
import org.rev317.min.api.wrappers.SceneObject;

import com.cPremiumCook.data.Constants;

public class Cooking implements Strategy {
	

	@Override
	public boolean activate() {
		return Inventory.getCount(Constants.rawFish) == 28;
	}

	@Override
	public void execute() {
		SceneObject[] fireId = SceneObjects.getNearest(Constants.FIRE_ID);
		Item fishId = Inventory.getItem(Constants.rawFish);
		if (fireId.length > 0 && fireId != null
				&& fireId[0].distanceTo() > 0
				&& Players.getMyPlayer().getAnimation() == -1) {
			Menu.sendAction(447, Constants.fishId - 1, fishId.getSlot(), 3214, 3);
			Menu.sendAction(62, fireId[0].getHash(), fireId[0].getLocalRegionX(), fireId[0].getLocalRegionY(), 1);
			Time.sleep(new SleepCondition() {
				@Override
				public boolean isValid() {
					return Players.getMyPlayer().getAnimation() != -1;
				}
			}, 1000);
		}
	}
}
