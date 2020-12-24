package com.athenaeum.bukkit.plugin;

import com.athenaeum.bukkit.plugin.builder.IPlugin;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class AthenaeumPlugin extends JavaPlugin implements IPlugin {

    protected void pluginLoading() {}
    protected void pluginEnabling() {}
    protected void pluginDisabling() {}

    public void loadDataFolder() {
        if(!getDataFolder().exists())
            getDataFolder().mkdir();
    }

}
