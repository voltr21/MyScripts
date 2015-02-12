package com.cPremiumCook;

import java.util.ArrayList;

import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;

import com.cPremiumCook.strategies.Banking;
import com.cPremiumCook.strategies.Cooking;

@ScriptManifest(author = "Capslock", 
	category = Category.COOKING, 
	description = "Cooks manta ray", 
	name = "cPremiumCooker", 
	servers = { "PKHonor" }, 
	version = 1.0)
public class Main extends Script {
	private static ArrayList<Strategy> strategies = new ArrayList<Strategy>();
	
	public boolean onExecute() {
		Gui GUI = new Gui();
		GUI.setVisible(true);
		while (GUI.isVisible()) {
			sleep(20);
		}
		strategies.add(new Cooking());
		strategies.add(new Banking());
		provide(strategies);
		return true;
	}
	
	public void onFinish() {
		
	}
}