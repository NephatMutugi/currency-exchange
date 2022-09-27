package com.teohkenya.main.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @ Author NMuchiri
 **/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyExchange {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("from")
    private String from;

    @JsonProperty("to")
    private String to;

    @JsonProperty("conversionMultiple")
    private BigDecimal conversionMultiple;

    @JsonProperty("environment")
    private String environment;

}
