package com.example.xmlreadodev.services;

import com.example.xmlreadodev.props.Currency;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class XmlReadService {

    //Jsoup xml okuma
    public List<Currency> todayXml() {
        List<Currency> ls = new ArrayList<>();
        try {
            String url = "https://www.tcmb.gov.tr/kurlar/today.xml";
            //Süre=15 saniye veri çekmeye çalışır eğer süre biterse fail verir
            //ignoreContentType= jsoup ziyaret edeceği siteleri html olarak bekler ama ignoreContentType ile farklı verilerde gelebilir diyoruz.
            String stData = Jsoup.connect(url).timeout(15000).ignoreContentType(true).get().toString();
            Document document = Jsoup.parse(stData, Parser.xmlParser());//xml formatta bir String varsa bunu xml'e çevirebiliyor
            Elements elements = document.getElementsByTag("Currency");//Currency etiketini elementin içinde topla
            for (Element item : elements) {
                String currencyCode = item.attr("CurrencyCode");
                String currencyName = item.getElementsByTag("CurrencyName").text();
                String forexBuying = item.getElementsByTag("ForexBuying").text();
                String forexSelling = item.getElementsByTag("ForexSelling").text();
                String banknoteBuying = item.getElementsByTag("BanknoteBuying").text();
                String banknoteSelling = item.getElementsByTag("BanknoteSelling").text();
                Currency currency = new Currency(currencyCode, currencyName, forexBuying, forexSelling, banknoteBuying, banknoteSelling);
                ls.add(currency);
            }
        } catch (Exception e) {

        }
        return ls;
    }

    public ResponseEntity allExchangeRate() {
        Map<String, Object> hm = new LinkedHashMap<>();
        hm.put("status", true);
        hm.put("result", todayXml());
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity getExchangeRate(String text) {
        text = text.toUpperCase().trim();
        Map<String, Object> hm = new LinkedHashMap<>();
        for (Currency item : todayXml()) {
            if (item.getCurrencyCode().equals(text)) {
                hm.put("status", true);
                hm.put("result", item);
                return new ResponseEntity(hm, HttpStatus.OK);
            }
            hm.put("status", false);
            hm.put("result", "searched value not found ");
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }
}
