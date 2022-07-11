package pl.delivetator.antybot;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class AntybotData {

    static AntybotData instance;
    Plugin p;
    FileConfiguration data;
    public static File rFile;

    static {
        AntybotData.instance = new AntybotData();
    }

    public static AntybotData getInstance() {
        return AntybotData.instance;
    }

    public void setUp(final Plugin p) {
        if (!p.getDataFolder().exists()) {
            p.getDataFolder().mkdir();
        }
        final File path = new File(p.getDataFolder() + File.separator + "/data");
        AntybotData.rFile = new File(path, String.valueOf(String.valueOf(File.separator) + "/antybot.yml"));
        if (AntybotData.rFile.exists()) {
            try {
                path.mkdirs();
                AntybotData.rFile.createNewFile();
            }
            catch (IOException e) {
                Bukkit.getServer().getLogger().severe(ChatColor.RED + "Nie udalo sie stworzyc pliku \"antybot.yml\"");
            }
        }
        this.data = YamlConfiguration.loadConfiguration(AntybotData.rFile);
    }

    public FileConfiguration getData() {
        return this.data;
    }

    public void saveData() {
        try {
            this.data.save(AntybotData.rFile);
        }
        catch (IOException e) {
            Bukkit.getServer().getLogger().severe(ChatColor.RED + "Nie udalo sie zapisac pliku \"antybot.yml\"");
        }
    }

    public void reloadData() {
        this.data = (FileConfiguration)YamlConfiguration.loadConfiguration(AntybotData.rFile);
    }
}
