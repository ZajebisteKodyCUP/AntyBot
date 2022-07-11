package pl.delivetator.antybot;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Antybot implements CommandExecutor {

    AntybotAPI aba;
    AntybotData abd;

    public Antybot() {
        this.aba = new AntybotAPI();
        this.abd = AntybotData.getInstance();
    }

    public boolean onCommand(final CommandSender sender, final Command arg1, final String arg2, final String[] args) {
        if (args.length == 2) {
            if (args[0].equalsIgnoreCase("add")) {
                final OfflinePlayer op = Bukkit.getOfflinePlayer(args[1]);
                if (!op.isOnline()) {
                    final UUID uuid = op.getUniqueId();
                    if (!this.aba.getAntybot(uuid) || this.abd.getData().getString("antybot" + uuid) == null) {
                        this.aba.setAntybot(uuid);
                        ChatUtil.sendMessage(sender, "&7Gracz &e" + op.getName() + " &7zostal dodany do antybota.");
                    }
                    else {
                        ChatUtil.sendMessage(sender, "&cTen gracz jest juz zweryfikowany antybotem!");
                    }
                }
                else {
                    ChatUtil.sendMessage(sender, "&cGracz nie moze byc na serwerze!");
                }
            }
            else if (args[0].equalsIgnoreCase("remove") || args[0].equalsIgnoreCase("delete")) {
                final OfflinePlayer op = Bukkit.getOfflinePlayer(args[1]);
                if (!op.isOnline()) {
                    final UUID uuid = op.getUniqueId();
                    if (!this.aba.getAntybot(uuid) || this.abd.getData().getString("antybot" + uuid) == null) {
                        this.aba.deleteAntybot(uuid);
                        ChatUtil.sendMessage(sender, "&7Gracz &e" + op.getName() + " &7zostal usuniety z antybota.");
                    }
                    else {
                        ChatUtil.sendMessage(sender, "&cTen gracz jest juz zweryfikowany antybotem!");
                    }
                }
                else {
                    final Player p = Bukkit.getPlayer(args[1]);
                    final UUID uuid2 = p.getUniqueId();
                    if (!this.aba.getAntybot(uuid2) || this.abd.getData().getString("antybot" + uuid2) == null) {
                        this.aba.deleteAntybot(uuid2);
                        ChatUtil.sendMessage(sender, "&7Gracz &e" + p.getName() + " &7zostal usuniety z antybota.");
                    }
                    else {
                        ChatUtil.sendMessage(sender, "&cTen gracz nie jest dodany do antybota!");
                    }
                }
            }
            else {
                ChatUtil.sendMessage(sender, "&7Uzycie: &e/antybot &8<&eadd&8/&eremove&8> <&egracz&8>");
            }
        }
        else {
            ChatUtil.sendMessage(sender, "&7Uzycie: &e/antybot &8<&eadd&8/&eremove&8> <&egracz&8>");
        }
        return false;
    }
}
