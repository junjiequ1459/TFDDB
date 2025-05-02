package com.junqu.TFDDB.service;

import com.junqu.TFDDB.model.UserOuidResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class UserOuidService {
    private final WebClient nexonWebClient;

    /**
     * Fetches the raw Nexon /id response and extracts just the ouid.
     */
    public Mono<String> fetchOuid(String userName) {
        return nexonWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/id")
                        .queryParam("user_name", userName)
                        .build())
                .retrieve()
                .bodyToMono(UserOuidResponse.class)
                .map(UserOuidResponse::getOuid);
    }
}
