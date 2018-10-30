# Septima semana

## TEMA 2 VISTAS

### MARTES 
**Crear un adaptador personzalizado**
***

1. Crear un xml que represente el aspecto que tendrá una fila del elemento spinner
````
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="horizontal"
    android:layout_margin="10dp">

    <ImageView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/imagenSpinner"
        android:src="@mipmap/ic_launcher"/>

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/nombreSpinner"
        android:text=""
        android:textSize="30dp"
        android:gravity="center_vertical|center_horizontal"
        android:textAlignment="center"
        />

</LinearLayout>
````
2. Crear una clase que exienda de ArrayAdapter
````
public class AdaptadorSpinnerPerso extends BaseAdapter{

    @Override
    public int getCount() {
        return null;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return null;
    }
}

````
3. Crear un constructor que permita la obtención de una lista de datos y el contexto donde se ejecutan los elementos
````
public class AdaptadorSpinnerPerso extends BaseAdapter{

    List listaDatos;
    Context context;

    public AdaptadorSpinnerPerso(List listaDatos, Context context) {
        this.listaDatos = listaDatos;
        this.context = context;
    }
}
````
4. Rellenar los métodos sobreescritos
4.1 getCount() devuelve el número de filas que se deben pintar en el elemento
4.2 getItemId() devuelve el id del elemento seleccionado
4.3 getItem() devuelve el elemento seleccionado
4.4 getView() devuleve el la vista que será utilizada para representar cada una de las filas del elemento. Para poder "pegar la vista que se ha generado en el punto 1 se utiliza un objeto de tipo inflater"

````
package com.example.borja.ejemploinicial.elementos.adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.borja.ejemploinicial.R;
import com.example.borja.ejemploinicial.utils.Persona;
import java.util.ArrayList;
import java.util.List;

public class AdaptadorSpinnerPerso extends BaseAdapter{

    List listaDatos;
    Context context;

    public AdaptadorSpinnerPerso(List listaDatos, Context context) {
        this.listaDatos = listaDatos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaDatos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaDatos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.item_spinner_layout,parent,false);
        return convertView;
    }
}
````
