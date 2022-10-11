package io.github.syakuis.application.request;

import io.github.syakuis.domain.AccountEntity;
import io.github.syakuis.mapper.AccountMapper;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-08-24
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class SignupRequest {
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
}
