package org.trackcoin.model.view;

import lombok.Builder;
import lombok.Data;
import org.trackcoin.model.entity.Currency;

import java.time.LocalDate;

@Builder
@Data
public class TradeCreationDTO {

    private LocalDate date;

    private Double baseCurrencyAmount;

    private Double quoteCurrencyAmount;

    private Double baseToUsdtRatio;

    private Double quoteToUsdtRatio;
}
