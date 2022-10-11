package io.github.syakuis.application.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.function.Predicate;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-08-23
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@EqualsAndHashCode(callSuper = true)
@ToString
public class ChangePasswordRequest extends NewPasswordRequest {
    @NotNull
    @NotBlank
    private String currentPassword;

    public boolean isMatch(Predicate<String> password) {
        return password.test(currentPassword);
    }
}
