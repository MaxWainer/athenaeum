package com.athenaeum.bukkit.plugin.builder;

import org.bukkit.command.Command;

public interface IPlugin {

    <T extends Command> T registerCommand(T command);

}
