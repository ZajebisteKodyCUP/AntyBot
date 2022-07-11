package pl.delivetator.antybot;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

public class PlayerJoin implements Listener {

    Main plugin;
    AntybotData abd;
    AntybotAPI aba;

    public PlayerJoin(final Main m) {
        this.abd = AntybotData.getInstance();
        this.aba = new AntybotAPI();
        this.plugin = m;
    }

    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        final UUID uuid = p.getUniqueId();
        final String prefix = ChatUtil.fixColor(this.plugin.getConfig().getString("prefix"));
        if (!p.hasPlayedBefore()) {
            if (this.abd.getData().getString("antybot." + uuid) == null || !this.aba.getAntybot(uuid)) {
                this.aba.setAntybot(uuid);
                p.kickPlayer(ChatUtil.fixColor("§8§m-------" + prefix + "§8§m-------\n\n§7Witaj §e" + p.getName() + "\n§7Zostales §a§lZWERYFIKOWANY\n§7Wejdz ponownie na serwer\n\n§8§m-------" + prefix + "§8§m-------"));
            }
        }
        else if (this.abd.getData().getString("antybot." + uuid) == null || !this.aba.getAntybot(uuid)) {
            this.aba.setAntybot(uuid);
            p.kickPlayer(ChatUtil.fixColor("§8§m-------" + prefix + "§8§m-------\n\n§7Witaj §e" + p.getName() + "\n§7Zostales §a§lZWERYFIKOWANY\n§7Wejdz ponownie na serwer\n\n§8§m-------" + prefix + "§8§m-------"));
        }
    }
}
