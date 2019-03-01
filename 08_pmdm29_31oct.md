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

**Realizar un Adaptador optimizado**
***

1. Crear una clase anidada en la clase del adaptador vista anteriormente con los elementos que contiene la vista (fila del elemento) con un constructor e implementarlos
````
public class AdaptadorSpinnerPerso extends BaseAdapter {

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

    
        return convertView;
    }

    class HolderAdicional{

        TextView nombre;
        ImageView imagen;

        public HolderAdicional(View view) {
            nombre = view.findViewById(R.id.nombreSpinner);
            imagen = view.findViewById(R.id.imagenSpinner);
        }

        public TextView getNombre() {
            return nombre;
        }

        public ImageView getImagen() {
            return imagen;
        }
    }
}
````
2. Modificar el método getView para que solo se rellene la vista la primera vez que se ejecute y el resto de veces se recuperen los datos
````
@Override
    public View getView(int position, View convertView, ViewGroup parent) {

        HolderAdicional holderAdicional = null;

        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_spinner_layout, parent, false);
            holderAdicional = new HolderAdicional(convertView);
            convertView.setTag(holderAdicional);

        }
        else {
            holderAdicional = (HolderAdicional) convertView.getTag();
        }

        Persona p = (Persona) listaDatos.get(position);
        if (p.getSexo() == 0) {
            holderAdicional.getImagen().setImageResource(R.drawable.c1);
        } else if (p.getSexo() == 1) {
            holderAdicional.getImagen().setImageResource(R.drawable.c2);
        }
        holderAdicional.getNombre().setText(p.getNombre());

        holderAdicional.getImagen().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Has pulsado imagen",Toast.LENGTH_SHORT).show();
            }
        });
        holderAdicional.getNombre().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Has pulsado nombre",Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
````
### MIERCOLES
**Objeto de tipo ListView**
***
Un objeto de tipo listView tiene la misma funcionalidad que un Spinner pero la forma de representación de los datos cambia.
1. Crear el xml de la actividad con el listview
````
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".elementos.ListaActivity"
    android:orientation="vertical">

    <ListView
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="0.8"
        android:id="@+id/listaListView" 
        android:divider="@color/colorAccent"
        android:dividerHeight="1dp"/>

</LinearLayout>
````
2. Instanciarlo en el .java de la actividad y crear un adaptador simple con el layout que android ofrece para asociarlo
````
lista = findViewById(R.id.listaListView);
ArrayList listaOpciones= new ArrayList();
for(int i=0;i<101;i++){
   listaOpciones.add("Opción "+String.valueOf(i));
 }
ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,listaOpciones);
lista.setAdapter(adapter);
````
3. Evaluar la pulsación de la lista evaluando la posición
````
lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
@Override
public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
      Toast.makeText(getApplicationContext(),"Posición: "+String .valueOf(position),Toast.LENGTH_SHORT).show(); 
      parent.getAdapter().getItem(position);     
   }
});
````
**ListView con un adaptador personalizado**
***
1. Crear el xml que representa el aspecto de la fila
````
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="horizontal"
    android:layout_margin="10dp">

    <ImageView
        android:layout_width="50dp"
        android:layout_height="50dp"
        android:scaleType="centerCrop"
        android:id="@+id/imagenLista"
        android:src="@mipmap/ic_launcher"/>

    <TextView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/nombreLista"
        android:text=""
        android:textSize="30dp"
        android:gravity="center_vertical|center_horizontal"
        android:textAlignment="center"
        />

</LinearLayout>
````
2. Crear una clase que extienda de baseadapter y sobreescribir los metodos
````
public class AdaptadorListaPerso extends BaseAdapter {

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
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return null;
    }

}
````
3. Crear un constructor en la misma clase al que se le pasen los parámetros necesarios. Lo normal es que necesite un contexto un una lista de datos
````
    List listaDatos;
    Context context;

    public AdaptadorListaPerso(List listaDatos, Context context) {
        this.listaDatos = listaDatos;
        this.context = context;
    }
````
4. Rellenar los métodos correspondientes que se han sobreescrito en la clase
````
public class AdaptadorListaPerso extends BaseAdapter {

    List listaDatos;
    Context context;

    public AdaptadorListaPerso(List listaDatos, Context context) {
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

        HolderAdicional holderAdicional = null;

        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_spinner_layout, parent, false);
            holderAdicional = new HolderAdicional(convertView);
            convertView.setTag(holderAdicional);

        }
        else  
            holderAdicional = (HolderAdicional) convertView.getTag();

        Persona p = (Persona) listaDatos.get(position);
        holderAdicional.getNombre().setText(p.getNombre());
        holderAdicional.getImagen().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Has pulsado imagen",Toast.LENGTH_SHORT).show();
            }
        });
        holderAdicional.getNombre().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Has pulsado nombre",Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    class HolderAdicional{

        TextView nombre;
        ImageView imagen;

        public HolderAdicional(View view) {
            nombre = view.findViewById(R.id.nombreSpinner);
            imagen = view.findViewById(R.id.imagenSpinner);
        }

        public TextView getNombre() {
            return nombre;
        }

        public ImageView getImagen() {
            return imagen;
        }
    }
}
````
5. Crear un objeto de tipo adaptador en la clase de la actividad y ponerselo a la lista
````
AdaptadorListaPerso adaptadorListaPerso = new AdaptadorListaPerso(personas,getApplicationContext());
lista.setAdapter(adaptadorLsitaPerso);
````
