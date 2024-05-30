package net.vertrauterdavid.worldprotect.listener;

import lombok.RequiredArgsConstructor;
import net.vertrauterdavid.worldprotect.WorldProtect;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

@RequiredArgsConstructor
public class BlockBreakListener implements Listener {

    private final WorldProtect worldProtect;

    @EventHandler
    public void handle(BlockBreakEvent event) {
        if (event.getPlayer().hasPermission("worldprotect.bypass")) return;
        if (!(worldProtect.getConfig().getBoolean("DisableBlockBreak"))) return;

        if (worldProtect.getProtectedWorlds().contains(event.getBlock().getWorld().getName())) {
            event.setCancelled(true);
        }
    }

}
