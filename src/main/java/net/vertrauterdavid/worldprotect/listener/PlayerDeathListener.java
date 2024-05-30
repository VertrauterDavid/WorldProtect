package net.vertrauterdavid.worldprotect.listener;

import lombok.RequiredArgsConstructor;
import net.vertrauterdavid.worldprotect.WorldProtect;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

@RequiredArgsConstructor
public class PlayerDeathListener implements Listener {

    private final WorldProtect worldProtect;

    @EventHandler
    public void handle(PlayerDeathEvent event) {
        if (event.getPlayer().hasPermission("worldprotect.bypass")) return;
        if (!(worldProtect.getConfig().getBoolean("KeepInventory"))) return;

        if (worldProtect.getProtectedWorlds().contains(event.getPlayer().getWorld().getName())) {
            event.setKeepInventory(true);
            event.setKeepLevel(true);
            event.getDrops().clear();
            event.setDroppedExp(0);
        }
    }

}
