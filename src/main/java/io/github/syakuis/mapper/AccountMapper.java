package io.github.syakuis.mapper;

import io.github.syakuis.application.request.SignupRequest;
import io.github.syakuis.domain.AccountEntity;
import io.github.syakuis.model.AccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-06-28
 */
@Mapper
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    AccountDto toDto(AccountEntity account);

    AccountEntity toEntity(SignupRequest account);
}
