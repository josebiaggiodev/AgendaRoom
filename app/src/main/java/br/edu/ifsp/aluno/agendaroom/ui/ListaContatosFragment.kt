package br.edu.ifsp.aluno.agendaroom.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.edu.ifsp.aluno.agendaroom.R
import br.edu.ifsp.aluno.agendaroom.databinding.FragmentListaContatosBinding

class ListaContatosFragment : Fragment(){
    private var _binding: FragmentListaContatosBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListaContatosBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_listaContatosFragment_to_cadastroFragment) }
        return root
    }
}