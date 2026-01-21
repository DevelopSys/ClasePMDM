package com.example.agendajson.ui.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.agendajson.databinding.ActivityMainBinding
import com.example.agendajson.databinding.DialogoUserBinding

class DialogUser: DialogFragment() {

    private lateinit var binding: DialogoUserBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())

        // title
        // message - list
        // button
        binding = DialogoUserBinding.inflate(layoutInflater)
        builder.setView(binding.root)

        return builder.create()
    }

}
