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
		Npc[] jailerId = Npcs.getNearest(Constants.JAILER_ID);
		if (jailerId.length > 0 && jailerId != null
				&& jailerId[0].distanceTo() > 0
				&& Players.getMyPlayer().getAnimation() == -1) {
			jailerId[0].interact(0);
			Time.sleep(new SleepCondition() {
				@Override
				public boolean isValid() {
					return Inventory.getCount(Constants.ORES_ID) == 0;
				}
			}, 500);
		}
	}
}
