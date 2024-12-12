package de.alteschmiede.clearLagg.events;

import de.alteschmiede.clearLagg.util.ClearTask;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {

    //Prüfung ob ein Spieler gestorben ist ._.

    @EventHandler
    public void on(PlayerDeathEvent event){
        ClearTask.resetTimer();
    }

}
