package com.works.services;

import com.works.props.NewsData;
import com.works.util.Util;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class NewsService {

    public ResponseEntity news() {
        String url = "https://newsapi.org/v2/top-headlines";
        RestTemplate template = new RestTemplate();

        // send Params
        Map<String, String > sendParams = new HashMap<>();
        sendParams.put("country", "tr");
        sendParams.put("category", "business");
        sendParams.put("apiKey", "38a9e086f10b445faabb4461c4aa71f8");
        String urll = Util.paramsUrl(url, sendParams);
        System.out.println( urll );
        NewsData newsData = template.getForObject(Util.paramsUrl(url, sendParams), NewsData.class, sendParams);

        Map<String, Object> hm = new LinkedHashMap();
        hm.put("status", true );
        hm.put("news", newsData.getArticles() );

        return new ResponseEntity(hm, HttpStatus.OK);
    }

}
