package net.vertrauterdavid.worldprotect.listener;

import lombok.RequiredArgsConstructor;
import net.vertrauterdavid.worldprotect.WorldProtect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

@RequiredArgsConstructor
public class EntityDamageListener implements Listener {

    private final WorldProtect worldProtect;

    @EventHandler
    public void handle(EntityDamageEvent event) {
        if (event.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK) return;
        if (event.getCause() == EntityDamageEvent.DamageCause.WORLD_BORDER) return;
        if (!(worldProtect.getConfig().getBoolean("DisableDamage"))) return;

        if (worldProtect.getProtectedWorlds().contains(event.getEntity().getWorld().getName())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void handle(EntityDamageByEntityEvent event) {
        if (event.getCause() == EntityDamageEvent.DamageCause.WORLD_BORDER) return;
        if (!(worldProtect.getConfig().getBoolean("DisableDamage"))) return;

        if (worldProtect.getProtectedWorlds().contains(event.getEntity().getWorld().getName())) {
            if (event.getDamager() instanceof Player damager) {
                if (damager.hasPermission("worldprotect.bypass")) return;
            }
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void handle(EntityDamageByBlockEvent event) {
        if (event.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK) return;
        if (event.getCause() == EntityDamageEvent.DamageCause.WORLD_BORDER) return;
        if (!(worldProtect.getConfig().getBoolean("DisableDamage"))) return;

        if (worldProtect.getProtectedWorlds().contains(event.getEntity().getWorld().getName())) {
            event.setCancelled(true);
        }
    }

}
