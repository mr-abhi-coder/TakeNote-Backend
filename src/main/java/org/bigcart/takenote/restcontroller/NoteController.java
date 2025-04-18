package org.bigcart.takenote.restcontroller;

import org.bigcart.takenote.entity.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.bigcart.takenote.repository.NoteRepo;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteRepo noteRepo;

    @GetMapping
    public List<Note> getAll(){
        return noteRepo.findAll();
    }

    @PostMapping
    public Note createNote(@RequestBody Note note){
        return noteRepo.save(note);
    }

    @PutMapping("/{id}")
    public Note updateNote(@PathVariable Integer id, @RequestBody Note updateNote){
        Note note = noteRepo.findById(id).orElseThrow(() ->
            new RuntimeException("Note was not found"));
        note.setTitle(updateNote.getTitle());
        note.setContent(updateNote.getContent());

        return  noteRepo.save(note);
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Integer id){
        noteRepo.deleteById(id);
    }
}
