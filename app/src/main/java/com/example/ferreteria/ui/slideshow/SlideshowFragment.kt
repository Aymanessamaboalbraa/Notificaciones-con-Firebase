package com.example.ferreteria.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.ferreteria.Ferreteria
import com.ayatschool.quickchat.databinding.FragmentSlideshowBinding

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val productos =listOf("Alambre", "Desarmador","Caja", "Espatula", "Martillo","Pala")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, productos)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spnProductos.adapter = adapter


        binding.btnRegistrar.setOnClickListener {
            val nombre = binding.edtNombre.text.toString()
            val telefono = binding.edtTelefono.text.toString().toInt()
            val correo = binding.edtCorreo.text.toString()
            val comentario= binding.spnProductos.selectedItem.toString()

            val ferreteria =Ferreteria(nombre,telefono,correo,comentario)

            Toast.makeText(
                requireContext(),"Registrado: ${ferreteria.nombre}, ${ferreteria.telefono}, ${ferreteria.correo},${ferreteria.comentario} ", Toast.LENGTH_LONG).show()


        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
