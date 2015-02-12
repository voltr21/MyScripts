package com.cDiamondCutter.strategies;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.methods.Players;
import com.cDiamondCutter.data.Constants;

public class Making implements Strategy {

	@Override
	public boolean activate() {
		return Inventory.getCount(Constants.UNCUT_DIAMONDS_ID) >= 1;
	}

	@Override
	public void execute() {
		do {
			Inventory.combine(Constants.CHISEL_ID, Constants.UNCUT_DIAMONDS_ID);
			Time.sleep(500);
			Constants.DO_25 ++;
		} while (Constants.DO_25 < 26);
		Constants.DO_25 = 0;
		do {
			Inventory.combine(Constants.CHISEL_ID, Constants.DIAMONDS_ID);
			Menu.sendAction(315, Constants.DIAMONDS_ID - 1, 8, 2472, 1);
			Time.sleep(500);
			Constants.DO_25 ++;
		} while (Constants.DO_25 < 26);
		Time.sleep(new SleepCondition() {
			@Override
			public boolean isValid() {
				Constants.DO_25 = 0;
				return Players.getMyPlayer().getAnimation() == -1;
			}
		}, 500);
	}
}
