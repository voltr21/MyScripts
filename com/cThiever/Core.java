package cThiever;

import java.util.ArrayList;

import cThiever.strategies.Sell;
import cThiever.strategies.Steal;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;

@ScriptManifest(author = "Capslock",
        category = Category.THIEVING,
        description = "Steals",
        name = "cThiever",
        servers = { "OSPvP" },
        version = 1.0)
public class Core extends Script {
    private static ArrayList<Strategy> strategies = new ArrayList<Strategy>();

    public boolean onExecute() {
        Gui GUI = new Gui();
        GUI.setVisible(true);
        while (GUI.isVisible()) {
            sleep(20);
        }
        strategies.add(new Steal());
        strategies.add(new Sell());
        provide(strategies);
        return true;
    }

    public void onFinish() {

    }
}