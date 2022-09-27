package com.teohkenya.main.controller;

import com.teohkenya.main.service.CurrencyExchangeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/from/{from}/to/{to}")
    public ResponseEntity<?> currencyExchange(@PathVariable(value = "from") String from,
                                              @PathVariable(value = "to") String to){
        return currencyExchangeService.currencyExchange(from, to);
    }
}
