package com.works.services;

import com.works.props.NewsData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NewsService {

    public ResponseEntity news() {
        String url = "https://newsapi.org/v2/top-headlines?country=tr&category=business&apiKey=38a9e086f10b445faabb4461c4aa71f8";
        RestTemplate template = new RestTemplate();
        NewsData newsData = template.getForObject(url, NewsData.class);
        newsData.getArticles().forEach( item -> {
            System.out.println( item.getTitle() );
        } );
        return new ResponseEntity(newsData, HttpStatus.OK);
    }

}
