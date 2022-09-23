package com.teohkenya.main.controller;

import com.teohkenya.main.service.CurrencyExchangeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author NMuchiri
 **/
@RestController
@RequestMapping("currency-exchange")
@Slf4j
public class CurrencyExchangeController {
    /*-----------------------GLOBAL VARIABLES-----------------------*/
    private final CurrencyExchangeService currencyExchangeService;

    @Autowired
    public CurrencyExchangeController(CurrencyExchangeService currencyExchangeService) {
        this.currencyExchangeService = currencyExchangeService;
    }

    @GetMapping
    public ResponseEntity<?> currencyExchange(){
        return currencyExchangeService.currencyExchange();
    }
}
