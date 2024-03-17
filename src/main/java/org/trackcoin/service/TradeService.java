package org.trackcoin.service;

import org.trackcoin.model.view.TradeCreationDTO;
import org.trackcoin.model.view.TradeDTO;

import java.util.List;

public interface TradeService {

    List<TradeDTO> getAll();

    TradeDTO getById(Long id);

    TradeCreationDTO create(TradeCreationDTO tradecreationDTO, String baseCurrencyCode, String quoteCurrencyCode);

    TradeDTO update(TradeDTO tradeDTO, Long id);

    void delete(Long id);
}
