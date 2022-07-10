package me.crqptx.MTPlots.Commands;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.crqptx.MTPlots.Commands.pi.getWorldGuard;

public class hplots implements CommandExecutor {
    public hplots() {
    }



    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player p = (Player) sender;
        ApplicableRegionSet set;
        set = getWorldGuard().getRegionManager(p.getWorld()).getApplicableRegions(p.getLocation());
        if (set == null || set.getRegions().isEmpty()) {
            p.sendMessage("§cFout je staat niet op een plot!");
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("hplots")) {
            if (args.length == 0) {
                p.sendMessage("§4Made by: §fJustin.#0060");
                p.sendMessage(" ");
                p.sendMessage("§4/hplots setprice (prijs) §7- §fZet de prijs van een plot waar je op staat.");
                p.sendMessage("§4/hplots removeprice §7- §fVerwijder de prijs van het plot waar je op staat.");
                p.sendMessage("§4/hplots blacklist add §7- §fVoeg het plot waar je op staat aan de blacklist.");
                p.sendMessage("§4/hplots blacklist remove §7- §fVerwijder het plot waar je op staat van de blacklist.");
                return true;
            }
        }
        return true;
    }
}






