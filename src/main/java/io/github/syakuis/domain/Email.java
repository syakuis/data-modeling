package io.github.syakuis.domain;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-08-17
 */
public interface Email {
    String localPart();

    String domain();

    java.time.LocalDateTime verifiedOn();

    default boolean isVerified() {
        return verifiedOn() != null;
    }

    default String value() {
        if (localPart() != null && domain() != null) {
            return localPart() + "@" + domain();
        }

        return null;
    }
}
