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

}
