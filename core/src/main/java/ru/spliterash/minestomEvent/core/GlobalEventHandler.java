package ru.spliterash.minestomEvent.core;

/**
 * Object containing all the global event listeners.
 */
public final class GlobalEventHandler extends EventNodeImpl<Event> {
    public GlobalEventHandler() {
        super("global", EventFilter.ALL, null);
    }
}
