package com.develop.t3_spinner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.TextView
import com.develop.t3_spinner.adaptadores.AdaptadorPersonalizado
import com.develop.t3_spinner.databinding.ActivityMainBinding
import com.develop.t3_spinner.modelo.Pais
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var binding: ActivityMainBinding;
    lateinit var arraySpinner: ArrayList<Pais>;
    lateinit var adaptadorSencillo: ArrayAdapter<CharSequence>;
    lateinit var adaptadorPersonalizado: AdaptadorPersonalizado;
    lateinit var pais: Pais;
    lateinit var resultadoTexto: TextView;
    var numeroString:String= "2"
    var numeroNumero:Int= 2


    override fun onCreate(savedInstanceState: Bundle?) {

        resultadoTexto.text.toString().toInt() as Int
        numeroString.toInt()

        numeroNumero.toString()

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        asociarDatos()
        rellenarSpinnerPersonalizado()
        acciones()
    }

    private fun acciones() {
        /*binding.spinnerSimple.setOnItemClickListener { adapterView, view, i, l ->
            Snackbar.make(binding.spinnerSimple,i.toString(),Snackbar.LENGTH_SHORT).show()
        }*/

        binding.spinnerSimple.onItemSelectedListener = this;
        binding.spinnerComplejo.onItemSelectedListener = this
        binding.botonAgregar.setOnClickListener {
            var pais = Pais("Argentina", R.drawable.argentina, 0, "Messi");
            adaptadorPersonalizado.agregarPais(pais)
            //arraySpinner.add(pais)
            //adaptadorPersonalizado.notifyDataSetChanged()
        }
        binding.botonDetalle.setOnClickListener {
            // cambiar pantalla
            // pasando escudo, nombre, estrella
            var accionPasar: Intent = Intent(applicationContext,DetailActivity::class.java)
            // bundle
            var bundle = Bundle();
            //var equipoSeleccionado = binding.spinnerComplejo.selectedItem
            /*bundle.putInt("imagen", pais.imagen)
            bundle.putString("nombre", pais.nombre)
            bundle.putString("estrella", pais.estrella)
            bundle.putInt("titulos", pais.numeroTitulos)*/
            bundle.putSerializable("equipo",pais);
            accionPasar.putExtras(bundle)
            startActivity(accionPasar)
        }
    }

    private fun asociarDatos() {
        binding.spinnerSimple.adapter = adaptadorSencillo;
        binding.spinnerComplejo.adapter = adaptadorPersonalizado
    }

    private fun instancias() {
        arraySpinner = ArrayList()
        //adaptadorSencillo = ArrayAdapter(applicationContext,
        // android.R.layout.simple_spinner_item, arraySpinner)
        adaptadorSencillo = ArrayAdapter.createFromResource(
            applicationContext,
            R.array.paises,
            android.R.layout.simple_spinner_item
        );
        //adaptadorSencillo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // lista + xml + context --> adapter
        //rellenarSpinnerPersonalizado()
        adaptadorPersonalizado = AdaptadorPersonalizado(arraySpinner, this)

    }

    private fun rellenarSpinnerPersonalizado() {
        // lista --> array arraylist ó recurso-string
        arraySpinner.add(Pais("España", R.drawable.espania, 1, "Pedri"))
        arraySpinner.add(Pais("Brasil", R.drawable.brasil, 5, "Neymar"))
        arraySpinner.add(Pais("Alemania", R.drawable.alemania, 4, "Muller"))
        arraySpinner.add(Pais("Francia", R.drawable.francia, 2, "Mbappe"))
        arraySpinner.add(Pais("Qatar", R.drawable.qatar, 0, "Desconocido"))
        adaptadorPersonalizado.notifyDataSetChanged()



    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

        when (p0?.id) {
            R.id.spinner_simple -> {
                Log.v("testSpinner", adaptadorSencillo.getItem(p2).toString())
            }
            R.id.spinner_complejo -> {

                pais = adaptadorPersonalizado.getItem(p2) as Pais;
                //Log.v("testSpinner", pais.nombre)
                binding.imageEscudo.setImageResource(pais.imagen)
            }
        }

        //Snackbar.make(p1!!,p2.toString(),Snackbar.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}