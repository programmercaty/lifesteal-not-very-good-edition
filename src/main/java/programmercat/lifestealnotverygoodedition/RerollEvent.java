package programmercat.lifestealnotverygoodedition;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Random;

public class RerollEvent implements Listener {

    @EventHandler
    public static void onRightClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR ||
            event.getAction() == Action.RIGHT_CLICK_BLOCK) {

            if (event.getItem() != null) {

                if (event.getPlayer().getItemInHand() == null) {
                    return;
                }

                if (event.getPlayer().getItemInHand().getItemMeta().equals(ItemManager.rerollItem.getItemMeta())) {

                    Player player = event.getPlayer();

                    Random rand = new Random();

                    player.setMaxHealth(6*2 + rand.nextInt(6*2));

                    player.sendMessage("Rerolled hearts");

                    if (event.getItem().getAmount() > 1) {
                        event.getItem().setAmount(event.getItem().getAmount() - 1);
                    } else {
                        player.getInventory().remove(event.getItem());
                    }
                }
            }
        }
    }

}
