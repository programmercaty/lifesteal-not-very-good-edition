package programmercat.lifestealnotverygoodedition;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class lifesteal extends JavaPlugin {

    @Override
    public void onEnable() {

        //init ItemManager
        ItemManager.init();

        //register event listeners
        getServer().getPluginManager().registerEvents(new lifestealEvent(), this);
        getServer().getPluginManager().registerEvents(new RerollEvent(), this);

        //register command executors
        getCommand("reset").setExecutor(new ResetLifeCommand());
        getCommand("setHearts").setExecutor(new SetLifeCommand());
        getCommand("rerollItem").setExecutor(new GetRerollCommand());
    }

    @Override
    public void onDisable() {

    }

}
