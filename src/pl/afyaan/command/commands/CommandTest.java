package pl.afyaan.command.commands;

import org.bukkit.entity.Player;
import pl.afyaan.command.Command;

/**
 * @author AFYaan
 * @created 01.11.2021
 * @project CommandExecutor
 */
public class CommandTest extends Command {
    public CommandTest() {
        super("test");
        addAlias("test2");
        addAlias("testowakomenda");
    }

    @Override
    public void onExecute(Player player, String[] args) {
        player.sendMessage("Test testowej komendy");
    }
}
