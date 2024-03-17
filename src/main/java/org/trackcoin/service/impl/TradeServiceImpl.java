package org.trackcoin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trackcoin.exception.EntityNotFoundException;
import org.trackcoin.model.entity.Currency;
import org.trackcoin.model.entity.Trade;
import org.trackcoin.model.view.TradeCreationDTO;
import org.trackcoin.model.view.TradeDTO;
import org.trackcoin.repository.CurrencyRepository;
import org.trackcoin.repository.TradeRepository;
import org.trackcoin.service.TradeService;

import java.util.List;

import org.trackcoin.service.builder.Builder;

@Service
public class TradeServiceImpl implements TradeService {

    @Autowired
    TradeRepository tradeRepository;

    @Autowired
    CurrencyRepository currencyRepository;

    @Override
    public List<TradeDTO> getAll() {
        List<Trade> trades = tradeRepository.findAll();
        return trades.stream().map(Builder::buildTradeDTO).toList();
    }

    @Override
    public TradeDTO getById(Long id) {
        Trade trade = tradeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Trade not found by ID"));
        return Builder.buildTradeDTO(trade);
    }

    @Override
    public TradeCreationDTO create(TradeCreationDTO tradeCreationDTO, String baseCurrencyCode, String quoteCurrencyCode) {
        Currency baseCurrency = currencyRepository.findByCode(baseCurrencyCode).orElseThrow(() -> new EntityNotFoundException("Base Currency not found by Code"));
        Currency quoteCurrency = currencyRepository.findByCode(quoteCurrencyCode).orElseThrow(() -> new EntityNotFoundException("Quote Currency not found by Code"));
        Trade trade = Builder.buildTrade(tradeCreationDTO, null, baseCurrency, quoteCurrency);
        tradeRepository.save(trade);
        return tradeCreationDTO;
    }

    @Override
    public TradeDTO update(TradeDTO tradeDTO, Long id) {
        Trade trade = Builder.buildTrade(tradeDTO, id);
        tradeRepository.save(trade);
        return tradeDTO;
    }

    @Override
    public void delete(Long id) {
        getById(id);
        tradeRepository.deleteById(id);
    }
}
