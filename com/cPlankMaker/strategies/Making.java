package com.cPlankMaker.strategies;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Menu;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.wrappers.SceneObject;

import com.cPlankMaker.data.Constants;

public class Making implements Strategy {

	@Override
	public boolean activate() {
		return Inventory.getCount(Constants.MAHOGANY_LOGS) >= 1;
	}

	@Override
	public void execute() {
		SceneObject[] WORKBENCH = SceneObjects.getNearest(Constants.WORKBENCH_ID);
		if (WORKBENCH.length > 0 && WORKBENCH != null
				&& WORKBENCH[0].distanceTo() > 0
				&& Players.getMyPlayer().getAnimation() == -1) {
			WORKBENCH[0].interact(0);
			Time.sleep(500);
			Menu.sendAction(315, WORKBENCH[0].getHash(), 279, 2461, 1);
		}
	}

}
