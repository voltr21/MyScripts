package com.cGildedBench.strategies;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Game;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.wrappers.SceneObject;

import com.cGildedBench.data.Constants;

public class Making implements Strategy {

	@Override
	public boolean activate() {
		return Inventory.getCount(Constants.MAHOGANY_PLANKS) == 12 && Inventory.getCount(Constants.GOLD_LEAFS) == 12;
	}

	@Override
	public void execute() {
		if (Game.getOpenInterfaceId() == Constants.CONST_INTERFACE_ID) {
			Menu.sendAction(632, 8114, 4, 26702, 2);
			Time.sleep(new SleepCondition() {
					@Override
					public boolean isValid() {
						return Players.getMyPlayer().getAnimation() != -1;
					}
				}, 500);
			SceneObject[] doneBench = SceneObjects.getNearest(Constants.doneBench);
			if (doneBench.length > 0 && doneBench != null && doneBench[0].distanceTo() > 0 && Players.getMyPlayer().getAnimation() == -1) {
				Menu.sendAction(1062, doneBench[0].getHash(), 63, 42, 2);
			}
			Time.sleep(new SleepCondition() {
				@Override
				public boolean isValid() {
					return Players.getMyPlayer().getAnimation() == -1;
				}
			}, 500);
		} else {
			SceneObject[] benchId = SceneObjects.getNearest(Constants.BENCH_ID);
			if (benchId.length > 0 && benchId != null && benchId[0].distanceTo() > 0 && Players.getMyPlayer().getAnimation() == -1) {
				benchId[0].interact(4);
				Time.sleep(new SleepCondition() {
					@Override
					public boolean isValid() {
						return Game.getOpenInterfaceId() == Constants.CONST_INTERFACE_ID;
					}
				}, 500);
			}
		}
	}
}
