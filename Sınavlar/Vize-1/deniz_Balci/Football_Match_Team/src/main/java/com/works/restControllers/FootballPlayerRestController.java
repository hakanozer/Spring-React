package com.works.restControllers;

import com.works.entities.FootballPlayer;
import com.works.services.FootballPlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FootballPlayerRestController {

    final FootballPlayerService fService;
    public FootballPlayerRestController(FootballPlayerService fService) {
        this.fService = fService;
    }

    @PostMapping("/footballerRegister")
    public ResponseEntity footballerRegister (@RequestBody FootballPlayer footballPlayer){
       return fService.footballerRegister(footballPlayer);
    }

    @GetMapping("/teamCreate")
    public ResponseEntity teamCreate (){
        return fService.teamCreate();
    }

    @GetMapping("/backUpCreate")
    public ResponseEntity backUpCreate (){
        return fService.backUpCreate();
    }
}
