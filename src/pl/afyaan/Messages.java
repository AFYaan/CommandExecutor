package pl.afyaan;

import org.bukkit.ChatColor;

/**
 * @author AFYaan
 * @created 01.11.2021
 * @project CommandExecutor
 */
public class Messages {
    public static String PREFIX = ChatColor.GRAY + "" + ChatColor.BOLD + " » ";
    public static String COMMAND_NO_PERMISSION = PREFIX + ChatColor.RED + "Nie masz uprawnien do tej komendy!";
    public static String UNKNOWN_COMMAND = ChatColor.GRAY + "" + ChatColor.BOLD + " » " + ChatColor.RED + "" + ChatColor.BOLD +  "Nie ma takiej komendy.";
}
