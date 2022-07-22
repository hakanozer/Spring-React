package com.mhk.xmlservice.props;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Currency {

  private String currencyCode;
  private String currencyName;
  private String forexBuying;
  private String forexSelling;
  private String banknoteBuying;
  private String banknoteSelling;

}
