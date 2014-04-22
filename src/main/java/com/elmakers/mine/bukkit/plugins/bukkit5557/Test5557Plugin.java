package com.elmakers.mine.bukkit.plugins.bukkit5557;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Test5557Plugin extends JavaPlugin implements Listener
{	
	public void onEnable() 
	{
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this, this);
	}

	public void onDisable() 
	{
	}
	
	@EventHandler
	public void onEnchantItem(EnchantItemEvent event) {
		if (event.getItem().getType() == Material.DIAMOND_SWORD) {
			event.getEnchantsToAdd().clear();
			int level = event.getExpLevelCost();
			
			event.getEnchanter().sendMessage("I have done some  enchanting on your " 
					+ event.getItem().getType() + " using " + level + " levels, and I'm hoping XP was deducted.");
			
			// This is hacky work-around for the issue...
			// Please don't make this not work :(
			// event.getEnchantsToAdd().put(null, 0);
		}
	}
}
