package pl.afyaan.command.disable;

import org.bukkit.event.Listener;

import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import pl.afyaan.Messages;
import pl.afyaan.command.CommandManager;

public class DisableCommandListener implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onDisableCommand(PlayerCommandPreprocessEvent e){
        String[] args = e.getMessage().split(" ");
        Player player = e.getPlayer();

        for(DisableCommands cmd : DisableCommands.getCmdList()){
            if(cmd.getCmd().equalsIgnoreCase(args[0])){
                if(cmd.isForAll() && !CommandManager.commandAliasExists(cmd.getCmd().replace("/", "")) && !CommandManager.commandExists(cmd.getCmd().replace("/", " "))){
                    player.sendMessage(Messages.UNKNOWN_COMMAND);
                    e.setCancelled(true);
                    return;
                }
                if(!player.hasPermission("bhc.disablecommands")){
                    if(cmd.getText() != null){
                        StringBuilder sb = new StringBuilder();

                        for(TextComponent str : cmd.getText()){
                            sb.append("\n" + str);
                        }

                        TextComponent[] tcA = new TextComponent[cmd.getText().size()];
                        tcA = cmd.getText().toArray(tcA);

                        player.spigot().sendMessage(tcA);
                        e.setCancelled(true);
                    }else {
                        if(!CommandManager.commandAliasExists(cmd.getCmd().replace("/", "")) && !CommandManager.commandExists(cmd.getCmd().replace("/", ""))){
                            player.sendMessage(Messages.UNKNOWN_COMMAND);
                            e.setCancelled(true);
                        }
                    }
                }
            }
        }
    }
}
