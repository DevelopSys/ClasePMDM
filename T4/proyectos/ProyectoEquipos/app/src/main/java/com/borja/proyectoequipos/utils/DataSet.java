package com.borja.proyectoequipos.utils;

import com.borja.proyectoequipos.R;

import java.util.ArrayList;

public class DataSet {

    public static DataSet newInstance(){

        DataSet dataSet = new DataSet();
        return dataSet;

    }

    public ArrayList getLigas(){
        ArrayList datos = new ArrayList();
        datos.add(new Liga("La Liga", R.drawable.laliga));
        datos.add(new Liga("Calcio", R.drawable.calcio));

        return datos;
    }

    public ArrayList getEquiposEsp(){
        ArrayList datos = new ArrayList();
        datos.add(new Equipo("FC Barcelona",R.drawable.barsa));
        datos.add(new Equipo("Real Madrid",R.drawable.madrid));
        return datos;
    }

    public ArrayList getEquiposIt(){
        ArrayList datos = new ArrayList();
        datos.add(new Equipo("Juventus",R.drawable.juventus));
        return datos;
    }

    public ArrayList getJugadoresMadrid(){
        ArrayList datos = new ArrayList();
        datos.add(new Jugador("Karim","delantero",true));
        datos.add(new Jugador("Ramos","defensa",false));
        return datos;
    }

    public ArrayList getJugadoresBarsa(){
        ArrayList datos = new ArrayList();
        datos.add(new Jugador("Messi","delantero",true));
        datos.add(new Jugador("Pique","defensa",false));
        return datos;
    }


}
