package io.github.syakuis.mapper;

import io.github.syakuis.domain.Account;
import io.github.syakuis.model.SignupDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-06-28
 */
@Mapper
public interface SignupMapper {
    SignupMapper INSTANCE = Mappers.getMapper(SignupMapper.class);

    SignupDto toDto(Account account);
}
