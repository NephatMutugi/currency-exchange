package com.teohkenya.main.service.impl;

import com.teohkenya.main.configs.CustomProperties;
import com.teohkenya.main.enums.ResponseEnums;
import com.teohkenya.main.model.CurrencyExchange;
import com.teohkenya.main.model.Error;
import com.teohkenya.main.model.ErrorDetails;
import com.teohkenya.main.repositories.CurrencyExchangeRepo;
import com.teohkenya.main.service.CurrencyExchangeService;
import com.teohkenya.main.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @ Author NMuchiri
 **/
@Service
@Slf4j
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

    /*------------------- GLOBAL VARIABLES -------------------*/

    private final Utils utils;
    private final Environment environment;
    private final CurrencyExchangeRepo exchangeRepo;
    private final CustomProperties customProperties;


    @Autowired
    public CurrencyExchangeServiceImpl(Utils utils, Environment environment, CurrencyExchangeRepo exchangeRepo, CustomProperties customProperties) {
        this.utils = utils;
        this.environment = environment;
        this.exchangeRepo = exchangeRepo;
        this.customProperties = customProperties;
    }


    @Override
    public ResponseEntity<?> currencyExchange(String from, String to) {

        CurrencyExchange currencyExchange;
        String port = environment.getProperty("local.server.port");

        if (customProperties.getMock().equalsIgnoreCase("true")){
            currencyExchange = utils.mockCurrencyExchange(port);
        } else {
            currencyExchange = exchangeRepo.findCurrencyExchangeByFromAndTo(from, to);

            if(!(currencyExchange == null)){
                currencyExchange.setEnvironment(port);
            } else {
                // This is in case a record is not found
                Error error = new Error();

                error.setStatusCode(ResponseEnums.RECORD_NOT_FOUND.getStatusCode());
                error.setStatusDescription(ResponseEnums.RECORD_NOT_FOUND.getStatusDescription());
                error.setStatusMessage(ResponseEnums.RECORD_NOT_FOUND.getStatusMessage());

                ErrorDetails errorDetails = new ErrorDetails(error);

                return new ResponseEntity<>(errorDetails, HttpStatus.OK);
            }

        }

        return new ResponseEntity<>(currencyExchange, HttpStatus.OK);
    }
}
