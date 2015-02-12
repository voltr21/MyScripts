package com.cFiremaker;

import java.util.ArrayList;

import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;

import com.cFiremaker.strategies.Chop;
import com.cFiremaker.strategies.Fire;

@ScriptManifest(author = "Capslock", 
	category = Category.FIREMAKING, 
	description = "Cuts and uses tinderbox on the logs", 
	name = "cFiremaker", 
	servers = { "PKHonor" }, 
	version = 1.0)
public class Core extends Script {
	private static ArrayList<Strategy> strategies = new ArrayList<Strategy>();
	
	public boolean onExecute() {
		Gui GUI = new Gui();
		GUI.setVisible(true);
		while (GUI.isVisible()) {
			sleep(20);
		}
		strategies.add(new Chop());
		strategies.add(new Fire());
		provide(strategies);
		return true;
	}
	
	public void onFinish() {
		
	}
}