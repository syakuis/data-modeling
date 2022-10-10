package io.github.syakuis.application.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.github.syakuis.domain.Email;
import lombok.*;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-08-24
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Accessors(fluent = true)
@EqualsAndHashCode
@ToString
public class EmailRequest implements Email {
    @NotNull
    @NotBlank
    private String localPart;

    @NotNull
    @NotBlank
    private String domain;

    @JsonIgnore
    public LocalDateTime verifiedOn() {
        return null;
    }
}
