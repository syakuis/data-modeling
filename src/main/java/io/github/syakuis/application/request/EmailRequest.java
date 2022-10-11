package io.github.syakuis.application.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-08-24
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@EqualsAndHashCode
@ToString
public class EmailRequest {
    @NotNull
    @NotBlank
    private String localPart;

    @NotNull
    @NotBlank
    private String domain;
}
