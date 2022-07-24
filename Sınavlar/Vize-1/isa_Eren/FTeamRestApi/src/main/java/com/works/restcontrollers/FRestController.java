package com.works.restcontrollers;

import com.works.etities.Footballer;
import com.works.services.FService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FRestController {
    final FService fService;

    public FRestController(FService fService) {
        this.fService = fService;
    }

    @PostMapping("/footballerRegister")
    public ResponseEntity footballerRegister(@RequestBody Footballer footballer) {
        return fService.footballerRegister(footballer);
   }
    @PostMapping("/teamInsertA/{id}")
    public ResponseEntity teamInsertA(@PathVariable Integer id) {
        return fService.teamInsertA(id);
    }
    @PostMapping("/teamInsertB/{id}")
    public ResponseEntity teamInsertB(@PathVariable Integer id) {
        return fService.teamInsertB(id);
    }

}
