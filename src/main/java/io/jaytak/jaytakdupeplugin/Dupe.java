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
        String cTitle = "[JayTAK Dupe] ";
        try{
            String pTitle = "§6§l[§r§5JayTAK §cDupe§6§l]§r ";
            if (command.getName().equals("jdupe")){
                if (sender instanceof Player){
                    getLogger().info(cTitle + "Args: " + Arrays.toString(args));
                    Player player = (Player) sender;
                    String username = player.getName();
                    //().info(cTitle + username + " Issued the command " + command.getName());

                    if (player.hasPermission("jaytakdupeplugin.dupe")){
                        try{
                            ItemStack itemInHand = player.getInventory().getItemInMainHand();
                            if (itemInHand.getType() != Material.AIR){
                                int count = itemInHand.getAmount();
                                int multiplier;
                                int finalAmt = 0;
                                getLogger().info(cTitle + "Player holding: " + itemInHand);
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
                                                sender.sendMessage( pTitle + "§4Invalid Operator: §l" + operator);
                                                return false;
                                        }
                                                                            }
                                    else{
                                        count++;
                                        finalAmt = count;
                                    }
                                }
                                catch (NumberFormatException e){
                                    sender.sendMessage(pTitle + "§4Invalid Multiplier Value: §l" + args[1]);
                                    getLogger().info(cTitle + "Invalid Multiplier Value: " + args[1] + " args: " + Arrays.toString(args));
                                }
                                catch (Exception e){
                                    sender.sendMessage(pTitle + "§4Ran into Exception.");
                                    getLogger().info(cTitle + "Ran into Exception: " + e);
                                }

                                if (finalAmt < 1){
                                    sender.sendMessage(pTitle + "§cHmmmm, seems sus.... Final Amount: §4§l" + finalAmt);
                                    getLogger().info(cTitle + "Unsafe Final Amount: " + finalAmt + ". Clipped to 1.");
                                    finalAmt = 1;
                                    sender.sendMessage(pTitle + "§cLucky for you i thought about this.");
                                    sender.sendMessage(pTitle + "§cFinal Amount Clipped To: §a" + finalAmt);

                                }
                                if (finalAmt > 64){
                                    sender.sendMessage(pTitle + "§4Unsafe Final Amount: §c" + finalAmt + "§4. Capped to §a64§r.");
                                    getLogger().info(cTitle + "Unsafe Final Amount: " + finalAmt + ". Capped to 64.");
                                    finalAmt = 64;
                                }

                                itemInHand.setAmount(finalAmt);
                                getLogger().info(cTitle + "Duped items. Final Amount: " + finalAmt);
                                sender.sendMessage(pTitle + "§2Duped items. Final amount: §a" + finalAmt);
                                return true;
                            }
                            else{
                                sender.sendMessage(pTitle + "§4You need to be holding an item to dupe, cant dupe nothin!");
                                getLogger().info(cTitle + "Player" + username + " was not holding an item.");
                            }
                        }catch (Exception exception){
                            getLogger().info(cTitle + "exception: " + exception);
                        }
                    }
                    else{
                        sender.sendMessage(pTitle + "§4You dont have permission to use this command.");
                    }
                }
            }
        }
        catch (Exception e){
            getLogger().info( cTitle + "Exception: " + e);
        }
    return false;
    }
}
