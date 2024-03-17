package org.trackcoin.service;

import org.trackcoin.model.view.CurrencyDTO;

import java.util.List;

public interface CurrencyService {

    List<CurrencyDTO> getAll();

    CurrencyDTO getById(Long id);

    CurrencyDTO save(CurrencyDTO currencyDTO, Long id);

    void delete(Long id);
}
