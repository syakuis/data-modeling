package io.github.syakuis.model;

import io.github.syakuis.domain.AccountEntity;
import io.github.syakuis.mapper.ProfileMapper;
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
public class ProfileDto {
    private Long id;
    private UUID uid;
    private String username;
    private EmailDto email;
    private LocalDateTime registeredOn;
    private LocalDateTime updatedOn;

    public static ProfileDto of(AccountEntity entity) {
        return ProfileMapper.INSTANCE.toDto(entity);
    }
}
