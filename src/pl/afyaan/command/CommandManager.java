package pl.afyaan.command;

import java.util.ArrayList;
import java.util.List;

public class CommandManager {
    private static List<Command> commandList = new ArrayList<>();

    public static void registerCommand(Command cmd){
        commandList.add(cmd);
    }

    public static List<Command> getCommandList(){
        return commandList;
    }

    public static boolean commandExists(String command){
        for(Command cmd : commandList){
            if(cmd.getName().equalsIgnoreCase(command)){
                return true;
            }
        }
        return false;
    }

    public static boolean commandAliasExists(String command){
        for(Command cmd : commandList){
            if(cmd.aliasExists(command)){
                return true;
            }
        }
        return false;
    }
}