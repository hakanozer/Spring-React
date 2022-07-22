package com.mhk.xmlservice.service;


import com.mhk.xmlservice.props.Currency;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class ReadXMLService {

  public List<Currency> Currencies() {
    List<Currency> ls = new ArrayList<>();

    try {
      String baseURL = "https://www.tcmb.gov.tr/kurlar/today.xml";
      String stData = Jsoup.connect(baseURL).timeout(15000).ignoreContentType(true).get().toString();
      Document document = Jsoup.parse(stData, Parser.xmlParser());
      Elements elements = document.getElementsByTag("Currency");
      for (Element element : elements) {
        String CurrencyCode = element.attr("CurrencyCode");
        String CurrencyName = element.getElementsByTag("CurrencyName").text();
        String ForexBuying = element.getElementsByTag("ForexBuying").text();
        String ForexSelling = element.getElementsByTag("ForexSelling").text();
        String BanknoteBuying = element.getElementsByTag("ForexSelling").text();
        String BanknoteSelling = element.getElementsByTag("ForexSelling").text();
        Currency currency = new Currency(CurrencyCode, CurrencyName, ForexBuying, ForexSelling, BanknoteBuying,
            BanknoteSelling);
        ls.add(currency);
      }


    } catch (Exception e) {
      System.err.println("XML Error : " + e);
    }

    return ls;
  }

  public List<Currency> getCurrencyByCurrencyCode(String currencyCode) {
    List<Currency> ls = new ArrayList<>();

    try {
      String baseURL = "https://www.tcmb.gov.tr/kurlar/today.xml";
      String stData = Jsoup.connect(baseURL).timeout(15000).ignoreContentType(true).get().toString();
      Document document = Jsoup.parse(stData, Parser.xmlParser());
      Elements elements = document.getElementsByTag("Currency");

      for (Element element : elements) {
        if (element.attr("CurrencyCode").equals(currencyCode.toUpperCase(Locale.ROOT))) {
          String CurrencyCode = element.attr("CurrencyCode");
          String CurrencyName = element.getElementsByTag("CurrencyName").text();
          String ForexBuying = element.getElementsByTag("ForexBuying").text();
          String ForexSelling = element.getElementsByTag("ForexSelling").text();
          String BanknoteBuying = element.getElementsByTag("ForexSelling").text();
          String BanknoteSelling = element.getElementsByTag("ForexSelling").text();
          Currency _currency = new Currency(CurrencyCode, CurrencyName, ForexBuying, ForexSelling, BanknoteBuying,
              BanknoteSelling);
          ls.add(_currency);
        } else {

        }
      }
    } catch (Exception e) {
      System.err.println("XML Error : " + e);
    }

    return ls;
  }


}
