package com.teohkenya.main.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ Author NMuchiri
 **/
@Getter
@AllArgsConstructor
public enum ResponseEnums {

    RECORD_NOT_FOUND("1", "Failure", "Record Not Found");

    private final String statusCode;
    private final String statusDescription;
    private final String statusMessage;
}
