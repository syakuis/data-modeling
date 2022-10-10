package io.github.syakuis.application.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.syakuis.domain.Email;
import io.github.syakuis.domain.ModifiableAccount;
import lombok.*;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-10-10
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Accessors(fluent = true)
@EqualsAndHashCode
@ToString
public class AccountRequest implements ModifiableAccount {
    @NotNull
    private Email email;
    @NotNull
    private Boolean disabled;
    @NotNull
    private Boolean blocked;

    @JsonIgnore
    @Override
    public String username() {
        return null;
    }

    @JsonIgnore
    @Override
    public String password() {
        return null;
    }
}
