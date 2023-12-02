package br.edu.ifsp.aluno.agendaroom.data

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface ContatoDAO {
    @Insert
    suspend fun insert(contato: Contato)
}