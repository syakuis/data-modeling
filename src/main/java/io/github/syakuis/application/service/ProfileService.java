package io.github.syakuis.application.service;

import io.github.syakuis.domain.repository.AccountRepository;
import io.github.syakuis.model.ProfileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-10-10
 */
@RequiredArgsConstructor
@Service
@Transactional
public class ProfileService implements ProfileUseCase<ProfileDto> {
    private final AccountRepository accountRepository;

    @Override
    public ProfileDto object(long id) {
        return ProfileDto.of(accountRepository.selectOne(id));
    }

}
