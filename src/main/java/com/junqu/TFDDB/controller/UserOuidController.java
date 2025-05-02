package com.junqu.TFDDB.controller;

import com.junqu.TFDDB.service.UserOuidService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;
import java.util.Collections;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserOuidController {
    private final UserOuidService idService;

    /**
     * Frontend calls:
     *   GET /api/tfd/ouid?user_name=RexQu%231629
     * Response:
     *   { "ouid": "string-id" }
     */

    @GetMapping("/api/tfd/ouid")
    public Mono<Map<String, String>> getOuid(
            @RequestParam("user_name") String userName
    ) {
        return idService.fetchOuid(userName)
                .map(ouid -> Collections.singletonMap("ouid", ouid));
    }
}
