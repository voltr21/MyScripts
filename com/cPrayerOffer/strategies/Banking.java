package com.cPrayerOffer.strategies;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Game;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.wrappers.SceneObject;

import com.cPrayerOffer.data.Constants;

public class Banking implements Strategy {

	@Override
	public boolean activate() {
		return Inventory.getCount(Constants.BONES_ID) == 0;
	}

	@Override
	public void execute() {
		if (Game.getOpenInterfaceId() == Constants.INTERFACE_ID) {
			Menu.sendAction(53, 536, 0, 5382, 3);
			Menu.sendAction(200, 4155, 0, 5384, 1);
			Time.sleep(new SleepCondition() {
				@Override
				public boolean isValid() {
					return Game.getOpenInterfaceId() == Constants.INTERFACE_ID;
				}
			}, 500);
		} else {
			SceneObject[] BANK_BOOTH = SceneObjects.getNearest(Constants.BANK_ID);
			if (BANK_BOOTH.length > 0 && BANK_BOOTH != null
					&& BANK_BOOTH[0].distanceTo() > 0
					&& Players.getMyPlayer().getAnimation() == -1) {
				BANK_BOOTH[0].interact(0);
				Time.sleep(new SleepCondition() {
					@Override
					public boolean isValid() {
						return Players.getMyPlayer().getAnimation() != -1;
					}
				}, 500);
			}
		}
	}
}