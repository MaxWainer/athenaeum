package com.athenaeum.plugin.builder;

import org.bukkit.command.Command;

public interface IPlugin {

    <T extends Command> T registerCommand(T command, String name, String description, String[] aliases);


}
