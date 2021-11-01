package pl.afyaan.command;

import org.bukkit.entity.Player;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public abstract class Command implements ICommand {
    private String name;
    private String description;
    private String permission;
    private List<String> alias;
    private int delay;

    public Command(String name) {
        this.name = name;
        this.alias = new CopyOnWriteArrayList<>();
        this.delay = 5000;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Command setDescription(String description) {
        this.description = description;
        return this;
    }
    public Command setDescription(List<String> description){
        this.description = String.join("\n", description);

        return this;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public List<String> getAlias() {
        return alias;
    }

    public void addAlias(String alias) {
        this.alias.add(alias);
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public boolean aliasExists(String command){
        for(String alias : alias){
            if(alias.equalsIgnoreCase(command)){
                return true;
            }
        }
        return false;
    }

}
