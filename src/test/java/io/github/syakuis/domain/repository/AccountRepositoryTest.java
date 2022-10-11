package io.github.syakuis.domain.repository;

import io.github.syakuis.domain.AccountEntity;
import io.github.syakuis.domain.EmailVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-10-11
 */
@DataJpaTest
class AccountRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AccountRepository accountRepository;

    private AccountEntity accountEntity;

    @BeforeEach
    void init() {
        accountEntity = accountRepository.save(AccountEntity.builder()
            .password("1111")
            .username("root")
            .email(EmailVo.of("test.@em.com"))
            .blocked(false)
            .disabled(false)
            .build());

        entityManager.flush();
    }

    @Test
    @DisplayName("모든 계정를 조회한다.")
    void findAll() {
        List<AccountEntity> accounts = accountRepository.findAll();
        assertFalse(accounts.isEmpty());
        assertTrue(accounts.stream().anyMatch(it -> Objects.equals(accountEntity.getUsername(), it.getUsername())));
    }

    @Test
    @DisplayName("하나의 계정를 찾는 다.")
    void findById() {
        AccountEntity account = accountRepository.findById(accountEntity.getId()).orElseThrow();
        assertNotNull(account);
        assertEquals("root", account.getUsername());
    }

    @Test
    @DisplayName("계정을 저장한다.")
    void save() {
        AccountEntity account = accountRepository.save(AccountEntity.builder()
            .password("1234")
            .username("testatest")
            .email(EmailVo.of("testatest.@em.com"))
            .blocked(false)
            .disabled(false)
            .build());

        entityManager.flush();

        AccountEntity expected = accountRepository.findById(account.getId()).orElseThrow();
        assertNotNull(expected);
        assertEquals(expected, account);
    }
}