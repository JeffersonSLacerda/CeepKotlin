package com.rav.test.ceepws.controller

import com.rav.test.ceepws.model.Note
import com.rav.test.ceepws.repository.NoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("notes")
class NoteController {

    @Autowired
    lateinit var noteRepository: NoteRepository

    @GetMapping
    fun list(): List<Note>{
        return noteRepository.findAll().toList()
    }

    @GetMapping("{id}")
    fun show(@PathVariable id: Long): Optional<Note> {
        return noteRepository.findById(id)
    }

    @PostMapping
    fun add(@RequestBody note: Note): Note{
        return noteRepository.save(note)
    }

    @PutMapping("{id}")
    fun alter(@PathVariable id: Long, @RequestBody note: Note): Note {
        if(noteRepository.existsById(id)){
            val safeNote = note.copy()
            return noteRepository.save(safeNote)
        }

        return Note()
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long){
        if(noteRepository.existsById(id)){
            noteRepository.deleteById(id)
        }
    }
}