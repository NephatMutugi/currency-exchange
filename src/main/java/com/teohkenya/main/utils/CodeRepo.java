package com.teohkenya.main.utils;

import com.teohkenya.main.model.CurrencyExchange;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @ Author NMuchiri
 **/
@Component
public class CodeRepo {

    public ResponseEntity<CurrencyExchange> mockCurrencyExchange(String port){

        CurrencyExchange currencyExchange = new CurrencyExchange();

        currencyExchange.setId(1001L);
        currencyExchange.setTo("USD");
        currencyExchange.setFrom("KES");
        currencyExchange.setConversionMultiple(BigDecimal.valueOf(120.00));
        currencyExchange.setEnvironment(port);

        return new ResponseEntity<>(currencyExchange, HttpStatus.OK);
    }
}
