package io.github.syakuis.domain;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Supplier;

/**
 * @author Seok Kyun. Choi.
 * @since 2021-05-21
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@Entity
@Table(
    name = "account",
    indexes = {
        @Index(name = "IDX_account_deleted_1", columnList = "deleted")
    },
    uniqueConstraints = {
        @UniqueConstraint(name = "UK_account_uid_1", columnNames = "uid"),
        @UniqueConstraint(name = "UK_account_username_1", columnNames = "username")
    }
)
@SQLDelete(sql = """
    UPDATE account
        SET deleted = true
        WHERE id = ?
    """)
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, columnDefinition = "bigint unsigned")
    private Long id;

    @Column(nullable = false, updatable = false, length = 16, columnDefinition = "binary(16)")
    private UUID uid;

    @NotBlank
    @Column(nullable = false, length = 150, updatable = false)
    private String username;

    @NotBlank
    @Column(nullable = false, length = 150)
    private String password;

    @NotNull
    @Embedded
    private EmailVo email;

    @CreationTimestamp
    @Column(nullable = false, updatable = false, length = 6, columnDefinition = "datetime(6)")
    private LocalDateTime registeredOn;

    @Column(length = 6, columnDefinition = "datetime(6)")
    private LocalDateTime updatedOn;

    @Column(nullable = false, columnDefinition = "bit(1)", length = 1)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean disabled;

    @Column(nullable = false, columnDefinition = "bit(1)", length = 1)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean blocked;

    @Column(nullable = false, columnDefinition = "bit(1)", length = 1)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean deleted;

    @Builder
    protected AccountEntity(String username, String password, EmailVo email, Boolean disabled, Boolean blocked) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.disabled = disabled;
        this.blocked = blocked;
    }

    @PrePersist
    public void prePersist() {
        this.uid = UUID.randomUUID();
    }

    @PreUpdate
    protected void preUpdate() {
        hasWithdrawn();
        this.updatedOn = LocalDateTime.now();
    }

    private void hasWithdrawn() {
        if (deleted) {
            throw new IllegalStateException("엔티티는 삭제되었습니다.");
        }
    }

    public void updatePassword(String password) {
        this.password = password;
    }

    public void updatePassword(Supplier<String> passwordEncode) {
        this.password = passwordEncode.get();
    }

    public void update(AccountEntity accountEntity) {
        if (accountEntity.getEmail() != null) {
            this.email =  accountEntity.getEmail();
        }

        if (accountEntity.getDisabled() != null) {
            this.disabled = accountEntity.getDisabled();
        }

        if (accountEntity.getBlocked() != null) {
            this.blocked = accountEntity.getBlocked();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        AccountEntity that = (AccountEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
