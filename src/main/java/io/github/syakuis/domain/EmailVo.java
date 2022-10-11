package io.github.syakuis.domain;

import lombok.*;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-08-17
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@EqualsAndHashCode
@ToString
@Embeddable
public class EmailVo {
    @NotBlank
    @Column(name = "email_local_part", nullable = false, length = 64)
    private String localPart;

    @NotBlank
    @Column(name = "email_domain", nullable = false)
    private String domain;

    @Column(name = "email_verified_on", length = 6, columnDefinition = "datetime(6)")
    private LocalDateTime verifiedOn;

    public void updateVerifiedOn() {
        this.verifiedOn = LocalDateTime.now();
    }

    public static EmailVo of(final String email) {
        String[] emailDiv = StringUtils.split(email, "@");

        return EmailVo.builder()
            .localPart(emailDiv[0])
            .domain(emailDiv[1]).build();
    }
}
