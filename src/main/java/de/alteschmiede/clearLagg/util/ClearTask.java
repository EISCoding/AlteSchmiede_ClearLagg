package de.alteschmiede.clearLagg.util;

import de.alteschmiede.clearLagg.ClearLagg;
import org.bukkit.Bukkit;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ClearTask {

    public static int timer = 0;

    public static void startClearTask() {
        new BukkitRunnable() {
            @Override
            public void run() {
                timer ++;
                //540 Sekunden bzw. 9 Minuten
                if (timer == 540) {
                    Bukkit.broadcastMessage(ClearLagg.prefix + "§7In §e1 Minute §7werden alle Entities gelöscht!");
                }
                //590 Sekunden bzw. 9 Minuten und 50 Sekunden
                if (timer == 590) {
                    Bukkit.broadcastMessage(ClearLagg.prefix + "§7In §e10 Sekunden §7werden alle Entities gelöscht!");
                }
                //590 Sekunden bzw. 9 Minuten und 55 Sekunden
                if (timer == 595) {
                    Bukkit.broadcastMessage(ClearLagg.prefix + "§7In §e5 Sekunden §7werden alle Entities gelöscht!");
                }
                //600 Sekunden bzw. 10 Minuten
                if (timer >= 600) {
                    //Alle Entities werden auf allen Welten gezählt
                    int removedEntities = Bukkit.getWorlds().stream()
                            .mapToInt(world -> (int) world.getEntities().stream()
                                    //Entities werden gefiltert
                                    .filter(entity -> !isFilter(entity))
                                    .peek(Entity::remove)
                                    .count())
                            .sum();

                    Bukkit.broadcastMessage(ClearLagg.prefix + "§e" + removedEntities + " §7Entities wurden entfernt!");
                    // Timer zurücksetzen und es startet von vorne
                    timer = 0;
                }
            }
        }.runTaskTimer(ClearLagg.instance, 0, 20);
    }

    //ResetTimer Funktion zum zurücksetzen.
    public static void resetTimer() {
        timer = 0;
        ClearLagg.instance.getLogger().info("§cDer Clear-Timer wurde zurückgesetzt, da ein Spieler gestorben ist.");
    }

    //Filter damit keine Spieler, ItemFrames und ArmorStands gelöscht werden.
    //Alles andere wird gelöscht
    private static boolean isFilter(Entity entity) {
        if (entity instanceof ItemFrame) return true;
        if (entity instanceof ArmorStand) return true;
        if (entity instanceof Player) return true;
        return false;
    }

}
