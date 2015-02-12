package com.cDiamondCutter;

import java.util.ArrayList;

import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;

import com.cDiamondCutter.strategies.Buying;
import com.cDiamondCutter.strategies.Making;

@ScriptManifest(author = "Capslock", 
	category = Category.CRAFTING, 
	description = "Cuts diamonds until it's tips", 
	name = "cDiamondCutter", 
	servers = { "PKHonor" }, 
	version = 1.0)
public class Core extends Script {
	private static ArrayList<Strategy> strategies = new ArrayList<Strategy>();
	
	public boolean onExecute() {
		strategies.add(new Making());
		strategies.add(new Buying());
		provide(strategies);
		return true;
	}
	
	public void onFinish() {
		
	}
}