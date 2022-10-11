package io.github.syakuis.application.request;

import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-10-10
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class AccountRequest {
    @NotNull
    private EmailRequest email;
    @NotNull
    private Boolean disabled;
    @NotNull
    private Boolean blocked;
}
