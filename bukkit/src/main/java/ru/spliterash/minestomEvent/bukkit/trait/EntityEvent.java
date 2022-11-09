package ru.spliterash.minestomEvent.bukkit.trait;

import org.bukkit.entity.Entity;
import org.jetbrains.annotations.NotNull;
import ru.spliterash.minestomEvent.core.Event;

/**
 * Represents any event called on an {@link Entity}.
 */
public interface EntityEvent extends Event {

    /**
     * Gets the entity of this event.
     *
     * @return the entity
     */
    @NotNull Entity getEntity();
}
