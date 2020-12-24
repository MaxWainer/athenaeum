package com.athenaeum.bukkit;

import com.athenaeum.bukkit.plugin.AthenaeumPlugin;
import lombok.Getter;
import org.bukkit.plugin.PluginDescriptionFile;

import java.io.File;

public class PluginProvider {

    @Getter
    private static PluginProvider instance;
    @Getter
    private static AthenaeumPlugin providing;

    public PluginProvider(AthenaeumPlugin plugin) {
        providing = plugin;
    }

    // Max_Wainer start

    public File getLibraryFolder() {
        return new File("athenaeumAddons/" + providing.getName());
    }

    public void loadLibraryFolder() {
        if(!getLibraryFolder().exists())
            getLibraryFolder().mkdir();
    }

    public File getProvidingFolder() {
        return getProviding().getDataFolder();
    }

    public String getProvidingName() {
        return getProviding().getName();
    }

    public PluginDescriptionFile getProvidingDescription() {
        return getProviding().getDescription();
    }

    // Max_Wainer end

}
