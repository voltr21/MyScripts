package com.cJailSolver.strategies;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.wrappers.SceneObject;

import com.cJailSolver.data.Constants;

public class Mine implements Strategy {

	@Override
	public boolean activate() {
		return true;
	}

	@Override
	public void execute() {
		if (Inventory.getCount(Constants.ORES_ID) < 28) {
			SceneObject[] ORES_ID = SceneObjects.getNearest(Constants.MINE_ID);
			if (ORES_ID.length > 0 && ORES_ID != null
					&& ORES_ID[0].distanceTo() > 0
					&& Players.getMyPlayer().getAnimation() == -1) {
				ORES_ID[0].interact(ORES_ID[0].getHash());
				Time.sleep(500);
			}
		}
		Time.sleep(new SleepCondition() {
			@Override
			public boolean isValid() {
				return Players.getMyPlayer().getAnimation() != -1;
			}
		}, 500);
	}

}
