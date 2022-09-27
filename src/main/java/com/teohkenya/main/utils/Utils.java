package com.teohkenya.main.utils;

import com.teohkenya.main.model.CurrencyExchange;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @ Author NMuchiri
 **/
@Component
public class Utils {

    public CurrencyExchange mockCurrencyExchange(String port){

        CurrencyExchange currencyExchange = new CurrencyExchange();

        currencyExchange.setId(1001L);
        currencyExchange.setTo("RWF");
        currencyExchange.setFrom("KES");
        currencyExchange.setConversionMultiple(BigDecimal.valueOf(8.60));
        currencyExchange.setEnvironment(port);

        return currencyExchange;
    }
}
