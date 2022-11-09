package ru.spliterash.minestomEvent.core.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Convenient class to check for common exceptions.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Check {
    @Contract("true, _ -> fail")
    public static void stateCondition(boolean condition, @NotNull String reason) {
        if (condition) {
            throw new IllegalStateException(reason);
        }
    }
}
