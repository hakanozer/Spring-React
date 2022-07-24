package com.works.restcontrollers;

import com.works.entities.Footballer;
import com.works.services.FootballerService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
public class FootballerRestController {

    final FootballerService fService;

    public FootballerRestController(FootballerService fService) {
        this.fService = fService;
    }

    @PostMapping("/save")
    public ResponseEntity save(@Valid @RequestBody Footballer footballer) {
        return fService.save(footballer);
    }
}
