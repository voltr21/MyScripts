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
		return Inventory.getCount(Constants.ORES_ID) <= 27;
	}

	@Override
	public void execute() {
		if (Inventory.getCount(Constants.ORES_ID) < 28) {
			SceneObject[] oresId = SceneObjects.getNearest(Constants.MINE_ID);
			if (oresId.length > 0 && oresId != null
					&& oresId[0].distanceTo() > 0
					&& Players.getMyPlayer().getAnimation() == -1) {
				oresId[0].interact(oresId[0].getHash());
				Time.sleep(new SleepCondition() {
					@Override
					public boolean isValid() {
						return Inventory.getCount(Constants.ORES_ID) == 28;
					}
				}, 500);
			}
		}
	}

}
