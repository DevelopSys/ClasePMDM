package com.borja.practicaequipos.dataset;

import com.borja.practicaequipos.R;
import com.borja.practicaequipos.utils.Equipo;
import com.borja.practicaequipos.utils.Jugador;
import com.borja.practicaequipos.utils.Liga;

import java.util.ArrayList;

public class DataSet {

    static ArrayList lista;

    public static DataSet newInstance() {
        DataSet dataSet = new DataSet();
        lista = new ArrayList();
        return dataSet;
    }

    public ArrayList listaEquiposLiga() {
        lista.add(new Equipo("FC.Barcelona", "CampNou", R.drawable.barsa));
        lista.add(new Equipo("Real Madrid", "Bernabeu", R.drawable.madrid));
        lista.add(new Equipo("Atletico de Madrid", "CampNou", R.drawable.atletico));
        lista.add(new Equipo("Valencia", "Mestalla", R.drawable.valencia));
        lista.add(new Equipo("Sevilla", "Sanchez Pijuan", R.drawable.sevilla));
        lista.add(new Equipo("Getafe", "Alfonso Perez", R.drawable.getafe));
        lista.add(new Equipo("Leganes", "Butarque", R.drawable.leganes));
        return lista;
    }

    public ArrayList listaEquiposPremier() {
        lista.add(new Equipo("M.City", "Etihad Stadium", R.drawable.city));
        lista.add(new Equipo("Liverpool", "Anfiled", R.drawable.liverpool));
        lista.add(new Equipo("Manchester United", "Old Traford", R.drawable.manchester));
        lista.add(new Equipo("Everton", "Goodison", R.drawable.everton));
        lista.add(new Equipo("Leicester", "King Power Stadium", R.drawable.leices));
        lista.add(new Equipo("Chelsea", "Stanford Bridge", R.drawable.chelsea));
        return lista;
    }

    public ArrayList listaEquiposItalia() {
        lista.add(new Equipo("Juventus", "Etihad Stadium", R.drawable.juventus));
        lista.add(new Equipo("Milan", "Old Traford", R.drawable.milan));
        lista.add(new Equipo("Inter", "Goodison", R.drawable.inter));
        return lista;
    }

    public ArrayList listaJugadoresAtleti(){
        lista = new ArrayList();
        lista.add(new Jugador("Thomas", "Lemar", "Delantero", true));
        lista.add(new Jugador("Alvaro", "Morata", "Delantero", true));
        lista.add(new Jugador("Joao Felix", "Sequeira", "Delantero", true));
        lista.add(new Jugador("Vitolo", "Machin", "Delantero", true));
        lista.add(new Jugador("Diego", "Costa", "Delantero", true));
        lista.add(new Jugador("Antonio", "Resurección", "Medio", true));
        lista.add(new Jugador("Saul", "Ñigüez", "Medio", true));
        lista.add(new Jugador("Antonio", "Resurección", "Medio", true));
        lista.add(new Jugador("Thomas", "Partey", "Medio", true));
        lista.add(new Jugador("Marcos", "Llorente", "Medio", true));
        lista.add(new Jugador("Mario", "Hermoso", "Defensa", true));
        lista.add(new Jugador("Hector", "Herrera", "Defensa", true));
        lista.add(new Jugador("Karey", "Tripier", "Defensa", true));
        lista.add(new Jugador("Jose María", "Jimenez", "Defensa", true));
        lista.add(new Jugador("Stefan", "Savic", "Defensa", true));
        lista.add(new Jugador("Antonio", "Adan", "Portero", true));
        lista.add(new Jugador("Jan", "Oblak", "Portero", true));
        return lista;
    }

    public ArrayList listaJugadoresBarsa() {
        lista = new ArrayList();
        lista.add(new Jugador("Leo", "Messi", "Delantero", true));
        lista.add(new Jugador("Luis", "Suarez", "Delantero", true));
        lista.add(new Jugador("Ousman", "Dembelé", "Delantero", false));
        lista.add(new Jugador("Antoine", "Griezman", "Delantero", true));
        lista.add(new Jugador("Sergio", "Busquet", "Medio", false));
        lista.add(new Jugador("Ivan", "Rakitic", "Medio", true));
        lista.add(new Jugador("Arturo", "Vidal", "Medio", false));
        lista.add(new Jugador("Artur", "Melo", "Medio", true));
        lista.add(new Jugador("Frakie", "DeJong", "Medio", true));
        lista.add(new Jugador("Gerard", "Pique", "Defensa", true));
        lista.add(new Jugador("Clement", "Lenglet", "Defensa", true));
        lista.add(new Jugador("Jordi", "Alba", "Defensa", false));
        lista.add(new Jugador("Sergi", "Roberto", "Defensa", false));
        lista.add(new Jugador("Nelson", "Semedo", "Defensa", false));
        lista.add(new Jugador("Marc Andre", "Ter Steiger", "Portero", true));
        lista.add(new Jugador("Norberto", "Murara", "Portero", false));
        return lista;
    }

    public ArrayList listaJugadoresMadrid() {
        lista = new ArrayList();
        lista.add(new Jugador("Eden", "Hazard", "Delantero", true));
        lista.add(new Jugador("Luka", "Modric", "Mediocentro", true));
        lista.add(new Jugador("Karim", "Benzema", "Delantero", true));
        lista.add(new Jugador("Sergio", "Ramos", "Defensa", false));
        lista.add(new Jugador("Rafael", "Varane", "Defensa", false));
        lista.add(new Jugador("Marcelo", "Vieria", "Defensa", false));
        lista.add(new Jugador("Daniel", "Carvajal", "Defensa", false));
        lista.add(new Jugador("Ferland", "Mendy", "Defensa", false));
        lista.add(new Jugador("Tony", "Kroos", "Mediocentro", false));
        lista.add(new Jugador("Carlos", "Casemiro", "Mediocentro", false));
        lista.add(new Jugador("Federico", "Valverde", "Mediocentro", false));
        lista.add(new Jugador("Lucas", "Vazquez", "Delantero", false));
        lista.add(new Jugador("Vinicius", "Junior", "Delantero", false));
        lista.add(new Jugador("Rodrygo", "Goes", "Delantero", false));
        lista.add(new Jugador("Gareth", "Bale", "Delantero", false));
        lista.add(new Jugador("Marco", "Asensio", "Delantero", false));
        lista.add(new Jugador("Francisco", "Alarcón", "Mediocentro", false));
        lista.add(new Jugador("Tibu", "Coutua", "Portero", false));
        lista.add(new Jugador("Alphonse", "Areola", "Defensa", false));
        return lista;
    }

    public ArrayList listaJugadoresCity(){
        lista = new ArrayList();
        lista.add(new Jugador("Kun", "Agüero", "Delantero", false));
        lista.add(new Jugador("Leroy", "Sane", "Delantero", false));
        lista.add(new Jugador("Riyad", "Marhez", "Delantero", false));
        lista.add(new Jugador("Gabriel Fernando", "De Jesus", "Delantero", false));
        lista.add(new Jugador("Rodrigo", "Hernandez", "Medio", false));
        lista.add(new Jugador("David", "Silva", "Medio", false));
        lista.add(new Jugador("Bernardo", "Silva", "Medio", false));

        return lista;
    }
}
