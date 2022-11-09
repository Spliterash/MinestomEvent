package ru.spliterash.minestomEvent.bukkit;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import ru.spliterash.minestomEvent.bukkit.trait.EntityEvent;
import ru.spliterash.minestomEvent.bukkit.trait.PlayerEvent;
import ru.spliterash.minestomEvent.core.EventFilter;

import static ru.spliterash.minestomEvent.core.EventFilter.from;

public class BukkitEventFilters {
    public static final EventFilter<EntityEvent, Entity> ENTITY = from(EntityEvent.class, Entity.class, EntityEvent::getEntity);
    public static final EventFilter<PlayerEvent, Player> PLAYER = from(PlayerEvent.class, Player.class, PlayerEvent::getPlayer);

}
