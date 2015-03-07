package com.cFiremaker.strategies;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Inventory;
import com.cFiremaker.data.Constants;

public class Fire implements Strategy {

	@Override
	public boolean activate() {
		return Inventory.getCount(Constants.logsId) == 27;
	}

	@Override
	public void execute() {
		do {
			Inventory.combine(Constants.logsId, Constants.TINDERBOX_ID);
			Time.sleep(500);
			Constants.DO_27 ++;
		} while (Constants.DO_27 < 27);
		Time.sleep(new SleepCondition() {
			@Override
			public boolean isValid() {
				Constants.DO_27 = 0;
				return Inventory.getCount(Constants.logsId) == 0;
			}
		}, 500);
	}

}
