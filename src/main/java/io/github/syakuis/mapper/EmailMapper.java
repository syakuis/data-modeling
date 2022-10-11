package io.github.syakuis.mapper;

import io.github.syakuis.domain.EmailVo;
import io.github.syakuis.model.EmailDto;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-06-28
 */
@Mapper
public interface EmailMapper {
    EmailMapper INSTANCE = Mappers.getMapper(EmailMapper.class);

    @Named("toEmailDto")
    EmailDto toDto(EmailVo email);

    EmailVo toVo(EmailDto email);
}
