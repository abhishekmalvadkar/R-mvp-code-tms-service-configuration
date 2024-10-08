package com.amalvadkar.tms.configuration.models.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Builder
@JsonInclude(Include.NON_NULL)
@Getter
public class CustomResponse {

    private Object data;
    private String message;
    private Boolean success;
    private Integer code;

    public static CustomResponse success(Object data, String message) {
        return CustomResponse.builder()
                .data(data)
                .success(true)
                .message(message)
                .code(HttpStatus.OK.value())
                .build();
    }

}
