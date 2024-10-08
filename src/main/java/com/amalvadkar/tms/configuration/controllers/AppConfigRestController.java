package com.amalvadkar.tms.configuration.controllers;

import com.amalvadkar.tms.configuration.models.request.FetchKeyValueConfigRequest;
import com.amalvadkar.tms.configuration.models.response.CustomResponse;
import com.amalvadkar.tms.configuration.services.AppConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/configuration")
@RequiredArgsConstructor
public class AppConfigRestController {

    private static final String ENDPOINT_FETCH_CONFIGS = "/fetch-configs";

    private final AppConfigService appConfigService;

    @PostMapping(ENDPOINT_FETCH_CONFIGS)
    public ResponseEntity<CustomResponse> fetchConfigs(@RequestBody FetchKeyValueConfigRequest
                                                                     fetchKeyValueConfigRequest) {
        return ResponseEntity.ok(appConfigService.fetchConfigs(fetchKeyValueConfigRequest));
    }

}
