package de.alteschmiede.clearLagg;

import de.alteschmiede.clearLagg.events.PlayerDeathListener;
import de.alteschmiede.clearLagg.util.ClearTask;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ClearLagg extends JavaPlugin {

    public static ClearLagg instance;
    public static String prefix = "§8[§9\uD83D\uDDD1§8] §r";

    /*
    Hallo AlteSchmiede Team,
    ich hoffe euch wird das Plugin etwas nutzen.
    Ich habe es so simple wie möglich gehalten
    und euch alles Kommentiert falls Fragen aufkommen.

    Grüüüüüßeeee
     */

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("\n" + "   ____ _                 _                      \n" +
                "  / ___| | ___  __ _ _ __| |    __ _  __ _  __ _ \n" +
                " | |   | |/ _ \\/ _` | '__| |   / _` |/ _` |/ _` |\n" +
                " | |___| |  __/ (_| | |  | |__| (_| | (_| | (_| |\n" +
                "  \\____|_|\\___|\\__,_|_|  |_____\\__,_|\\__, |\\__, |\n" +
                "                                     |___/ |___/ ");
        getLogger().info("Plugin geladen");
        Bukkit.getPluginManager().registerEvents(new PlayerDeathListener(), instance);
        ClearTask.startClearTask();
        getLogger().info("ClearTask wurde gestartet!");
    }

    @Override
    public void onDisable() {
        instance = null;
        getLogger().info("\n" + "   ____ _                 _                      \n" +
                "  / ___| | ___  __ _ _ __| |    __ _  __ _  __ _ \n" +
                " | |   | |/ _ \\/ _` | '__| |   / _` |/ _` |/ _` |\n" +
                " | |___| |  __/ (_| | |  | |__| (_| | (_| | (_| |\n" +
                "  \\____|_|\\___|\\__,_|_|  |_____\\__,_|\\__, |\\__, |\n" +
                "                                     |___/ |___/ ");
        getLogger().info("Plugin entladen");
    }
}
