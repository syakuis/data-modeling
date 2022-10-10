package io.github.syakuis.application.service;

import io.github.syakuis.application.request.AccountRequest;
import io.github.syakuis.domain.repository.AccountRepository;
import io.github.syakuis.mapper.AccountMapper;
import io.github.syakuis.model.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-10-10
 */
@RequiredArgsConstructor
@Service
@Transactional
public class AccountService implements AccountUseCase<AccountDto, AccountRequest> {
    private final AccountRepository accountRepository;

    @Override
    public List<AccountDto> list() {
        return accountRepository.select().stream().map(AccountMapper.INSTANCE::toDto).toList();
    }

    @Override
    public AccountDto object(long id) {
        return AccountDto.of(accountRepository.selectOne(id));
    }

    @Override
    public AccountDto update(AccountRequest account) {
        return null;
    }
}
