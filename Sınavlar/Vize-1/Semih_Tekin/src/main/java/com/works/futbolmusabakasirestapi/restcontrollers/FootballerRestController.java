package com.works.futbolmusabakasirestapi.restcontrollers;

import com.works.futbolmusabakasirestapi.entities.Footballer;
import com.works.futbolmusabakasirestapi.services.FootballerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/footballer")
public class FootballerRestController {

    final FootballerService footballerService;
    public FootballerRestController(FootballerService footballerService) {
        this.footballerService = footballerService;
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Footballer footballer){
        return footballerService.save(footballer);
    }

    @GetMapping("/list")
    public ResponseEntity list(){
        return footballerService.list();
    }

    @GetMapping("/search")
    public ResponseEntity teamInsert(@RequestParam String fid, String tid){
        return footballerService.search(fid, tid);
    }


}
