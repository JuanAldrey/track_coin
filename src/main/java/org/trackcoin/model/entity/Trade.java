package org.trackcoin.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "trades")
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "base_currency_id")
    private Currency baseCurrency;

    @ManyToOne
    @JoinColumn(name = "quote_currency_id")
    private Currency quoteCurrency;

    @Column(name = "base_currency_amount")
    private Double baseCurrencyAmount;

    @Column(name = "quote_currency_amount")
    private Double quoteCurrencyAmount;

    @Column(name = "base_to_usdt_ratio")
    private Double baseToUsdtRatio;

    @Column(name = "quote_to_usdt_ratio")
    private Double quoteToUsdtRatio;

    @Column(name = "base_to_quote_ratio")
    private Double baseToQuoteRatio;
}
