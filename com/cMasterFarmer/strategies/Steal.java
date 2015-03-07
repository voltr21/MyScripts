package cMasterFarmer.strategies;

import cMasterFarmer.data.Constants;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Npcs;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.wrappers.Npc;

/**
 * Created by Capslock
 * On 06/03/15
 * With IntelliJ
 */
public class Steal implements Strategy {
    @Override
    public boolean activate() {
        return !Inventory.isFull();
    }

    @Override
    public void execute() {
        for (Npc masterFarmer : Npcs.getNearest(Constants.MASTER_FARMER)) {
            masterFarmer.interact(0);
            final int inv = Inventory.getCount();
            Time.sleep(new SleepCondition() {
                @Override
                public boolean isValid() {
                    return Players.getMyPlayer().getAnimation() != -1 && Inventory.getCount() != inv ;
                }
            }, 1000);
        }
    }
}
