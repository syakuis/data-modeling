package io.github.syakuis.domain;

/**
 * @author Seok Kyun. Choi.
 * @since 2021-05-21
 */
public interface Account extends ModifiableAccount {
    Long id();

    java.util.UUID uid();

    java.time.LocalDateTime registeredOn();

    java.time.LocalDateTime updatedOn();
}
