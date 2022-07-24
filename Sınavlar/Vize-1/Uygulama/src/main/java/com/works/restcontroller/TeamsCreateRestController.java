package com.works.restcontroller;

import com.works.repositories.FootTeamRepository;
import com.works.utils.TEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teams")
public class TeamsCreateRestController {


    final FootTeamRepository tRepo;
    public TeamsCreateRestController(FootTeamRepository tRepo) {
        this.tRepo = tRepo;
    }

    @GetMapping("/teamCreate")
    public ResponseEntity teamCreate(@RequestParam TEnum t) {
        /*
            Map<String, Object> hm = new LinkedHashMap<>();
            hm.put("A", tRepo.teamsAsil(0) );
            hm.put("B", tRepo.teamsAsil(1) );
            return new ResponseEntity( hm , HttpStatus.OK );
         */
        return new ResponseEntity( tRepo.teamsAsil( t.ordinal() ), HttpStatus.OK );
    }

    @GetMapping("/backUpCreate")
    public ResponseEntity backUpCreate(@RequestParam TEnum t) {
        return new ResponseEntity( tRepo.teamsYedek( t.ordinal() ), HttpStatus.OK );
    }

    /*
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity notValidException( MethodArgumentNotValidException ex ) {
        return new ResponseEntity( null , HttpStatus.BAD_REQUEST );
    }
     */


}
