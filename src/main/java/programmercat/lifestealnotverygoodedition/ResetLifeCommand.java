package programmercat.lifestealnotverygoodedition;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ResetLifeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            return true;
        }

        if (args.length < 1) {
            return true;
        }

        Player player = (Player) sender;

        if (sender.isOp()) {

            Player target = Bukkit.getPlayer(args[0]);

            target.setMaxHealth(20.0);

            player.sendMessage("reset " + target.getName() + " hearts");

        }

        return true;
    }
}
