package com.rav.test.ceepws.repository

import com.rav.test.ceepws.model.Note
import org.springframework.data.repository.CrudRepository

interface NoteRepository: CrudRepository<Note, Long>