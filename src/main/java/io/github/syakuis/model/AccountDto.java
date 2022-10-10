package io.github.syakuis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.syakuis.domain.Account;
import io.github.syakuis.domain.Email;
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
public class AccountDto implements Account {
    private Long id;
    private UUID uid;
    private String username;
    private Email email;
    private LocalDateTime registeredOn;
    private LocalDateTime updatedOn;
    private Boolean disabled;
    private Boolean blocked;

    public static AccountDto of(Account account) {
        return null;
    }

    @JsonIgnore
    @Override
    public String password() {
        return null;
    }
}
