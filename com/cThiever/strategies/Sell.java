package cThiever.strategies;

import cThiever.data.Constants;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.*;
import org.rev317.min.api.wrappers.Npc;

/**
 * Created by Capslock
 * On 06/03/15
 * With IntelliJ
 */
public class Sell implements Strategy {

    @Override
    public boolean activate() {
        return Inventory.isFull();
    }
    @Override
    public void execute() {
        for (Npc sigmundShop : Npcs.getNearest(3894)) {
            if (Game.getOpenInterfaceId() == 3824) {
                while (Constants.DO_THREE < 3) {
                    Menu.sendAction(431, Constants.itemId - 1, 27, 3823, 2);
                    Constants.DO_THREE++;
                }
                Time.sleep(new SleepCondition() {
                    @Override
                    public boolean isValid() {
                        Constants.DO_THREE = 0;
                        return Inventory.getCount(Constants.itemId) == 0;
                    }
                }, 3000);
                Menu.sendAction(200, 19595264, 160, 3902, 1);
                Time.sleep(new SleepCondition() {
                    @Override
                    public boolean isValid() {
                        return Game.getOpenInterfaceId() == -1;
                    }
                }, 1000);
            } else {
                sigmundShop.interact(2);
                Time.sleep(new SleepCondition() {
                    @Override
                    public boolean isValid() {
                        return Game.getOpenInterfaceId() == 3824;
                    }
                }, 3000);
            }
        }
    }
}