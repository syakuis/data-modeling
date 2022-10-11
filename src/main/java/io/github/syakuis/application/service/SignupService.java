package io.github.syakuis.application.service;

import io.github.syakuis.application.request.SignupRequest;
import io.github.syakuis.domain.AccountEntity;
import io.github.syakuis.domain.repository.AccountRepositoryAdapter;
import io.github.syakuis.domain.repository.AccountRepositoryPort;
import io.github.syakuis.model.SignupDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Seok Kyun. Choi.
 * @since 2021-05-21
 */
@RequiredArgsConstructor
@Service
@Transactional
public class SignupService {
    private final AccountRepositoryPort accountRepositoryPort;

    public SignupDto register(SignupRequest signup) {
        if (!signup.getNewPassword().isMatch()) {
            throw new IllegalArgumentException("비밀번호가 다릅니다.");
        }

        AccountEntity accountEntity = accountRepositoryPort.save(signup.toEntity());

        return SignupDto.of(accountEntity);
    }
}
