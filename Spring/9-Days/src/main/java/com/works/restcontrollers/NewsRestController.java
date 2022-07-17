package com.works.restcontrollers;

import com.works.services.NewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsRestController {

    final NewsService nService;
    public NewsRestController(NewsService nService) {
        this.nService = nService;
    }

    @GetMapping("/news")
    public ResponseEntity news() {
        return nService.news();
    }


}
