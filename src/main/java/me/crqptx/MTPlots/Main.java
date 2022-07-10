package me.crqptx.MTPlots;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import me.crqptx.MTPlots.Commands.pi;
import me.crqptx.MTPlots.Commands.hplots;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;



public class Main extends JavaPlugin implements Listener {


    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[MT-Plots] Plugin is aan het starten...");


        getConfig().options().copyDefaults();
        saveDefaultConfig();





        // Register commands
        getCommand("pi").setExecutor(new pi());
        getCommand("hplots").setExecutor(new hplots());

        instance = this;


        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[MT-Plots] Plugin is geladen!");
    }




    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }









    public static WorldGuardPlugin getWorldGuard() {
        Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");
        return plugin != null && plugin instanceof WorldGuardPlugin ? (WorldGuardPlugin) plugin : null;
    }
}
