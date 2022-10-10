package io.github.syakuis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.syakuis.domain.Account;
import io.github.syakuis.domain.Email;
import io.github.syakuis.mapper.SignupMapper;
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
@EqualsAndHashCode(callSuper = true)
@ToString
public class SignupDto extends AccountDto {
    private Long id;
    private UUID uid;
    private String username;
    private Email email;
    private LocalDateTime registeredOn;

    public static SignupDto of(Account account) {
        return SignupMapper.INSTANCE.toDto(account);
    }

    @JsonIgnore
    @Override
    public LocalDateTime updatedOn() {
        return null;
    }

    @JsonIgnore
    @Override
    public Boolean disabled() {
        return false;
    }

    @JsonIgnore
    @Override
    public Boolean blocked() {
        return false;
    }
}
