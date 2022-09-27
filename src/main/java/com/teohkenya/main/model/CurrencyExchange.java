package com.teohkenya.main.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @ Author NMuchiri
 **/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CurrencyExchange {

    @Id
    @SequenceGenerator(name = "CURRENCY-EXCHANGE-ID", sequenceName = "SEQ_CURRENCY_EXCHANGE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CURRENCY-EXCHANGE-ID")
    @JsonProperty("id")
    private Long id;

    @JsonProperty("from")
    @Column(name = "fromCurrency")
    private String from;

    @JsonProperty("to")
    @Column(name = "toCurrency")
    private String to;

    @JsonProperty("conversionMultiple")
    private BigDecimal conversionMultiple;

    @JsonProperty("environment")
    private String environment;

}
