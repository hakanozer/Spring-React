package com.example.futbolrestapi.restcontrollers;

import com.example.futbolrestapi.entities.Teams;
import com.example.futbolrestapi.services.TService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/takimlar")
public class TRestController {

    final TService tService;
    public TRestController(TService tService) {
        this.tService = tService;
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Teams teams){
        return tService.save(teams);
    }
    @GetMapping("/list")
    public ResponseEntity list(){
        return tService.list();
    }




    @PostMapping("/teamInsert")
    public ResponseEntity teamInsert(@RequestBody Teams teams){
        return tService.teamInsert(teams);
    }

}
