package io.github.syakuis.application.service;

import io.github.syakuis.domain.Account;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-10-10
 */
public interface ProfileUseCase<R extends Account> {
    R object(long id);
}
