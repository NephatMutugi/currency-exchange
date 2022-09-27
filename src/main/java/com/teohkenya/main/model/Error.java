package com.teohkenya.main.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @ Author NMuchiri
 **/
@Getter
@Setter
public class Error {
    private String statusCode;
    private String statusDescription;
    private String statusMessage;
}
