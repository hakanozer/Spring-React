package com.works.services;

import com.works.props.Currency;
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


    public ResponseEntity singleCurrency(String kod) {

        String koduTemizle = kod.toUpperCase().trim();

        Map<String, Object> hm = new LinkedHashMap<>();

        AllCurrency().forEach(data ->
                {
                    if (data.getKod().equals(koduTemizle)) {
                        hm.put("status", true);
                        hm.put("result", data);
                        System.out.println(data);

                    }else {
                        hm.put("status", false);
                        hm.put("result", "sonuc bulunamadı");
                    }

                }


        );


        return new ResponseEntity(hm, HttpStatus.OK);


    }


}
