package net.bbgen.bukkit.sandgeneratorfix;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.plugin.java.JavaPlugin;
/**
 * Sample plugin for Bukkit
 *
 * @author Bernhard Eder
 */
public class Sandgeneratorfix extends JavaPlugin implements Listener {

	public void onEnable() {
        getLogger().info("Enabled Sandgeneratorfix.");
        
        getServer().getPluginManager().registerEvents(this, this);
    }
    
    
	@EventHandler(priority = EventPriority.HIGH)
    public void onPistonExtend(BlockPistonExtendEvent event)
	{
		List<Block> blocks = event.getBlocks();
    	if(blocklistContainsType(blocks, Material.SAND, Material.GRAVEL))
    	{
    		event.setCancelled(true);
    	}
    }
	
	private static boolean blocklistContainsType(List<Block> blocks, Material... types)
	{
		for(Block block : blocks)
		{
			for(Material type : types)
			{
				if(block.getType().equals(type))
					return true;
			}
		}
		return false;
	}
    
    public void onDisable() {    	
        getLogger().info("Disabled Sandgeneratorfix.");
    }
}
