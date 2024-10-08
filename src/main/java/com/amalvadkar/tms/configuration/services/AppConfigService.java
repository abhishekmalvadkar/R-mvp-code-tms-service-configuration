package com.amalvadkar.tms.configuration.services;

import com.amalvadkar.tms.configuration.constants.ResMsgConstants;
import com.amalvadkar.tms.configuration.models.request.FetchKeyValueConfigRequest;
import com.amalvadkar.tms.configuration.models.response.CustomResponse;
import com.amalvadkar.tms.configuration.repositories.AppConfigRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

import static com.amalvadkar.tms.configuration.constants.ResMsgConstants.FETCHED_SUCCESSFULLY_RES_MSG;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class AppConfigService {

    private final AppConfigRepo appConfigRepo;

    public CustomResponse fetchConfigs(FetchKeyValueConfigRequest fetchKeyValueConfigRequest) {
        log.debug("Enters : AppConfigService :: fetchConfigs()");
        Map<String, String> configKeyToValueMap = appConfigRepo
                .findConfigKeyValuesByCategoryAsMap(fetchKeyValueConfigRequest.category());
        log.debug("Exit : AppConfigService :: fetchConfigs()");
        return CustomResponse.success(configKeyToValueMap, FETCHED_SUCCESSFULLY_RES_MSG);
    }
}
