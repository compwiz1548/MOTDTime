package com.compwiz1548.MOTDTime;

import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Todd on 6/23/2015.
 */
public class MOTDTime extends JavaPlugin {

    public static volatile MOTDTime plugin = null;
    public static Server server;

    @Override
    public void onEnable(){
        //Fired when the server enables the plugin
        if (plugin == null)
            plugin = this;
        server = getServer();

        server.getPluginManager().registerEvents(new MOTDListener(), this);
    }

    @Override
    public void onDisable(){
        //Fired when the server stops and disables the plugin
    }

    public String colorize(String msg)
    {
        String coloredMsg = "";
        for(int i = 0; i < msg.length(); i++)
        {
            if(msg.charAt(i) == '&')
                coloredMsg += '§';
            else
                coloredMsg += msg.charAt(i);
        }
        return coloredMsg;
    }
}
