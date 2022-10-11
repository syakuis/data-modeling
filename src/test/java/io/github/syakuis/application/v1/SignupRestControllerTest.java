package io.github.syakuis.application.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.syakuis.application.request.EmailRequest;
import io.github.syakuis.application.request.SignupRequest;
import io.github.syakuis.application.service.SignupService;
import io.github.syakuis.configuration.JacksonConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-10-11
 */
@WebMvcTest(controllers = SignupRestController.class)
@AutoConfigureMockMvc
@Import(JacksonConfiguration.class)
class SignupRestControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private SignupService signupService;

    @Test
    void register() throws Exception {
        mvc.perform(
            post("/v1/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapperSignupRequest.builder()
                    .username("1111")
                    .email(EmailRequest.builder()
                        .localPart("1111")
                        .domain("em.com")
                        .build())
                    .build())
        )
            .andExpect(status().isCreated());
    }
}