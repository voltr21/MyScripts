package com.cDiamondCutter.data;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.wrappers.Item;

import com.cDiamondCutter.strategies.Constants;

public class Making implements Strategy {

	@Override
	public boolean activate() {
		return Inventory.getCount(Constants.UNCUT_DIAMONDS_ID) >= 1;
	}

	@Override
	public void execute() {

         Inventory.combine(constants.CHISEL_ID, constants.UNCUT_DIAMONDS_ID);
		Time.sleep(new SleepCondition() {
			@Override
			public boolean isValid() {
				return Players.getMyPlayer().getAnimation() == -1;
			}
		}, 1000);
	}

}