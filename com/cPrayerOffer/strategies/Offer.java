package com.cPrayerOffer.strategies;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.wrappers.Item;
import org.rev317.min.api.wrappers.SceneObject;

import com.cPrayerOffer.data.Constants;

public class Offer implements Strategy {

	@Override
	public boolean activate() {
		// TODO Auto-generated method stub
		return Inventory.getCount(Constants.BONES_ID) == 28;
	}

	@Override
	public void execute() {
		SceneObject[] ALTAR_ID = SceneObjects.getNearest(Constants.ALTAR_ID);
		Item BONES_ID = Inventory.getItem(Constants.BONES_ID);
		if (ALTAR_ID.length > 0 && ALTAR_ID != null
				&& ALTAR_ID[0].distanceTo() > 0
				&& Players.getMyPlayer().getAnimation() == -1) {
			Menu.sendAction(447, Constants.BONES_ID - 1, BONES_ID.getSlot(), 3214, 3);
			Menu.sendAction(62, ALTAR_ID[0].getHash(), ALTAR_ID[0].getLocalRegionX(), ALTAR_ID[0].getLocalRegionY(), 1);
			Menu.sendAction(315, 6701056, 284, 2498, 1);
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
