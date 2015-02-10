package com.cPrayerOffer;

import java.util.ArrayList;

import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;

import com.cPrayerOffer.strategies.Banking;
import com.cPrayerOffer.strategies.Offer;

@ScriptManifest(author = "Capslock", 
	category = Category.PRAYER, 
	description = "Offers Bones at the altar on premium skilling zone", 
	name = "cPrayerOffer", 
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
		strategies.add(new Offer());
		strategies.add(new Banking());
		provide(strategies);
		return true;
	}
	
	public void onFinish() {
		
	}
}