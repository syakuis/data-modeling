package io.github.syakuis.domain;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-08-18
 */
public class DeletedAccountException extends RuntimeException {
    public DeletedAccountException() {
        super("회원 탈퇴된 사용자 계정입니다.");
    }

    public DeletedAccountException(String message) {
        super(message);
    }
}
