package com.cJailSolver.strategies;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Npcs;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.wrappers.Npc;

import com.cJailSolver.data.Constants;

public class Give implements Strategy {

	@Override
	public boolean activate() {
		return Inventory.getCount(Constants.ORES_ID) == 28;
	}

	@Override
	public void execute() {
		Npc[] JAILER_ID = Npcs.getNearest(Constants.JAILER_ID);
		if (JAILER_ID.length > 0 && JAILER_ID != null
				&& JAILER_ID[0].distanceTo() > 0
				&& Players.getMyPlayer().getAnimation() == -1) {
			JAILER_ID[0].interact(0);
			Time.sleep(500);
		}
		Time.sleep(new SleepCondition() {
			@Override
			public boolean isValid() {
				return Inventory.getCount(Constants.ORES_ID) == 0;
			}
		}, 500);
	}
}
