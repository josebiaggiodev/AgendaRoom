package br.edu.ifsp.aluno.agendaroom.repository

import br.edu.ifsp.aluno.agendaroom.data.Contato
import br.edu.ifsp.aluno.agendaroom.data.ContatoDAO

class ContatoRepository (private val contatoDAO: ContatoDAO) {
    suspend fun insert(contato: Contato){
        contatoDAO.insert(contato)
    }
}