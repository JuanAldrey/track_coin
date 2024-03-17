package org.trackcoin.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.trackcoin.model.enumerate.CurrencyType;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "currencies")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String name;

    @Column(unique=true)
    private String code;

    @Enumerated(EnumType.STRING)
    private CurrencyType type;

    @OneToMany(mappedBy = "baseCurrency", cascade = CascadeType.ALL)
    private List<Trade> baseCurrencyTrades;

    @OneToMany(mappedBy = "quoteCurrency", cascade = CascadeType.ALL)
    private List<Trade> quoteCurrencyTrades;
}
