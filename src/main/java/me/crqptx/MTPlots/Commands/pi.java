package me.crqptx.MTPlots.Commands;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;

import me.crqptx.MTPlots.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;

import java.util.Collections;



public class pi implements CommandExecutor, Listener {
    public pi() {

    }

    private Main main = Main.getInstance();


    public static WorldGuardPlugin getWorldGuard() {
        Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");
        return plugin != null && plugin instanceof WorldGuardPlugin ? (WorldGuardPlugin) plugin : null;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {return true;}
        Player p = (Player) sender;
        ApplicableRegionSet set;






        if (cmd.getName().equalsIgnoreCase("pi")) {
            set = getWorldGuard().getRegionManager(p.getWorld()).getApplicableRegions(p.getLocation());
            if (set == null || set.getRegions().isEmpty()) {
                p.sendMessage("§cFout je staat niet op een plot!");
                return true;
            }


            String plot = set.getRegions().iterator().next().getId();

            Inventory inv = Bukkit.createInventory(null, 27, plot);

            ItemStack members = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
            SkullMeta membersMeta = (SkullMeta) members.getItemMeta();
            membersMeta.setOwner(p.getName());
            membersMeta.setDisplayName("§8Plot Members");
            membersMeta.setLore(Collections.singletonList("§fBekijk de members van dit plot."));
            members.setItemMeta(membersMeta);


            ItemStack book = new ItemStack(Material.BOOK, 1);
            ItemMeta bookMeta = book.getItemMeta();
            bookMeta.setDisplayName(ChatColor.DARK_GRAY + plot);





            bookMeta.setLore(Collections.singletonList("§fPlot ID: " + plot));

            bookMeta.setLore(Collections.singletonList("§fPlot Prijs: " + "§cCurrently not working!"));

            bookMeta.setLore(Collections.singletonList("§fPlot Owner: " + p.getName()));


            book.setItemMeta(bookMeta);



            inv.setItem(13, members);

            inv.setItem(0, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3));
            inv.setItem(1, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3));
            inv.setItem(2, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3));
            inv.setItem(3, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3));
            inv.setItem(4, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3));
            inv.setItem(5, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3));
            inv.setItem(6, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3));
            inv.setItem(7, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3));
            inv.setItem(8, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3));
            inv.setItem(9, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3));


            inv.setItem(10, book);


            inv.setItem(11, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3));
            inv.setItem(12, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3));



            ItemStack sunflower = new ItemStack(Material.DOUBLE_PLANT, 1, (short) 0);
            ItemMeta sunflowerMeta = sunflower.getItemMeta();
            sunflowerMeta.setDisplayName("§cVerkoop Plot!");
            sunflowerMeta.setLore(Collections.singletonList("§7Klik om te verkopen voor: " + "§cCurrently not working!"));


            sunflower.setItemMeta(sunflowerMeta);


            inv.setItem(14, sunflower);

            ItemStack horse = new ItemStack(Material.GOLD_BARDING, 1);
            ItemMeta horseMeta = horse.getItemMeta();
            horseMeta.setDisplayName("§cTransfer Plot!");

            horseMeta.setLore(Collections.singletonList("§7Klik om je plot te transferen."));

            inv.setItem(15, horse);

            inv.setItem(16, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3));
            inv.setItem(17, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3));
            inv.setItem(18, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3));
            inv.setItem(19, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3));
            inv.setItem(20, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3));
            inv.setItem(21, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3));
            inv.setItem(22, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3));
            inv.setItem(23, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3));
            inv.setItem(24, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3));
            inv.setItem(25, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3));
            inv.setItem(26, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 3));

            p.openInventory(inv);
            return true;
        }
        return true;
    }
}


