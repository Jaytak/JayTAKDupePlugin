package io.jaytak.jaytakdupeplugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Arrays;

import static org.bukkit.Bukkit.getLogger;

public class Dupe implements CommandExecutor {
    public boolean onCommand(@NonNull CommandSender sender,
                             @NonNull Command command,
                             @NonNull String label,
                             @SuppressWarnings("NullableProblems") String[] args){
        try{
            if (command.getName().equals("jdupe")){
                if (sender instanceof Player){
                    getLogger().info("[JayTAK Dupe] args: " + Arrays.toString(args));
                    Player player = (Player) sender;
                    String username = player.getName();
                    getLogger().info("[JayTAK Dupe] " + username + " Issued the command " + command.getName());

                    if (player.hasPermission("jaytakdupeplugin.dupe")){
                        try{
                            ItemStack itemInHand = player.getInventory().getItemInMainHand();
                            if (itemInHand.getType() != Material.AIR){
                                int count = itemInHand.getAmount();
                                int multiplier;
                                int finalAmt = 0;
                                try{
                                    if (args.length == 1){
                                        multiplier = Integer.parseInt(args[0]);
                                        finalAmt = count + multiplier;
                                    }
                                    else if (args.length == 2){
                                        String operator = args[0];
                                        int amt = Integer.parseInt(args[1]);
                                        switch (operator){
                                            case "+":
                                                finalAmt = count + amt;
                                                break;
                                            case "-":
                                                finalAmt = count - amt;
                                                break;
                                            case "*":
                                            case "x":
                                            case "X":
                                                finalAmt = count * amt;
                                                break;
                                            case "/":
                                                finalAmt = count / amt;
                                                break;
                                            default:
                                                sender.sendMessage("[JayTak Dupe] Invalid Operator: " + operator);
                                                return false;
                                        }
                                        if (finalAmt < 1){
                                            finalAmt = 1;
                                        }
                                    }
                                    else{
                                        count++;
                                        finalAmt = count;
                                    }
                                }
                                catch (NumberFormatException e){
                                    sender.sendMessage("[JayTak Dupe] Invalid Multiplier Value: " + args[1]);
                                    getLogger().info("[JayTak Dupe] Invalid Multiplier Value: " + args[1] + " args: " + Arrays.toString(args));
                                }
                                catch (Exception e){
                                    sender.sendMessage("[JayTAK Dupe] Ran into Exception.");
                                    getLogger().info("[JayTAK Dupe] Ran into Exception: " + e);
                                }
                                //count++;
                                itemInHand.setAmount(finalAmt);
                                getLogger().info("[JayTAK Dupe] Duped items. Final amt: " + finalAmt);
                                sender.sendMessage("[JayTAK Dupe] Duped items. Final amount: " + finalAmt);
                                return true;
                            }
                        }catch (Exception exception){
                            getLogger().info("[JayTak Dupe] exception: " + exception);
                        }
                    }
                    else{
                        sender.sendMessage("[JayTak Dupe] You dont have permission to use this command.");
                    }
                }
            }
        }
        catch (Exception e){
            getLogger().info("[JayTak Dupe] Exception: " + e);
        }
    return false;
    }
}
