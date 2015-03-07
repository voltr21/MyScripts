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
		return Inventory.getCount(Constants.bonesId) == 28;
	}

	@Override
	public void execute() {
		SceneObject[] altarId = SceneObjects.getNearest(Constants.ALTAR_ID);
		Item bonesId = Inventory.getItem(Constants.bonesId);
		if (altarId.length > 0 && altarId != null
				&& altarId[0].distanceTo() > 0
				&& Players.getMyPlayer().getAnimation() == -1) {
			Menu.sendAction(447, Constants.bonesId - 1, bonesId.getSlot(), 3214, 3);
			Menu.sendAction(62, altarId[0].getHash(), altarId[0].getLocalRegionX(), altarId[0].getLocalRegionY(), 1);
			Menu.sendAction(315, 6701056, 284, 2498, 1);
			Time.sleep(new SleepCondition() {
				@Override
				public boolean isValid() {
					return Players.getMyPlayer().getAnimation() != -1;
				}
			}, 1000);
		}
	}

}
