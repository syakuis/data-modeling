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
public class AccountRepositoryAdapter implements AccountRepositoryPort {
    private final AccountRepository accountRepository;
    @Override
    public AccountEntity save(AccountEntity entity) {
        return accountRepository.save(entity);
    }

    @Override
    public List<AccountEntity> select() {
        return accountRepository.findAll();
    }

    @Override
    public AccountEntity selectOne(long id) {
        return accountRepository.findById(id).orElseThrow();
    }
}
