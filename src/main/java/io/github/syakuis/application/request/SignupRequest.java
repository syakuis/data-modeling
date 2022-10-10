package io.github.syakuis.application.request;

import io.github.syakuis.domain.AccountEntity;
import io.github.syakuis.domain.ModifiableAccount;
import io.github.syakuis.mapper.AccountMapper;
import lombok.*;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-08-24
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Accessors(fluent = true)
@EqualsAndHashCode
@ToString
public class SignupRequest implements ModifiableAccount {
    @NotNull
    @NotBlank
    private String username;

    @NotNull
    private EmailRequest email;

    @NotNull
    private NewPasswordRequest newPassword;

    public AccountEntity toEntity() {
        return AccountMapper.INSTANCE.toEntity(this);
    }

    @Override
    public String password() {
        return newPassword.password();
    }

    @Override
    public Boolean disabled() {
        return false;
    }

    @Override
    public Boolean blocked() {
        return false;
    }
}
