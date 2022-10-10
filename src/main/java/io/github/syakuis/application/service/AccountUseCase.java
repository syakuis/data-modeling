package io.github.syakuis.application.service;

import io.github.syakuis.domain.Account;
import io.github.syakuis.domain.ModifiableAccount;

import java.util.List;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-10-10
 */
public interface AccountUseCase<R extends Account, T extends ModifiableAccount> {
    R object(long id);
    List<R> list();
    R update(T account);
}
