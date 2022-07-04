package com.works.services;

import com.works.entities.Note;
import com.works.repositories.NoteRepository;
import com.works.utils.ERest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class NoteService {

    final NoteRepository noteRepository;
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public ResponseEntity save(Note note) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        note.setDate( new Date() );
        noteRepository.save(note);
        hm.put(ERest.result, note);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity list() {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        hm.put(ERest.result, noteRepository.findAll());
        return new ResponseEntity(hm, HttpStatus.OK);
    }


    public ResponseEntity search( String q ) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        hm.put(ERest.result, noteRepository.findByTitleContainsOrDetailContainsAllIgnoreCase(q,q));
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    // User
    // register
    // uid, name, surname, email, password
    // kurallar
    // name -> min 3, max 13
    // surname ->  min 3, max 13
    // email -> format control
        // daha önceden kullanımda olan bir mail olduğunda kayıt olmayacak ve bu mail daha kullanımda hatası.
    // password -> md5

}
