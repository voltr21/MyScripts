package com.cJailSolver;

import java.util.ArrayList;

import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;

//import com.cJailSolver.strategies.Give;
import com.cJailSolver.strategies.Mine;

@ScriptManifest(author = "Capslock", 
	category = Category.OTHER, 
	description = "Mines 200 ores", 
	name = "cJailSolver", 
	servers = { "PKHonor" }, 
	version = 1.0)
public class Core extends Script {
	private static ArrayList<Strategy> strategies = new ArrayList<Strategy>();
	
	public boolean onExecute() {
		strategies.add(new Mine());
		//strategies.add(new Give());
		provide(strategies);
		return true;
	}
	
	public void onFinish() {
		
	}
}