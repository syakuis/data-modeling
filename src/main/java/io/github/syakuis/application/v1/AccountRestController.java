package io.github.syakuis.application.v1;

import io.github.syakuis.application.service.AccountService;
import io.github.syakuis.model.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-10-10
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/accounts")
public class AccountRestController {
    private final AccountService accountService;

    @GetMapping
    public List<AccountDto> list() {
        return accountService.list();
    }
}
