package net.vertrauterdavid.worldprotect.listener;

import lombok.RequiredArgsConstructor;
import net.vertrauterdavid.worldprotect.WorldProtect;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

@RequiredArgsConstructor
public class CreatureSpawnListener implements Listener {

    private final WorldProtect worldProtect;

    @EventHandler
    public void handle(CreatureSpawnEvent event) {
        if (!(worldProtect.getConfig().getBoolean("DisableCreatureSpawn"))) return;

        if (worldProtect.getProtectedWorlds().contains(event.getEntity().getWorld().getName())) {
            if (event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.BREEDING || event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.SPAWNER || event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.EGG || event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.NATURAL || event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.RAID || event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.ENDER_PEARL) {
                event.setCancelled(true);
            }
        }
    }

}
