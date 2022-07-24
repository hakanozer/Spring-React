package com.works.futbol.restcontrollers;

import com.works.futbol.services.AClubService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Aclub")
public class AclubController {

    final AClubService aClubService;

    public AclubController(AClubService aClubService) {
        this.aClubService = aClubService;
    }

    @GetMapping("all")
    public ResponseEntity getall(){
        return aClubService.getall();
    }

    @GetMapping("/getas")
    public ResponseEntity getAs(){
        return  aClubService.getAs();
    }

    @GetMapping("/getyedek")
        public ResponseEntity getYedek(){
        return  aClubService.getyedek();
    }
}
