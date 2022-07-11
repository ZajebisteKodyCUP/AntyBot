package pl.delivetator.antybot;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.command.Command;
import org.bukkit.plugin.java.annotation.command.Commands;
import org.bukkit.plugin.java.annotation.plugin.ApiVersion;
import org.bukkit.plugin.java.annotation.plugin.Description;
import org.bukkit.plugin.java.annotation.plugin.Plugin;
import org.bukkit.plugin.java.annotation.plugin.author.Author;

@Plugin(name = "Antybot", version = "0.1")
@Author("Delivetator")
@Description("Plugin for Antybot")
@ApiVersion(ApiVersion.Target.v1_13)
@Commands(@Command(name = "antybot"))
public class Main extends JavaPlugin {

    AntybotData abd;
    static Main main;

    public Main() {
        this.abd = AntybotData.getInstance();
    }

    @Override
    public void onEnable() {
        this.abd.setUp(this);
        Main.main = this;
        this.getCommand("antybot").setExecutor(new Antybot());
        this.getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
    }

    public static Main getInst() {
        return Main.main;
    }
}
