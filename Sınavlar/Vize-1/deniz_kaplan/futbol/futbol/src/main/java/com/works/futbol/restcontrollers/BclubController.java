package com.works.futbol.restcontrollers;


import com.works.futbol.services.BClubService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Bclub")
public class BclubController {

    final BClubService bClubService;


    public BclubController(BClubService bClubService) {
        this.bClubService = bClubService;
    }

    @GetMapping("/all")
    public ResponseEntity getAll(){
        return  bClubService.getall();
    }

    @GetMapping("/getas")
    public ResponseEntity getAs(){
        return  bClubService.getAs();
    }

    @GetMapping("/getyedek")
    public ResponseEntity getYedek(){
        return  bClubService.getyedek();
    }

}
