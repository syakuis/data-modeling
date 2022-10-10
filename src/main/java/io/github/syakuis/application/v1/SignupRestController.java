package io.github.syakuis.application.v1;

import io.github.syakuis.application.request.SignupRequest;
import io.github.syakuis.application.service.SignupService;
import io.github.syakuis.model.SignupDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-10-10
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/signup")
public class SignupRestController {
    private final SignupService signupService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SignupDto register(@RequestBody @Valid SignupRequest request) {
        return signupService.register(request);
    }
}
