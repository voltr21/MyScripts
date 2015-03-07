package cPlankMaker.strategies;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Game;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.methods.Npcs;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.wrappers.Npc;

import cPlankMaker.data.Constants;

public class Banking implements Strategy {

	@Override
	public boolean activate() {
		return Inventory.getCount(Constants.MAHOGANY_PLANKS) >= 1;
	}

	@Override
	public void execute() {
		if (Game.getOpenInterfaceId() == Constants.INTERFACE_ID) {
			Menu.sendAction(432, 8786, 2, 5064, 2);
			Menu.sendAction(53, 6332, 0, 5382, 3);
			Menu.sendAction(200, 6332, 0, 5384, 1);
			Time.sleep(new SleepCondition() {
				@Override
				public boolean isValid() {
					return Game.getOpenInterfaceId() == Constants.INTERFACE_ID;
				}
			}, 500);
		} else {
			Npc[] BUTLER_ID = Npcs.getNearest(Constants.BANK_ID);
			if (BUTLER_ID.length > 0 && BUTLER_ID != null
					&& BUTLER_ID[0].distanceTo() > 0
					&& Players.getMyPlayer().getAnimation() == -1) {
				BUTLER_ID[0].interact(2);
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
