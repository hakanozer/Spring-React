package com.works.restcontrollers;

import com.works.entities.Gamer;
import com.works.services.GamerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class GamerRestController {
    final GamerService gamerService;

    public GamerRestController(GamerService gamerService) {
        this.gamerService = gamerService;
    }

    @PostMapping("/gamerRegister")
    public ResponseEntity gamerRegister(@RequestBody Gamer gamer){
        return gamerService.gamerRegister(gamer);
    }
}
