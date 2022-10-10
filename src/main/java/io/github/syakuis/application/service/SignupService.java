package io.github.syakuis.application.service;

import io.github.syakuis.application.request.SignupRequest;
import io.github.syakuis.domain.AccountEntity;
import io.github.syakuis.domain.repository.AccountRepository;
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
public class SignupService implements SignupUseCase<SignupDto, SignupRequest> {
    private final AccountRepository accountRepository;

    @Override
    public SignupDto register(SignupRequest signup) {
        if (!signup.newPassword().isMatch()) {
            throw new IllegalArgumentException("비밀번호가 다릅니다.");
        }

        AccountEntity accountEntity = accountRepository.save(signup.toEntity());

        return SignupDto.of(accountEntity);
    }
}
