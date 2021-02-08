package com.borja.t07_navigationview.database;

import android.os.Bundle;

import com.borja.t07_navigationview.R;
import com.borja.t07_navigationview.utils.Hobbie;

import java.util.ArrayList;

public class DataSet {

    ArrayList<Hobbie> listaCompleta;

    public static DataSet newInstance() {

        DataSet dataSet = new DataSet();
        return dataSet;
    }

    public ArrayList getListaCompleta() {
        listaCompleta = new ArrayList<>();
        listaCompleta.add(new Hobbie("Barsa", "futbol", R.drawable.barsa));
        listaCompleta.add(new Hobbie("Champion", "futbol", R.drawable.champion));
        listaCompleta.add(new Hobbie("España", "futbol", R.drawable.espania));
        listaCompleta.add(new Hobbie("Madrid", "futbol", R.drawable.madrid));
        listaCompleta.add(new Hobbie("Milan", "futbol", R.drawable.milan));
        listaCompleta.add(new Hobbie("Big Bang Theory", "pelicula", R.drawable.big));
        listaCompleta.add(new Hobbie("Stranger Things", "pelicula", R.drawable.stranger));
        listaCompleta.add(new Hobbie("Malditos", "pelicula", R.drawable.malditos));
        listaCompleta.add(new Hobbie("Perdidos", "pelicula", R.drawable.lost));
        listaCompleta.add(new Hobbie("Fifa 19", "juego", R.drawable.fifa19));
        listaCompleta.add(new Hobbie("GTA", "juego", R.drawable.gta));
        listaCompleta.add(new Hobbie("The last of us", "juego", R.drawable.last));
        return listaCompleta;
    }

    public ArrayList getListaFiltrada(String detalle) {
        listaCompleta = new ArrayList<>();
        ArrayList listaFiltrada = new ArrayList<>();
        listaCompleta.add(new Hobbie("Barsa", "futbol", R.drawable.barsa));
        listaCompleta.add(new Hobbie("Champion", "futbol", R.drawable.champion));
        listaCompleta.add(new Hobbie("España", "futbol", R.drawable.espania));
        listaCompleta.add(new Hobbie("Madrid", "futbol", R.drawable.madrid));
        listaCompleta.add(new Hobbie("Milan", "futbol", R.drawable.milan));
        listaCompleta.add(new Hobbie("Big Bang Theory", "pelicula", R.drawable.big));
        listaCompleta.add(new Hobbie("Stranger Things", "pelicula", R.drawable.stranger));
        listaCompleta.add(new Hobbie("Malditos", "pelicula", R.drawable.malditos));
        listaCompleta.add(new Hobbie("Perdidos", "pelicula", R.drawable.lost));
        listaCompleta.add(new Hobbie("Fifa 19", "juego", R.drawable.fifa19));
        listaCompleta.add(new Hobbie("GTA", "juego", R.drawable.gta));
        listaCompleta.add(new Hobbie("The last of us", "juego", R.drawable.last));

        for ( Hobbie hobbie : listaCompleta ) {
            if(hobbie.getDetalle().equals(detalle)){
                listaFiltrada.add(hobbie);
            }
        }


        return listaFiltrada;
    }

    public ArrayList getListaJuegos() {
        listaCompleta = new ArrayList<>();
        listaCompleta.add(new Hobbie("Fifa 19", "juego", R.drawable.fifa19));
        listaCompleta.add(new Hobbie("GTA", "juego", R.drawable.gta));
        listaCompleta.add(new Hobbie("The last of us", "juego", R.drawable.last));
        return listaCompleta;
    }

    public ArrayList getHobbiePeliculas() {
        listaCompleta = new ArrayList<>();
        listaCompleta.add(new Hobbie("Big Bang Theory", "pelicula", R.drawable.big));
        listaCompleta.add(new Hobbie("Stranger Things", "pelicula", R.drawable.stranger));
        listaCompleta.add(new Hobbie("Malditos", "pelicula", R.drawable.malditos));
        listaCompleta.add(new Hobbie("Perdidos", "pelicula", R.drawable.lost));
        return listaCompleta;
    }

    public ArrayList getHobbieFutbol() {
        listaCompleta = new ArrayList<>();
        listaCompleta.add(new Hobbie("Barsa", "futbol", R.drawable.barsa));
        listaCompleta.add(new Hobbie("Champion", "futbol", R.drawable.champion));
        listaCompleta.add(new Hobbie("España", "futbol", R.drawable.espania));
        listaCompleta.add(new Hobbie("Madrid", "futbol", R.drawable.madrid));
        listaCompleta.add(new Hobbie("Milan", "futbol", R.drawable.milan));
        return listaCompleta;
    }


}
