package io.github.syakuis.model;

import io.github.syakuis.domain.AccountEntity;
import io.github.syakuis.mapper.SignupMapper;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-06-28
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class SignupDto {
    private Long id;
    private UUID uid;
    private String username;
    private EmailDto email;
    private LocalDateTime registeredOn;

    public static SignupDto of(AccountEntity entity) {
        return SignupMapper.INSTANCE.toDto(entity);
    }
}
