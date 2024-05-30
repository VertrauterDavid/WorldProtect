package net.vertrauterdavid.worldprotect.listener;

import lombok.RequiredArgsConstructor;
import net.vertrauterdavid.worldprotect.WorldProtect;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

@RequiredArgsConstructor
public class PlayerFishListener implements Listener {

    private final WorldProtect worldProtect;

    @EventHandler
    public void handle(PlayerFishEvent event) {
        if (event.getPlayer().hasPermission("worldprotect.bypass")) return;
        if (!(worldProtect.getConfig().getBoolean("DisableFishing"))) return;

        if (worldProtect.getProtectedWorlds().contains(event.getPlayer().getWorld().getName())) {
            event.setCancelled(true);
        }
    }

}
