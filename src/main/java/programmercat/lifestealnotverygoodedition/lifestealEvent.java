package programmercat.lifestealnotverygoodedition;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.lang.annotation.Annotation;

public class lifestealEvent implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerDeath(PlayerDeathEvent event) {
        //if getKiller() does not return null (if the player was killed by another player)
        if (event.getEntity().getKiller() != null) {

            //Player entities
            Player player = event.getEntity();
            Player killer = event.getEntity().getKiller();

            //check if the target is on more than 1 heart
            if (player.getMaxHealth() >= 4) {
                //life exchange
                player.setMaxHealth(player.getMaxHealth() - 2.0);
                killer.setMaxHealth(killer.getMaxHealth() + 2.0);
            }

        } else {

            //getKiller() returned null (player was not killed by another player)

            Player player = event.getEntity();

            if (player.getMaxHealth() >= 4) {
                player.setMaxHealth(player.getMaxHealth() - 2.0);
            }

        }
    }

}
