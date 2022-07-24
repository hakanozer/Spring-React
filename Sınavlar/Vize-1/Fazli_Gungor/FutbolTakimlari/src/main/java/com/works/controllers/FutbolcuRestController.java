package com.works.controllers;

import com.works.entities.Futbolcu;
import com.works.services.FutbolcuServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/futbolcu")
@RestController
public class FutbolcuRestController {
    final FutbolcuServices futbolcuServices;

    public FutbolcuRestController(FutbolcuServices futbolcuServices) {
        this.futbolcuServices = futbolcuServices;
    }

    @PostMapping("/save")
    public ResponseEntity saveFutbolcu(@RequestBody List<Futbolcu> futbolcus) {
        return futbolcuServices.save(futbolcus);
    }

    @GetMapping("/getAll")
    public ResponseEntity list() {
        return futbolcuServices.getAllFutbolcu();
    }

    @PostMapping("/addFutbolcuToTeam")
    public ResponseEntity list(@RequestParam int fid, int tid) {
        return futbolcuServices.saveFutbolcuToTeam(fid,tid);
    }
}
