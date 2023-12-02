package br.edu.ifsp.aluno.agendaroom.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifsp.aluno.agendaroom.data.Contato
import br.edu.ifsp.aluno.agendaroom.databinding.ContatoCelulaBinding

class ContatoAdapter():
    RecyclerView.Adapter<ContatoAdapter.ContatoViewHolder>() {
    private lateinit var binding: ContatoCelulaBinding
    var contatosLista = ArrayList<Contato>()
    fun updateList(newList: ArrayList<Contato> ){
        contatosLista = newList
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContatoViewHolder {
        binding = ContatoCelulaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContatoViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ContatoViewHolder, position: Int) {
        holder.nomeVH.text = contatosLista[position].nome
        holder.foneVH.text = contatosLista[position].fone
    }
    override fun getItemCount(): Int {
        return contatosLista.size
    }
    inner class ContatoViewHolder(view:ContatoCelulaBinding): RecyclerView.ViewHolder(view.root)
    {
        val nomeVH = view.nome
        val foneVH = view.fone
    }
}