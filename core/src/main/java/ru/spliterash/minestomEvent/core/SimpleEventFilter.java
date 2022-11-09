package ru.spliterash.minestomEvent.core;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

@RequiredArgsConstructor
public class SimpleEventFilter<E extends Event, H> implements EventFilter<E, H> {
    private final Class<E> eventType;
    private final Class<H> handlerType;
    private final Function<E, H> handlerGetter;

    @Override
    public @Nullable H getHandler(@NotNull E event) {
        return handlerGetter != null ? handlerGetter.apply(event) : null;
    }

    @Override
    public @NotNull Class<E> eventType() {
        return eventType;
    }

    @Override
    public @Nullable Class<H> handlerType() {
        return handlerType;
    }
}
