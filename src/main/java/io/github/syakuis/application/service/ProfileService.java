package io.github.syakuis.application.service;

import io.github.syakuis.domain.repository.AccountRepositoryPort;
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
public class ProfileService {
    private final AccountRepositoryPort accountRepositoryPort;

    public ProfileDto object(long id) {
        return ProfileDto.of(accountRepositoryPort.selectOne(id));
    }

}
