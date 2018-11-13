# Novena semana
## Tema 2

**RecyclerView**
*****
1. Importar librerias necesarias en el gradle
````
implementation 'com.android.support:recyclerview-v7:28.0.0'
implementation 'com.android.support:design:28.0.0'
````
2. Crear un objeto recycler en el xml y instanciarlo en el .java
````
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <android.support.v7.widget.RecyclerView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/recyclerView"
        />

</LinearLayout>
````
````
recyclerView = findViewById(R.id.recyclerView);
````
3. Crear un xml con el aspecto que tendrá cada una de las filas del recycler

````
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="horizontal"
    android:id="@+id/layoutItem">

    <ImageView
        android:layout_width="0dp"
        android:layout_weight="0.2"
        android:layout_height="wrap_content"
        android:src="@mipmap/ic_launcher" />

    <LinearLayout
        android:layout_width="0dp"
        android:layout_weight="0.4"
        android:layout_height="match_parent"
        android:orientation="vertical"
        android:weightSum="1">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_weight="0.5"
            android:gravity="center_horizontal|center_vertical"
            android:id="@+id/nombreItem"/>

        <TextView
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_weight="0.5"
            android:gravity="center_horizontal|center_vertical"
            android:id="@+id/apellidItem"/>

    </LinearLayout>

    <TextView
        android:layout_width="0dp"
        android:layout_weight="0.4"
        android:layout_height="wrap_content"
        android:id="@+id/telefonoItem"
        android:layout_gravity="center"/>

</LinearLayout>
````
4. Crear una clase que extienda de RecyclerView.Adapter junto con una clase que exienda de RecyclerView.ViewHolder
````
public class AdaptadorPersoRecycler extends RecyclerView.Adapter<AdaptadorPersoRecycler.HolderPropio> {

    List<Persona> listaDatos;
    Context context;

    public AdaptadorPersoRecycler(Context context) {
               this.context = context;
    }

    @NonNull
    @Override
    public HolderPropio onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderPropio holderPropio, final int i) {
       
    }

    @Override
    public int getItemCount() {
        return null;
    }

   class HolderPropio extends RecyclerView.ViewHolder {

        public HolderPropio(@NonNull View itemView) {
            super(itemView);
            
        }

    }
}
````
5. Rellenar los métodos
- length: cantidad de elementos que tendrá la lista
````
    @Override
    public int getItemCount() {
        return listaDatos.size();
    }
````
- onCreateViewHolder: creación del objeto de tipo holder que tendrá la vista xml previamente inflada
````
    @NonNull
    @Override
    public HolderPropio onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(context).inflate(R.layout.item_recycler, viewGroup, false);
        HolderPropio holderPropio = new HolderPropio(v);
        return holderPropio;
    }
````

- onBindViewHolder: representar cada uno de los objetos que se "pintarán en las filas"
````
    @Override
    public void onBindViewHolder(@NonNull HolderPropio holderPropio, final int i) {
        final Persona p = listaDatos.get(i);
        holderPropio.getNombre().setText(p.getNombre());
        holderPropio.getApellido().setText(p.getApellido());
        holderPropio.getTelefono().setText(String.valueOf(p.getTelefono()));
        holderPropio.getNombre().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, p.getNombre(), Toast.LENGTH_SHORT).show();
                adaptadorPersoListener.onAdaptadorPersoSelected(p);
            }
        });
    }
````
- Clase Holder: representa los objetos del xml, instanciandolos
````
    class HolderPropio extends RecyclerView.ViewHolder {

        TextView nombre, apellido, telefono;
        LinearLayout linearLayout;


        public HolderPropio(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombreItem);
            telefono = itemView.findViewById(R.id.telefonoItem);
            apellido = itemView.findViewById(R.id.apellidItem);
            linearLayout = itemView.findViewById(R.id.layoutItem);
        }

        public TextView getNombre() {
            return nombre;
        }

        public TextView getApellido() {
            return apellido;
        }

        public TextView getTelefono() {
            return telefono;
        }

        public LinearLayout getLinearLayout() {
            return linearLayout;
        }
    }
````
6. Crear un objeto de tipo adaptador en la clase donde está el recycler
````
adaptadorPersoRecycler = new AdaptadorPersoRecycler(this);
recyclerView.setAdapter(adaptadorPersoRecycler);
````
7. Poner un Layout al recycler y un divisor entre elementos
````
recyclerView.setLayoutManager(
                new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
recyclerView.addItemDecoration(
                new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
````

### Interfaz de callback
****
1. Crear una interfaz en el origen de los datos con un método que contenga los datos que se quieren pasar. EN este caso la clase del adaptador
````
package com.system.develop.t2_03_recycler.adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.system.develop.t2_03_recycler.MainActivity;
import com.system.develop.t2_03_recycler.R;
import com.system.develop.t2_03_recycler.utils.Persona;

import java.util.ArrayList;
import java.util.List;

public class AdaptadorPersoRecycler extends RecyclerView.Adapter<AdaptadorPersoRecycler.HolderPropio> {

    // incluir el resto de métodos explicados anteriormente   
    public interface OnAdaptadorPersoListener{
        public void onAdaptadorPersoSelected(Persona persona);
    }
   
    }
}
````
2. Crear un objeto del tipo interfaz e igualarlo al contexto
````
public class AdaptadorPersoRecycler extends RecyclerView.Adapter<AdaptadorPersoRecycler.HolderPropio> {

    Context context;
	OnAdaptadorPersoListener adaptadorPersoListener;
    // incluir el resto de métodos explicados anteriormente   
    
    public AdaptadorPersoRecycler(Context context) {
        
        this.context = context;
        adaptadorPersoListener = (OnAdaptadorPersoListener) context;
    }
    
    public interface OnAdaptadorPersoListener{
        public void onAdaptadorPersoSelected(Persona persona);
    }
 
}
````
3. Llamar al método creado en la interfaz cuando se quieran lanzar los datos al destino

````
@Override
    public void onBindViewHolder(@NonNull HolderPropio holderPropio, final int i) {
        final Persona p = listaDatos.get(i);
        holderPropio.getNombre().setText(p.getNombre());
        holderPropio.getApellido().setText(p.getApellido());
        holderPropio.getTelefono().setText(String.valueOf(p.getTelefono()));
        holderPropio.getNombre().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, p.getNombre(), Toast.LENGTH_SHORT).show();
                adaptadorPersoListener.onAdaptadorPersoSelected(p);
            }
        });
    }
````
4. Implementar la interfaz en el destino de los datos, obligando a implementar los métodos
````
public class MainActivity extends AppCompatActivity implements AdaptadorPersoRecycler.OnAdaptadorPersoListener {

    RecyclerView recyclerView;
    AdaptadorPersoRecycler adaptadorPersoRecycler;
    Persona p;

   	// incluir todos los métodos de la clase

    @Override
    public void onAdaptadorPersoSelected(Persona persona) {
        p = persona;
        Toast.makeText(getApplicationContext(),"Persona en Activity" + p.getNombre(),Toast.LENGTH_SHORT).show();
    }
}
````

## PRÁCTICAS A ENTREGAR
Versiones
***
Realizar dos prácticas sobre la misma funcionalidad, una con ListView y otra con RecyclerView

![Práctica versiones](https://github.com/DevelopSys/clasepmdm/blob/master/practicas/versiones1.png "Práctica versiones") ![Práctica versiones](https://github.com/DevelopSys/clasepmdm/blob/master/practicas/versiones2.png "Práctica versiones")
