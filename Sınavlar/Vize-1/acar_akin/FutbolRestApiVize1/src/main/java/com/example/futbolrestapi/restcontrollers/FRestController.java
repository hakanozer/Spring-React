package com.example.futbolrestapi.restcontrollers;

import com.example.futbolrestapi.entities.Futbolcu;
import com.example.futbolrestapi.repositories.JoinFutbolcuTakimRepository;
import com.example.futbolrestapi.services.FService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/futbolcu")
public class FRestController {
    final FService fService;

    public FRestController(FService fService) {
        this.fService = fService;
    }

    @PostMapping("/footballerRegister")
    public ResponseEntity footballerRegister(@RequestBody Futbolcu futbolcu){
        return fService.footballerRegister(futbolcu);

    }

    @PostMapping("/teamInsert")
    public ResponseEntity teamInsert(@RequestParam(defaultValue = "") int fid, @RequestParam(defaultValue = "") int tid){
        return fService.teamInsert(fid,tid);

    }

    @GetMapping("/teamCreate")
    public ResponseEntity teamCreate(@RequestParam int teamMemberA,@RequestParam int teamMemberB){
        return fService.teamCreate(teamMemberA,teamMemberB);

    }

    @GetMapping("/backUpCreate")
    public ResponseEntity backUpCreate(@RequestParam int teamMemberA,@RequestParam int teamMemberB){
        return null;

    }




}
