package net.vertrauterdavid.worldprotect;

import lombok.Getter;
import net.vertrauterdavid.worldprotect.listener.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

@Getter
public class WorldProtect extends JavaPlugin {

    private final List<String> protectedWorlds = new ArrayList<>();

    @Override
    public void onEnable() {
        saveDefaultConfig();

        protectedWorlds.addAll(getConfig().getStringList("ProtectedWorlds"));

        Bukkit.getPluginManager().registerEvents(new BlockBreakListener(this), this);
        Bukkit.getPluginManager().registerEvents(new BlockPlaceListener(this), this);
        Bukkit.getPluginManager().registerEvents(new CreatureSpawnListener(this), this);
        Bukkit.getPluginManager().registerEvents(new EnderPearlListener(this), this);
        Bukkit.getPluginManager().registerEvents(new EntityDamageListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerDeathListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerDropItemListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerPickupItemListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerFishListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInteractEntityListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInteractListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerItemFrameChangeListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerPortalListener(this), this);
    }

}
