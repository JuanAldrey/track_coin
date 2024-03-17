package org.trackcoin.service.builder;

import org.trackcoin.model.entity.Currency;
import org.trackcoin.model.entity.Trade;
import org.trackcoin.model.view.CurrencyDTO;
import org.trackcoin.model.view.TradeCreationDTO;
import org.trackcoin.model.view.TradeDTO;

public class Builder {
    public static Trade buildTrade(TradeDTO tradeDTO, Long id) {
        return Trade.builder().
                id(id).
                date(tradeDTO.getDate()).
                baseCurrency(tradeDTO.getBaseCurrency()).
                quoteCurrency(tradeDTO.getQuoteCurrency()).
                baseCurrencyAmount(tradeDTO.getBaseCurrencyAmount()).
                quoteCurrencyAmount(tradeDTO.getQuoteCurrencyAmount()).
                baseToUsdtRatio(tradeDTO.getBaseToUsdtRatio()).
                quoteToUsdtRatio(tradeDTO.getQuoteToUsdtRatio()).
                baseToQuoteRatio(tradeDTO.getBaseToQuoteRatio()).
                build();
    }

    public static Trade buildTrade(TradeCreationDTO tradeCreationDTO, Long id, Currency baseCurrency, Currency quoteCurrency) {
        return Trade.builder().
                id(id).
                date(tradeCreationDTO.getDate()).
                baseCurrency(baseCurrency).
                quoteCurrency(quoteCurrency).
                baseCurrencyAmount(tradeCreationDTO.getBaseCurrencyAmount()).
                quoteCurrencyAmount(tradeCreationDTO.getQuoteCurrencyAmount()).
                baseToUsdtRatio(tradeCreationDTO.getBaseToUsdtRatio()).
                quoteToUsdtRatio(tradeCreationDTO.getQuoteToUsdtRatio()).
                build();
    }

    public static TradeDTO buildTradeDTO(Trade trade) {
        return TradeDTO.builder().
                date(trade.getDate()).
                baseCurrency(trade.getBaseCurrency()).
                quoteCurrency(trade.getQuoteCurrency()).
                baseCurrencyAmount(trade.getBaseCurrencyAmount()).
                quoteCurrencyAmount(trade.getQuoteCurrencyAmount()).
                baseToUsdtRatio(trade.getBaseToUsdtRatio()).
                quoteToUsdtRatio(trade.getQuoteToUsdtRatio()).
                baseToQuoteRatio(trade.getBaseToQuoteRatio()).
                build();
    }

    public static CurrencyDTO buildCurrencyDTO(Currency currency) {
        return CurrencyDTO.builder().
                name(currency.getName()).
                code(currency.getCode()).
                type(currency.getType()).
                baseCurrencyTrades(currency.getBaseCurrencyTrades()).
                quoteCurrencyTrades(currency.getQuoteCurrencyTrades()).
                build();

    }

    public static Currency buildCurrency(CurrencyDTO currencyDTO, Long id) {
        return Currency.builder().
                id(id).
                name(currencyDTO.getName()).
                code(currencyDTO.getCode()).
                type(currencyDTO.getType()).
                baseCurrencyTrades(currencyDTO.getBaseCurrencyTrades()).
                quoteCurrencyTrades(currencyDTO.getQuoteCurrencyTrades()).
                build();

    }
}
