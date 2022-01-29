package programmercat.lifestealnotverygoodedition;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetRerollCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            return true;
        }

        Player player = (Player) sender;

        if (!player.isOp()) {
            return true;
        }

        player.getInventory().addItem(ItemManager.rerollItem);

        return true;
    }
}
