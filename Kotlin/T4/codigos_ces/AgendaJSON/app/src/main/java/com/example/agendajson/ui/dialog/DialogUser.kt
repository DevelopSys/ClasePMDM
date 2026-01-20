package com.example.agendajson.ui.dialog

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.example.agendajson.R
import com.example.agendajson.databinding.ActivityMainBinding
import com.example.agendajson.databinding.DialogoUserBinding
import com.example.agendajson.model.User

class DialogUser : DialogFragment() {

    private lateinit var binding: DialogoUserBinding
    private lateinit var user: User

    companion object{
        fun newInstance(user: User): DialogUser {
            val dialogo = DialogUser()
            val bundle = Bundle()
            bundle.putSerializable("user",user)
            dialogo.arguments  = bundle
            return dialogo
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.user = this.arguments?.getSerializable("user") as User
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())

        // builder.setTitle()
        // builder.setMessage()
        // builder.setPositiveButton()
        //  LayoutInflater.from(requireContext())
        binding = DialogoUserBinding.inflate(layoutInflater)
        // val v: View =  layoutInflater.inflate(R.layout.dialogo_user, null)
        // builder.setView(v)
        builder.setView(binding.root)
        binding.correoDialogo.text = user.email
        binding.nombreDialogo.text = user.firstName
        binding.generoDialogo.text = user.gender.toString()
        binding.edadDialogo.text = user.age.toString()
        Glide.with(requireContext()).load(user.image).into(binding.imagenDialogo)

        return builder.create()
    }


}