package pl.afyaan.command;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import pl.afyaan.Messages;
import pl.afyaan.command.disable.DisableCommands;

public class PlayerCommandListener implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerCommand(PlayerCommandPreprocessEvent e){
        String[] args = e.getMessage().split(" ");
        Player player = e.getPlayer();

        String command = args[0].replaceFirst("/", "");

        for(Command cmd : CommandManager.getCommandList()){
            if(cmd.getName().equalsIgnoreCase(command) || cmd.aliasExists(command)){
                if(cmd.getPermission() != null){
                    if(player.hasPermission(cmd.getPermission())){
                        cmd.onExecute(e.getPlayer(), args);
                        e.setCancelled(true);
                    }else {
                        player.sendMessage(Messages.COMMAND_NO_PERMISSION);
                        e.setCancelled(true);
                    }
                }else {
                    cmd.onExecute(e.getPlayer(), args);
                    e.setCancelled(true);
                }
            }
        }
        if(!player.isOp()) {
            if (!CommandManager.commandExists(command) && !CommandManager.commandAliasExists(command)) {
                if (!DisableCommands.commandExists(command)) {
                    player.sendMessage(Messages.UNKNOWN_COMMAND);
                    e.setCancelled(true);
                }
            }
        }
    }
}

