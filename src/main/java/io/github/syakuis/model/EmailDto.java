package io.github.syakuis.model;

import io.github.syakuis.domain.EmailVo;
import io.github.syakuis.mapper.EmailMapper;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-08-17
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Accessors(fluent = true)
@EqualsAndHashCode
@ToString
public class EmailDto {
    private String localPart;
    private String domain;
    private LocalDateTime verifiedOn;
    private String value;

    public static EmailDto of(EmailVo email) {
        return EmailMapper.INSTANCE.toDto(email);
    }
}
