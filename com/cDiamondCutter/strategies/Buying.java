package com.cDiamondCutter.strategies;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Game;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.methods.Npcs;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.wrappers.Npc;
import com.cDiamondCutter.data.Constants;

public class Buying implements Strategy {

	@Override
	public boolean activate() {
		return Inventory.getCount(Constants.DIAMONDS_ID) == 0;
	}

	@Override
	public void execute() {
		if (Game.getOpenInterfaceId() == Constants.INTERFACE_ID) { // BUYS THE DIAMONDS
			Menu.sendAction(53, 1617, 6, 3900, 3);
			Menu.sendAction(200, 1735, 22, 3902, 1);
			Time.sleep(500);
			Time.sleep(new SleepCondition() {
				@Override
				public boolean isValid() {
					return Game.getOpenInterfaceId() == -1;
				}
			}, 500);
		} else { // OPENS THE SHOP
			Npc[] craftingShop = Npcs.getNearest(Constants.CRAFTING_SHOP);
			if (craftingShop.length > 0 && craftingShop != null
					&& craftingShop[0].distanceTo() > 0
					&& Players.getMyPlayer().getAnimation() == -1) {
				craftingShop[0].interact(0);
				Time.sleep(new SleepCondition() {
					@Override
					public boolean isValid() {
						return Game.getOpenInterfaceId() == Constants.INTERFACE_ID;
					}
				}, 1000);
			}
		}
	}
}
