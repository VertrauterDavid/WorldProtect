package net.vertrauterdavid.worldprotect.listener;

import lombok.RequiredArgsConstructor;
import net.vertrauterdavid.worldprotect.WorldProtect;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;
import org.bukkit.event.player.PlayerInteractEvent;

@RequiredArgsConstructor
public class PlayerInteractListener implements Listener {

    private final WorldProtect worldProtect;

    @EventHandler
    public void handle(PlayerInteractEvent event) {
        if (event.getPlayer().hasPermission("worldprotect.bypass")) return;
        if (!(worldProtect.getConfig().getBoolean("BlockInteract.Disabled"))) return;

        if (worldProtect.getProtectedWorlds().contains(event.getPlayer().getWorld().getName())) {
            if (event.getClickedBlock() != null && !(worldProtect.getConfig().getStringList("BlockInteract.Whitelisted").contains(event.getClickedBlock().getType().name()))) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void handle(PlayerBucketEmptyEvent event) {
        if (event.getPlayer().hasPermission("worldprotect.bypass")) return;
        if (!(worldProtect.getConfig().getBoolean("BlockInteract.Disabled"))) return;

        if (worldProtect.getProtectedWorlds().contains(event.getPlayer().getWorld().getName())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void handle(PlayerBucketFillEvent event) {
        if (event.getPlayer().hasPermission("worldprotect.bypass")) return;
        if (!(worldProtect.getConfig().getBoolean("BlockInteract.Disabled"))) return;

        if (worldProtect.getProtectedWorlds().contains(event.getPlayer().getWorld().getName())) {
            event.setCancelled(true);
        }
    }

}
