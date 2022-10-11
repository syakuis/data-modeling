package io.github.syakuis.domain.repository;

import io.github.syakuis.domain.AccountEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-10-11
 */
@ExtendWith(MockitoExtension.class)
class AccountRepositoryAdapterTest {
    @InjectMocks
    private AccountRepositoryAdapter accountRepositoryAdapter;

    @Mock
    private AccountRepository accountRepository;

    @Test
    void save() {
        given(accountRepository.save(any())).willReturn(AccountEntity.builder().build());
        accountRepositoryAdapter.save(AccountEntity.builder().build());
        then(accountRepository).should(times(1)).save(any(AccountEntity.class));
        then(accountRepository).shouldHaveNoMoreInteractions();
    }

    @Test
    void select() {
        given(accountRepository.findAll()).willReturn(Collections.emptyList());
        accountRepositoryAdapter.select();
        then(accountRepository).should(times(1)).findAll();
        then(accountRepository).shouldHaveNoMoreInteractions();
    }

    @Test
    void selectOne() {
        given(accountRepository.findById(anyLong())).willReturn(Optional.of(AccountEntity.builder().build()));
        accountRepositoryAdapter.selectOne(1);
        then(accountRepository).should(times(1)).findById(anyLong());
        then(accountRepository).shouldHaveNoMoreInteractions();
    }
}