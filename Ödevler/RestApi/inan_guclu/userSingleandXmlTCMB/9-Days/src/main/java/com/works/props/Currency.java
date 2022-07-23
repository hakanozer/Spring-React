package com.works.props;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Currency {

    private String Kod;
    private String CurrencyName;
    private String ForexBuying;
    private String ForexSelling;

}
