package com.teohkenya.main.service;

import com.teohkenya.main.model.CurrencyExchange;
import org.springframework.http.ResponseEntity;

/**
 * @ Author NMuchiri
 **/
public interface CurrencyExchangeService {

    ResponseEntity<CurrencyExchange> currencyExchange();
}
