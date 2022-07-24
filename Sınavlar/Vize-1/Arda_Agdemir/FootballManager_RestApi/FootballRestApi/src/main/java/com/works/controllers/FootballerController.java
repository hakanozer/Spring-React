package com.works.controllers;

import com.works.business.FootballerService;
import com.works.entities.Footballer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/footballer")
public class FootballerController {

    final FootballerService fService;

    public FootballerController(FootballerService fService) {
        this.fService = fService;
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Footballer footballer){
        return fService.save(footballer);
    }

    @GetMapping("/list")
    public ResponseEntity list(){
        return fService.list();
    }

    @GetMapping("/team")
    public ResponseEntity teamCreate(){
        return fService.teamCreate();
    }

    @GetMapping("/backup")
    public ResponseEntity backUpCreate(){
        return  fService.backUpCreate();
    }

}
