package pl.afyaan.command.disable;

import net.md_5.bungee.api.chat.TextComponent;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DisableCommands {
    private String cmd;
    private List<TextComponent> text;
    private boolean forAll;

    public DisableCommands(String cmd) {
        this.cmd = cmd;
        this.text = null;
        this.forAll = true;
    }

    public DisableCommands(String cmd, String text) {
        this.cmd = cmd;
        this.text = new CopyOnWriteArrayList<>();
        this.text.add(new TextComponent(text));
        this.forAll = true;
    }

    public DisableCommands(String cmd, List<TextComponent> text) {
        this.cmd = cmd;
        this.text = text;
    }

    public String getCmd() {
        return cmd;
    }

    public List<TextComponent> getText() {
        return text;
    }

    public void setForAll(boolean value){
        this.forAll = value;
    }

    public boolean isForAll() {
        return forAll;
    }

    private static List<DisableCommands> cmdList = new CopyOnWriteArrayList<>();

    public static List<DisableCommands> getCmdList() {
        return cmdList;
    }

    public static DisableCommands addDisableCommand(String cmd) {
        cmdList.add(new DisableCommands(cmd));
        return getDisableCommand(cmd);
    }

    public static DisableCommands addDisableCommand(String cmd, String text) {
        cmdList.add(new DisableCommands(cmd, text));
        return getDisableCommand(cmd);
    }

    public static DisableCommands addDisableCommand(String cmd, List<TextComponent> text) {
        cmdList.add(new DisableCommands(cmd, text));
        return getDisableCommand(cmd);
    }

    public static DisableCommands addDisableCommand(DisableCommands dc) {
        cmdList.add(dc);
        return dc;
    }

    public static DisableCommands getDisableCommand(String command){
        for(DisableCommands dc : cmdList){
            if(dc.getCmd().equalsIgnoreCase(command)){
                return dc;
            }
        }
        return null;
    }

    public static boolean commandExists(String command){
        for(DisableCommands dc : cmdList){
            if(dc.getCmd().equalsIgnoreCase("/" + command)){
                return true;
            }
        }
        return false;
    }
}