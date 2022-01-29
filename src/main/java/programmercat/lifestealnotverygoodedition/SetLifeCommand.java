package programmercat.lifestealnotverygoodedition;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetLifeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            return true;
        }

        //check argument length
        if (args.length < 2) {
            return true;
        }

        Player player = (Player) sender;

        //operator check
        if (player.isOp()) {

            Player target = Bukkit.getPlayer(args[0]);
            int hearts = Integer.valueOf(args[1]);

            target.setMaxHealth(hearts * 2);

            //player message
            player.sendMessage("set " + target.getName()+ "s hearts to " + hearts);

        }

        return true;
    }
}
