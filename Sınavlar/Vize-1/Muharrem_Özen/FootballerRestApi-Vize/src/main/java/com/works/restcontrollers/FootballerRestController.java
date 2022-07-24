package com.works.restcontrollers;

import com.works.entities.Footballer;
import com.works.services.FootballerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/footballuser")
public class FootballerRestController {

    final FootballerService footballerService;

    public FootballerRestController(FootballerService footballerService) {
        this.footballerService = footballerService;
    }


    @PostMapping("/save")
    public ResponseEntity save (@RequestBody Footballer footballer)
    {
        return footballerService.save(footballer);

    }

    @GetMapping("/list")
    public ResponseEntity list() {
        return footballerService.list();
    }


}
