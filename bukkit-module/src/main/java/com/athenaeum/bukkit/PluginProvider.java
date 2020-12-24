package com.athenaeum.bukkit;

import com.athenaeum.bukkit.plugin.AthenaeumPlugin;
import lombok.Getter;

import java.io.File;

public class PluginProvider {

    @Getter
    private static PluginProvider instance;
    @Getter
    private static AthenaeumPlugin providing;

    public PluginProvider(AthenaeumPlugin plugin) {
        providing = plugin;
    }

    public File getLibraryFolder() {
        return new File("plugins/Athenaeum");
    }

}
