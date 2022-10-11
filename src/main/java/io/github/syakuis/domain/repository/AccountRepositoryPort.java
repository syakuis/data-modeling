package io.github.syakuis.domain.repository;

import io.github.syakuis.domain.AccountEntity;

import java.util.List;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-10-11
 */
public interface AccountRepositoryPort {
    AccountEntity save(AccountEntity entity);

    List<AccountEntity> select();

    AccountEntity selectOne(long id);
}
