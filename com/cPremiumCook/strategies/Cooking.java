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
		return Inventory.getCount(Constants.RAW_FISH) == 28;
	}

	@Override
	public void execute() {
		SceneObject[] FIRE_ID = SceneObjects.getNearest(Constants.FIRE_ID);
		Item FISH = Inventory.getItem(Constants.RAW_FISH);
		if (FIRE_ID.length > 0 && FIRE_ID != null
				&& FIRE_ID[0].distanceTo() > 0
				&& Players.getMyPlayer().getAnimation() == -1) {
			Menu.sendAction(447, Constants.RAW_FISH - 1, FISH.getSlot(), 3214, 3);
			Menu.sendAction(62, FIRE_ID[0].getHash(), FIRE_ID[0].getLocalRegionX(), FIRE_ID[0].getLocalRegionY(), 1);
			Time.sleep(2000);
			Time.sleep(new SleepCondition() {
				@Override
				public boolean isValid() {
					return Players.getMyPlayer().getAnimation() != -1;
				}
			}, 1000);
		}
	}
}
