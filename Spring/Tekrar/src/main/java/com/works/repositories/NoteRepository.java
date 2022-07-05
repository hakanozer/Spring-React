package com.works.repositories;

import com.works.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Integer> {
    List<Note> findByTitleContainsOrDetailContainsAllIgnoreCase(String title, String detail);


}