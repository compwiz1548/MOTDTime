package com.compwiz1548.MOTDTime;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

/**
 * Created by Todd on 6/23/2015.
 */
public class MOTDListener implements Listener {
    @EventHandler(priority = EventPriority.HIGH)
    public void onServerListPing(ServerListPingEvent event){
        String currentMOTD = MOTDTime.plugin.getServer().getMotd();
        World w = Bukkit.getWorld(MOTDTime.server.getWorlds().get(0).getName());
        long gameTime = w.getTime();
        long hours = gameTime / 1000 + 6;
        long minutes = (gameTime % 1000) * 60 / 1000;
        String ampm = "AM";
        if(hours >= 12)
        {
            hours -= 12;
            ampm = "PM";
        }
        if(hours >= 12)
        {
            hours -= 12;
            ampm = "AM";
        }
        if(hours == 0)
            hours = 12;
        String mm = "0" + minutes;
        mm = mm.substring(mm.length() - 2, mm.length());
        String currentTime =  hours + ":" + mm + " " + ampm;
        ChatColor color = ChatColor.RED;
        if(((hours >= 6 && hours < 12 && ampm.equalsIgnoreCase("AM")) || (hours == 12 && ampm.equalsIgnoreCase("PM")) || (hours >= 1 && hours < 7 && ampm.equalsIgnoreCase("PM"))))
            color = ChatColor.GREEN;
        currentMOTD = currentMOTD + "\nThe time is currently " + ChatColor.BOLD + color + currentTime;
        event.setMotd(currentMOTD);
    }
}
