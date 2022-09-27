package com.teohkenya.main.repositories;

import com.teohkenya.main.model.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ Author NMuchiri
 **/
public interface CurrencyExchangeRepo extends JpaRepository<CurrencyExchange, Long> {

    CurrencyExchange findCurrencyExchangeByFrom(String from);
    CurrencyExchange findCurrencyExchangeByTo(String to);
    CurrencyExchange findCurrencyExchangeByFromAndTo(String from, String to);
}
