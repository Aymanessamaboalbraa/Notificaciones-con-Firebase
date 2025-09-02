package com.example.ferreteria.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.ferreteria.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        

        binding.imgAlambre.setOnClickListener { Toast.makeText(activity,"Alambre",Toast.LENGTH_SHORT).show() }

        binding.imgespatula.setOnClickListener { Toast.makeText(activity,"Espatula",Toast.LENGTH_SHORT).show() }

        binding.imgCaja.setOnClickListener { Toast.makeText(activity,"Caja de Herramientas",Toast.LENGTH_SHORT).show() }

        binding.imgPala.setOnClickListener { Toast.makeText(activity,"Pala",Toast.LENGTH_SHORT).show() }

        binding.imgCinta.setOnClickListener { Toast.makeText(activity,"Cinta",Toast.LENGTH_SHORT).show() }

        binding.imgResistol.setOnClickListener { Toast.makeText(activity,"Resistol",Toast.LENGTH_SHORT).show() }

        binding.imgTaladro.setOnClickListener { Toast.makeText(activity,"Taladro",Toast.LENGTH_SHORT).show() }

        binding.imgMartillo.setOnClickListener { Toast.makeText(activity,"Martillo",Toast.LENGTH_SHORT).show() }

        binding.imgPinzas.setOnClickListener { Toast.makeText(activity,"Pinzas",Toast.LENGTH_SHORT).show() }

        binding.imgDesarmador.setOnClickListener { Toast.makeText(activity,"Desarmador",Toast.LENGTH_SHORT).show() }
        return root




    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}