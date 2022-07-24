package com.works.restcontrollers;

import com.works.entities.Footballers;
import com.works.services.FootballersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/footballers")
public class FootballersRestController {
    final FootballersService footballersService;

    public FootballersRestController(FootballersService footballersService) {
        this.footballersService = footballersService;
    }


    @PostMapping("/footballerRegister")
    public ResponseEntity footballerRegister(@RequestBody Footballers footballer) {
        return footballersService.footballerRegister(footballer);
    }

    @PostMapping("/teamInsert")
    public ResponseEntity teamInsert(@RequestParam (defaultValue = "") int fid,@RequestParam (defaultValue = "") int tid) {
        return footballersService.teamInsert(fid,tid);
    }

    @GetMapping("/teamCreate")
    public ResponseEntity teamCreate(@RequestParam(defaultValue = "") int teamMember) {
        return footballersService.teamCreate(teamMember);
    }
}
