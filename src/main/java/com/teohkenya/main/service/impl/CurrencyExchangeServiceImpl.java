package com.teohkenya.main.service.impl;

import com.teohkenya.main.model.CurrencyExchange;
import com.teohkenya.main.service.CurrencyExchangeService;
import com.teohkenya.main.utils.CodeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @ Author NMuchiri
 **/
@Service
@Slf4j
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

    /*------------------- GLOBAL VARIABLES -------------------*/

    private final CodeRepo codeRepo;
    private final Environment environment;

    @Autowired
    public CurrencyExchangeServiceImpl(CodeRepo codeRepo, Environment environment) {
        this.codeRepo = codeRepo;
        this.environment = environment;
    }


    @Override
    public ResponseEntity<CurrencyExchange> currencyExchange() {

        String port = environment.getProperty("local.server.port");
        return codeRepo.mockCurrencyExchange(port);
    }
}
