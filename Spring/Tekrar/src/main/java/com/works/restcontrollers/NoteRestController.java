package com.works.restcontrollers;

import com.works.entities.Note;
import com.works.services.NoteService;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/note")
@Validated
public class NoteRestController {

    //http:localhost:8090/note/save/asya
    //http:localhost:8090/note/save?name=asya

    final NoteService nService;
    public NoteRestController(NoteService nService) {
        this.nService = nService;
    }

    @PostMapping("/save")
    public ResponseEntity save( @RequestBody Note note ) {
        return nService.save( note );
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        return nService.list();
    }

    // http://localhost:8090/note/search/ali
    @GetMapping("/search/{q}")
    public ResponseEntity search( @PathVariable(name = "q") String searchQ ) {
        return nService.search(searchQ);
    }

    // http://localhost:8090/note/search?q=ali
    @GetMapping("/search")
    public ResponseEntity searchParams( @Length(min = 3, max = 10, message = "Q Min=3 Max=10") @RequestParam(defaultValue = "") String q ) {
        return nService.search(q);
    }


}
