package io.github.syakuis.domain;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-10-10
 */
public interface ModifiableAccount {
    String username();
    String password();

    Email email();

    Boolean disabled();

    Boolean blocked();
}
