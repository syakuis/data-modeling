package io.github.syakuis.model;

import io.github.syakuis.domain.AccountEntity;
import io.github.syakuis.mapper.AccountMapper;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-06-28
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Accessors(fluent = true)
@EqualsAndHashCode
@ToString
public class AccountDto {
    private Long id;
    private UUID uid;
    private String username;
    private EmailDto email;
    private LocalDateTime registeredOn;
    private LocalDateTime updatedOn;
    private Boolean disabled;
    private Boolean blocked;

    public static AccountDto of(AccountEntity entity) {
        return AccountMapper.INSTANCE.toDto(entity);
    }
}
