package net.vertrauterdavid.worldprotect.listener;

import lombok.RequiredArgsConstructor;
import net.vertrauterdavid.worldprotect.WorldProtect;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

@RequiredArgsConstructor
public class PlayerDropItemListener implements Listener {

    private final WorldProtect worldProtect;

    @EventHandler
    public void handle(PlayerDropItemEvent event) {
        if (event.getPlayer().hasPermission("worldprotect.bypass")) return;
        if (!(worldProtect.getConfig().getBoolean("DisableItemDrop"))) return;

        if (worldProtect.getProtectedWorlds().contains(event.getItemDrop().getWorld().getName())) {
            event.setCancelled(true);
        }
    }

}
