package com.example.futbolmuskabakasi.controllers;

import com.example.futbolmuskabakasi.entities.Footballer;
import com.example.futbolmuskabakasi.services.FootballerServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/footballer")
public class FootballerRestController {
    final FootballerServices footballerServices;

    public FootballerRestController(FootballerServices footballerServices) {
        this.footballerServices = footballerServices;
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody List<Footballer> footballer) {
        return footballerServices.register(footballer);
    }

    @GetMapping("/addtoteam")
    public ResponseEntity addToTeam(@RequestParam int fid, int tid) {
        return footballerServices.addToTeam(fid, tid);
    }

    @GetMapping("/getall")
    public ResponseEntity getALl() {
        return footballerServices.getAll();
    }

    @GetMapping("/teamCreate")
    public ResponseEntity getallteam() {
        return footballerServices.teamCreate();
    }

    @GetMapping("/backUpCreate")
    public ResponseEntity backUpCreate() {
        return footballerServices.backUpCreate();
    }

}
