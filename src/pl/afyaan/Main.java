package pl.afyaan;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import pl.afyaan.command.CommandManager;
import pl.afyaan.command.PlayerCommandListener;
import pl.afyaan.command.commands.CommandTest;
import pl.afyaan.command.disable.DisableCommandListener;
import pl.afyaan.command.disable.DisableCommands;

public class Main extends JavaPlugin {
    public static Main instance;
    @Override
    public void onEnable() {
        instance = this;
        initCore();


    }

    private static void initCore(){
        CommandManager.registerCommand(new CommandTest());

        DisableCommands.addDisableCommand("/bukkit:pl", ChatColor.WHITE + "Plugins (0):");
        DisableCommands.addDisableCommand("/bukkit:plugins",ChatColor.WHITE + "Plugins (0):");
        DisableCommands.addDisableCommand("/bukkit:reload");
        DisableCommands.addDisableCommand("/bukkit:rl");
        DisableCommands.addDisableCommand("/bukkit:timings");
        DisableCommands.addDisableCommand("/bukkit:ver");
        DisableCommands.addDisableCommand("/bukkit:version");
        DisableCommands.addDisableCommand("/stop");
        DisableCommands.addDisableCommand("/rl");
        DisableCommands.addDisableCommand("/reload");
        DisableCommands.addDisableCommand("/pl", ChatColor.WHITE + "Plugins (0):").setForAll(false);
        DisableCommands.addDisableCommand("/plugins", ChatColor.WHITE + "Plugins (0):").setForAll(false);
        DisableCommands.addDisableCommand("/me");
        DisableCommands.addDisableCommand("/op").setForAll(false);
        DisableCommands.addDisableCommand("/deop").setForAll(false);

        instance.getServer().getPluginManager().registerEvents(new PlayerCommandListener(), instance);
        instance.getServer().getPluginManager().registerEvents(new DisableCommandListener(), instance);
    }
}
