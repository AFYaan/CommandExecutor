package pl.afyaan.command;

import org.bukkit.entity.Player;

public interface ICommand {
    void onExecute(Player player, String[] args);
}
