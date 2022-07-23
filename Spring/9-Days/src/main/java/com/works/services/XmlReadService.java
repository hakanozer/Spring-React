package com.works.services;

import com.works.props.Currency;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class XmlReadService {


    public List<Currency> AllCurrency() {
        List<Currency> ls = new ArrayList<>();
        try {

            String url = "https://www.tcmb.gov.tr/kurlar/today.xml";
            String stData = Jsoup.connect(url).timeout(15000).ignoreContentType(true).get().toString();
            Document document = Jsoup.parse(stData, Parser.xmlParser());
            Elements elements = document.getElementsByTag("Currency");
            for (Element item : elements) {
                String Kod = item.attr("Kod");
                String CurrencyName = item.getElementsByTag("CurrencyName").text();
                String ForexBuying = item.getElementsByTag("ForexBuying").text();
                String ForexSelling = item.getElementsByTag("ForexSelling").text();
                Currency currency = new Currency(Kod, CurrencyName, ForexBuying, ForexSelling);
                ls.add(currency);
            }

        } catch (Exception ex) {
            System.err.println("Xml Error : " + ex);
        }
        return ls;
    }

    public List<Currency> usdCurrency(String money) {
        List<Currency> ls = new ArrayList<>();
        try {
            String url = "https://www.tcmb.gov.tr/kurlar/today.xml";
            String stData = Jsoup.connect(url).timeout(15000).ignoreContentType(true).get().toString();
            Document document = Jsoup.parse(stData, Parser.xmlParser());
            Elements elements = document.getElementsByTag("Currency");
            for (Element item : elements) {
                String Kod = item.attr("Kod");
                if (money.toUpperCase().equals(Kod)) {
                    String CurrencyName = item.getElementsByTag("CurrencyName").text();
                    String ForexBuying = item.getElementsByTag("ForexBuying").text();
                    String ForexSelling = item.getElementsByTag("ForexSelling").text();
                    Currency currency = new Currency(Kod, CurrencyName, ForexBuying, ForexSelling);
                    ls.add(currency);
                }
            }
        } catch (Exception e) {
            System.err.println("xml error: " + e);
        }
        return ls;
    }

}
