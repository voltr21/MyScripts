package cMasterFarmer.strategies;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Npcs;
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
        for (Npc masterFarmer : Npcs.getNearest(3257)) {
            masterFarmer.interact(0);
            Time.sleep(1000);
        }
    }
}
