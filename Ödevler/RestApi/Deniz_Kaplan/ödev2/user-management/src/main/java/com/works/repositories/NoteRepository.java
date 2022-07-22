package com.works.repositories;

import com.works.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Integer> {
    @Query("select n from Note n " +
            "where upper(n.title) like upper(concat('%', ?1, '%')) and upper(n.detail) like upper(concat('%', ?2, '%'))")
    List<Note> findByTitleContainsIgnoreCaseAndDetailContainsIgnoreCase(String title, String detail);
}