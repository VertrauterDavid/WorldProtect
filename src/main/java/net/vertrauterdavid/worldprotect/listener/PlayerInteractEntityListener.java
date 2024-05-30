package net.vertrauterdavid.worldprotect.listener;

import lombok.RequiredArgsConstructor;
import net.vertrauterdavid.worldprotect.WorldProtect;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

@RequiredArgsConstructor
public class PlayerInteractEntityListener implements Listener {

    private final WorldProtect worldProtect;

    @EventHandler
    public void handle(PlayerInteractEntityEvent event) {
        check(event);
    }

    @EventHandler
    public void handle(PlayerInteractAtEntityEvent event) {
        check(event);
    }

    private void check(PlayerInteractEntityEvent event) {
        if (event.getPlayer().hasPermission("worldprotect.bypass")) return;
        if (!(worldProtect.getConfig().getBoolean("EntityInteract.Disabled"))) return;

        if (worldProtect.getProtectedWorlds().contains(event.getPlayer().getWorld().getName())) {
            if (worldProtect.getConfig().getStringList("EntityInteract.Whitelisted").contains(event.getRightClicked().getType().name())) return;
            event.setCancelled(true);
        }
    }

}
