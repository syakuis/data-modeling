package io.github.syakuis.domain.repository;

import io.github.syakuis.domain.AccountEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-10-10
 */
@RequiredArgsConstructor
@Repository
public class AccountRepository {
    private final AccountCrudRepository accountCrudRepository;
    public AccountEntity save(AccountEntity entity) {
        return accountCrudRepository.save(entity);
    }

    public List<AccountEntity> select() {
        return accountCrudRepository.findAll();
    }

    public AccountEntity selectOne(long id) {
        return accountCrudRepository.findById(id).orElseThrow();
    }
}
