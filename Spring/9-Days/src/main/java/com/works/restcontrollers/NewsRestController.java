package com.works.restcontrollers;

import com.works.services.NewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/userLogin")
    public ResponseEntity userLogin(@RequestParam String email, @RequestParam String password) {
        return nService.userLogin(email, password);
    }


}
