package com.teohkenya.main.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @ Author NMuchiri
 **/
@Getter
@Setter
@AllArgsConstructor
public class ErrorDetails {

    @JsonProperty("errorDetails")
    private Error error;
}
