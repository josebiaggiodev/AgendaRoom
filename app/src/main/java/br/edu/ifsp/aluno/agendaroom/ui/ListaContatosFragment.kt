package br.edu.ifsp.aluno.agendaroom.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.ifsp.aluno.agendaroom.R
import br.edu.ifsp.aluno.agendaroom.adapter.ContatoAdapter
import br.edu.ifsp.aluno.agendaroom.data.Contato
import br.edu.ifsp.aluno.agendaroom.databinding.FragmentListaContatosBinding
import br.edu.ifsp.aluno.agendaroom.viewmodel.ContatoViewModel

class ListaContatosFragment : Fragment(){
    private var _binding: FragmentListaContatosBinding? = null
    private val binding get() = _binding!!
    lateinit var contatoAdapter: ContatoAdapter
    lateinit var viewModel: ContatoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListaContatosBinding.inflate(inflater, container, false)

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_listaContatosFragment_to_cadastroFragment) }
        configureRecyclerView()
        return binding.root
    }
    private fun configureRecyclerView()
    {
        viewModel = ViewModelProvider(this).get(ContatoViewModel::class.java)
        viewModel.allContacts.observe(viewLifecycleOwner) { list ->
            list?.let {
                contatoAdapter.updateList(list as ArrayList<Contato>)
            }
        }
        val recyclerView = binding.recyclerview
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        contatoAdapter = ContatoAdapter()
        recyclerView.adapter = contatoAdapter
    }
}