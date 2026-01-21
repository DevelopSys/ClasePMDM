package com.example.agendajson.ui.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.example.agendajson.databinding.ActivityMainBinding
import com.example.agendajson.databinding.DialogoUserBinding
import com.example.agendajson.model.Usuario

class DialogUser : DialogFragment() {


    companion object {
        // 1- companion object con un metodo
        fun newInstance(user: Usuario): DialogUser {
            val dialog = DialogUser()
            val bundle = Bundle()
            bundle.putSerializable("user",user)
            dialog.arguments = bundle
            return dialog
        }
    }

    private lateinit var binding: DialogoUserBinding
    private lateinit var user: Usuario

    // 2 recupero los argumentos y los hago variables de clase
    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.user = this.arguments?.getSerializable("user") as Usuario
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())

        // title
        // message - list
        // button
        binding = DialogoUserBinding.inflate(layoutInflater)
        builder.setView(binding.root)
        // 3. Utiliza la variable de clase creada con los argumentos
        binding.correoDetalle.text = user.email
        binding.nombreDetalle.text = user.firstName
        binding.edadaDetalle.text = user.age.toString()
        Glide.with(requireContext()).load(user.image)
            .into(binding.imagenDetalle)

        return builder.create()
    }

}


/* Agregar un item en el menu de la pantalla general
    - Ver favoritos: si lo pulso me muestra una activity con todos los
    usuarios que se han marcado como favoritos

   Dentro de cada item del recycler general, al pulsar el meno add fav,
   agregara el usuario a favorito

   DATASET

   En la pantalla de favoritos, cada uno de los item, tendrá un menu que muestre:
   - Ver detalle
   - Eliminar fav
 */
