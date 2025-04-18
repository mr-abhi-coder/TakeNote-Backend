package org.bigcart.takenote.repository;

import org.bigcart.takenote.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepo extends JpaRepository<Note, Integer> {

}
