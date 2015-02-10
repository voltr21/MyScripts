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
		return Inventory.getCount(Constants.UNCUT_DIAMONDS_ID) == 25;
	}

	@Override
	public void execute() {
		//TODO
		Item CHISEL = Inventory.getItem(Constants.CHISEL_ID);
		Item UNCUT_DIAMOND = Inventory.getItem(Constants.UNCUT_DIAMONDS_ID);
		Menu.sendAction(447, Constants.CHISEL_ID - 1, CHISEL.getSlot(), 3214, 3);
		Menu.sendAction(870, Constants.UNCUT_DIAMONDS_ID - 1, UNCUT_DIAMOND.getSlot(), 3214, 1);
		Menu.sendAction(315, 5029888, 272, 2498, 1);
		Time.sleep(24000);
		Menu.sendAction(447, Constants.CHISEL_ID - 1, CHISEL.getSlot(), 3214, 3);
		Menu.sendAction(870, 1601, 14, 3214, 1);
		Menu.sendAction(315, Constants.DIAMONDS_ID - 1, 8, 2472, 1);
		Menu.sendAction(315, Constants.DIAMONDS_ID - 1, 20, 2498, 1);
		Time.sleep(new SleepCondition() {
			@Override
			public boolean isValid() {
				return Players.getMyPlayer().getAnimation() == -1;
			}
		}, 500);
	}

}
