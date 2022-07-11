package pl.delivetator.antybot;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatUtil {
    public static final String fixColor(final String name) {
        return name.replace(">>", "»").replace("&", "§").replace("<<", "«");
    }

    public static final void sendMessage(final Player p, final String t) {
        p.sendMessage(fixColor(t));
    }

    public static final void sendMessage(final CommandSender sender, final String s) {
        sender.sendMessage(fixColor(s));
    }

    public static final void broadcastMessage(final String name) {
        Bukkit.broadcastMessage(fixColor(name));
    }

    public static final String locToString(final Location loc) {
        return String.valueOf(loc.getX()) + ":" + loc.getY() + ":" + loc.getZ() + ":" + loc.getYaw() + ":" + loc.getPitch();
    }

    public static final Location locFromString(final String str) {
        final String[] str2loc = str.split(":");
        final Location loc = new Location(Bukkit.getWorlds().get(0), 0.0, 0.0, 0.0, 0.0f, 0.0f);
        loc.setX(Double.parseDouble(str2loc[0]));
        loc.setY(Double.parseDouble(str2loc[1]));
        loc.setZ(Double.parseDouble(str2loc[2]));
        loc.setYaw(Float.parseFloat(str2loc[3]));
        loc.setPitch(Float.parseFloat(str2loc[4]));
        return loc;
    }

    public static String getPerms(final String name) {
        return Main.getInst().getConfig().getString("permission." + name);
    }

    public static final boolean getPermission(final Player p, final String name) {
        return p.hasPermission(name);
    }

    public static final boolean getPermission(final CommandSender sender, final String name) {
        return sender.hasPermission(name);
    }
}
