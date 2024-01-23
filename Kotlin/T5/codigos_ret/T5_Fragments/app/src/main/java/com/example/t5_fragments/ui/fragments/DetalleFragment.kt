package com.example.t5_fragments.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t5_fragments.adapter.AdaptadorImagenes
import com.example.t5_fragments.databinding.FragmentDetalleBinding
import com.example.t5_fragments.databinding.FragmentListaBinding
import com.example.t5_fragments.model.Producto

class DetalleFragment : Fragment() {

    private lateinit var binding: FragmentDetalleBinding
    private lateinit var adaptadorImagenes: AdaptadorImagenes
    private lateinit var producto: Producto

    companion object {
        fun newInstance(item: Producto): DetalleFragment {
            val args = Bundle()
            args.putSerializable("producto", item)
            val fragment = DetalleFragment()
            fragment.arguments = args
            return fragment
        }
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        producto = arguments?.getSerializable("producto") as Producto
        adaptadorImagenes = AdaptadorImagenes(context, producto.imagenes)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerImagenes.adapter = adaptadorImagenes
        binding.recyclerImagenes.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    override fun onDetach() {
        super.onDetach()
    }

}