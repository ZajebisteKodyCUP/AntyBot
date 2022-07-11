package pl.delivetator.antybot;

import java.util.UUID;

public class AntybotAPI {
    AntybotData abd;

    public AntybotAPI() {
        this.abd = AntybotData.getInstance();
    }

    public boolean getAntybot(final UUID uuid) {
        return this.abd.getData().getBoolean("antybot." + uuid);
    }

    public void setAntybot(final UUID uuid) {
        this.abd.getData().set("antybot." + uuid, true);
        this.abd.saveData();
    }

    public void deleteAntybot(final UUID uuid) {
        this.abd.getData().set("antybot." + uuid, null);
        this.abd.saveData();
    }
}
