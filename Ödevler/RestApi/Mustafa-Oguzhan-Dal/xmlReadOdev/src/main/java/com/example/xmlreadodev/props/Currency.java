package com.example.xmlreadodev.props;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Currency {

    private String currencyCode;
    private String currencyName;
    private String forexBuying;
    private String forexSelling;
    private String banknoteBuying;
    private String banknoteSelling;
}
