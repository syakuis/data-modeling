package io.github.syakuis.application.service;

import io.github.syakuis.domain.Account;
import io.github.syakuis.domain.ModifiableAccount;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-10-10
 */
public interface SignupUseCase<R extends Account, T extends ModifiableAccount> {
    R register(T signup);
}
