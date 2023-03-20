package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_case
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.InvalidNoteException
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository

class AddNote(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if(note.title.isBlank()) {
            throw InvalidNoteException("le titre de la note ne peut pas etre vide.")
        }
        if(note.content.isBlank()) {
            throw InvalidNoteException("le contenue de la note ne peut pas etre vide.")
        }
        repository.insertNote(note)
    }
}