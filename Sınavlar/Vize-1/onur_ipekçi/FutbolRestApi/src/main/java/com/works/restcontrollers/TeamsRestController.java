package com.works.restcontrollers;

import com.works.services.TeamsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamsRestController {
    final TeamsService tService;

    public TeamsRestController(TeamsService tService) {
        this.tService = tService;

    }

    @GetMapping("/teamCreate")
    public ResponseEntity teamCreate() {
        return tService.teamCreate();
    }

    @GetMapping("/backUpCreate")
    public ResponseEntity backUpCreate() {
        return tService.backUpCreate();
    }
}
