package net.vertrauterdavid.worldprotect.listener;

import lombok.RequiredArgsConstructor;
import net.vertrauterdavid.worldprotect.WorldProtect;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

@RequiredArgsConstructor
public class BlockPlaceListener implements Listener {

    private final WorldProtect worldProtect;

    @EventHandler
    public void handle(BlockPlaceEvent event) {
        if (event.getPlayer().hasPermission("worldprotect.bypass")) return;
        if (!(worldProtect.getConfig().getBoolean("DisableBlockPlace"))) return;

        if (worldProtect.getProtectedWorlds().contains(event.getBlock().getWorld().getName())) {
            event.setCancelled(true);
        }
    }

}
