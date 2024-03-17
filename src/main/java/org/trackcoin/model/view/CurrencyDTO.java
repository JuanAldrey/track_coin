package org.trackcoin.model.view;

import lombok.Builder;
import lombok.Data;
import org.trackcoin.model.entity.Trade;
import org.trackcoin.model.enumerate.CurrencyType;

import java.util.List;

@Builder
@Data
public class CurrencyDTO {

    private String name;

    private String code;

    private CurrencyType type;

    private List<Trade> baseCurrencyTrades;

    private List<Trade> quoteCurrencyTrades;
}
