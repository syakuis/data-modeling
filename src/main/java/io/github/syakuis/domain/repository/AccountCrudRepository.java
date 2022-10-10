package io.github.syakuis.domain.repository;

import io.github.syakuis.domain.AccountEntity;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Seok Kyun. Choi.
 * @since 2021-05-21
 */
interface AccountCrudRepository extends Repository<AccountEntity, Long> {
    List<AccountEntity> findAll();

    Optional<AccountEntity> findById(long id);

    AccountEntity save(AccountEntity accountEntity);
}
