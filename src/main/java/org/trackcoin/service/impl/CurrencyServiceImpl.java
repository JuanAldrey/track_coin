package org.trackcoin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trackcoin.exception.CurrencyAlreadyRegisteredException;
import org.trackcoin.exception.EntityNotFoundException;
import org.trackcoin.model.entity.Currency;
import org.trackcoin.model.view.CurrencyDTO;
import org.trackcoin.repository.CurrencyRepository;
import org.trackcoin.service.CurrencyService;
import org.trackcoin.service.builder.Builder;

import java.util.List;


@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    CurrencyRepository currencyRepository;

    @Override
    public List<CurrencyDTO> getAll() {
        List<Currency> currencies = currencyRepository.findAll();
        return currencies.stream().map(Builder::buildCurrencyDTO).toList();
    }

    @Override
    public CurrencyDTO getById(Long id) {
        Currency currency = currencyRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Currency not found by ID"));
        return Builder.buildCurrencyDTO(currency);
    }

    @Override
    public CurrencyDTO save(CurrencyDTO currencyDTO, Long id) {
        validateNewCurrency(currencyDTO.getCode());
        Currency currency = Builder.buildCurrency(currencyDTO, id);
        currencyRepository.save(currency);
        return currencyDTO;
    }

    @Override
    public void delete(Long id) {
        getById(id);
        currencyRepository.deleteById(id);
    }

    public void validateNewCurrency(String currencyCode) {
        List<Currency> currencies = currencyRepository.findAll().stream()
                .filter(c -> !c.getCode().equals(currencyCode)).toList();

        if (!currencies.isEmpty()) {
            throw new CurrencyAlreadyRegisteredException("This currency is already registered the database.");
        }
    }
}
