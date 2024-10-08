package com.amalvadkar.tms.configuration.repositories;

import com.amalvadkar.tms.configuration.entities.AppConfigEntity;
import com.amalvadkar.tms.configuration.models.KeyValueDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AppConfigRepo extends JpaRepository<AppConfigEntity, Long> {

    @Query(value = """
            select
                ac.key as `key`,
                ac.value as value
            from app_config ac
            where ac.category = :category
            and ac.delete_flag = false
            """, nativeQuery = true)
    List<KeyValueDTO<String, String>> findConfigKeyValuesByCategoryAsList(String category);

    default Map<String, String> findConfigKeyValuesByCategoryAsMap(String category){
        List<KeyValueDTO<String, String>> configs = findConfigKeyValuesByCategoryAsList(category);
        Map<String, String> configKeyToValueMap = new HashMap<>();
        for (KeyValueDTO<String, String> config : configs) {
            configKeyToValueMap.put(config.getKey(), config.getValue());
        }
        return configKeyToValueMap;
    }

}