package io.jaytak.jaytakdupeplugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.checkerframework.checker.nullness.qual.NonNull;

import static org.bukkit.Bukkit.getLogger;

public class Dupe implements CommandExecutor {
    public boolean onCommand(@NonNull CommandSender sender,
                             @NonNull Command command,
                             @NonNull String label,
                             @NonNull String[] args){
        try{
            if (command.getName().equals("jdupe")){
                if (sender instanceof Player){
                    Player player = (Player) sender;
                    String username = player.getName();
                    getLogger().info("[JayTAK Dupe] " + username + " Issued the command " + command.getName());

                    if (player.hasPermission("jaytakdupeplugin.dupe")){
                        try{
                            ItemStack itemInHand = player.getInventory().getItemInMainHand();
                            if (itemInHand.getType() != Material.AIR){
                                int count = itemInHand.getAmount();
                                count++;
                                itemInHand.setAmount(count);
                                getLogger().info("[JayTAK Dupe] Duped items.");
                                sender.sendMessage("[JayTAK Dupe] Duped items.");
                                return true;
                            }
                        }catch (Exception exception){
                            getLogger().info("exception: " + exception);
                        }
                    }
                    else{
                        sender.sendMessage("You dont have permission to use this command.");
                    }
                }
            }
        }
        catch (Exception e){
            getLogger().info("Exception: " + e);
        }
    return false;
    }
}
