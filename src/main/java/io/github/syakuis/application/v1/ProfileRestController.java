package io.github.syakuis.application.v1;

import io.github.syakuis.application.service.ProfileService;
import io.github.syakuis.model.ProfileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-10-10
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/accounts/{id}/profile")
public class ProfileRestController {
    private final ProfileService profileService;

    @GetMapping
    public ProfileDto object(@PathVariable("id") long id) {
        return profileService.object(id);
    }
}
