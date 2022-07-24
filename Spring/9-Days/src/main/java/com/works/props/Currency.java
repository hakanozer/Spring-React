package com.works.props;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Currency {

    private String Kod;
    private String CurrencyName;
    private String ForexBuying;
    private String ForexSelling;

}
