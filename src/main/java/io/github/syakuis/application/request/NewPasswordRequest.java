package io.github.syakuis.application.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-08-23
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class NewPasswordRequest {
    @NotNull
    @NotBlank
    private String password;

    @NotNull
    @NotBlank
    private String passwordConfirm;

    public boolean isMatch() {
        return Objects.equals(password, passwordConfirm);
    }
}
