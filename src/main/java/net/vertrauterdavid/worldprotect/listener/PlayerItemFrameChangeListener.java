package net.vertrauterdavid.worldprotect.listener;

import io.papermc.paper.event.player.PlayerItemFrameChangeEvent;
import lombok.RequiredArgsConstructor;
import net.vertrauterdavid.worldprotect.WorldProtect;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

@RequiredArgsConstructor
public class PlayerItemFrameChangeListener implements Listener {

    private final WorldProtect worldProtect;

    @EventHandler
    public void handle(PlayerItemFrameChangeEvent event) {
        if (event.getPlayer().hasPermission("worldprotect.bypass")) return;
        if (!(worldProtect.getConfig().getBoolean("DisableItemFrameInteract"))) return;

        if (worldProtect.getProtectedWorlds().contains(event.getItemFrame().getWorld().getName())) {
            event.setCancelled(true);
        }
    }

}
