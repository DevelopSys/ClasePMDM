**CardView** http://www.developandsys.es/cardview/
*****
1. Implementar la libreria de cardview y recyclerview
````
implementation 'com.android.support:recyclerview-v7:28.0.0'
implementation 'com.android.support:cardview-v7:28.0.0'
````
2. Crear un xml que configure el item del recycler
````
<?xml version="1.0" encoding="utf-8"?>
<android.support.v7.widget.CardView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/layoutRecycler"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_margin="10dp"
    android:gravity="center"
    android:orientation="vertical"
    android:elevation="50dp"
    app:cardCornerRadius="20dp">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:gravity="center">

        <ImageView
            android:id="@+id/imagenRecyclerItem"
            android:layout_width="100dp"
            android:layout_height="100dp"
            android:src="@mipmap/ic_launcher" />

        <TextView
            android:id="@+id/nombreRecyclerItem"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="10dp"
            android:text="asdasdasda"
            android:gravity="center"/>
        <TextView
            android:id="@+id/detalleRecyclerItem"
            android:layout_width="100dp"
            android:layout_height="wrap_content"
            android:text="Descripción de un elemento y que solo se ven dos lineas "
            android:lines="2"
            android:maxLines="2"
            android:ellipsize="end"
            android:gravity="center"/>
        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:id="@+id/botonItemRecycler"
            android:layout_gravity="center"
            android:text="Pulsar"
            style="@style/Widget.AppCompat.Button.Borderless.Colored"/>

        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:id="@+id/botonBorrarItemRecycler"
            android:layout_gravity="center"
            android:text="Borrar"
            style="@style/Widget.AppCompat.Button.Borderless.Colored"/>

    </LinearLayout>

</android.support.v7.widget.CardView>
````
3. Crear un adaptador que infle el xml creado
````
public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.Holder> {

    OnRecyclerListener onRecyclerListener;
    Context context;
    List<Juego> listaDatos;

    public AdaptadorRecycler(Context context) {
        this.context = context;
        listaDatos = DataSet.newInstance().darJuegos();
        onRecyclerListener = (OnRecyclerListener) context;

    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_recycler, viewGroup, false);
        Holder h = new Holder(v);
        return h;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        
    }

    public void borrarElemento(Juego juego){
        listaDatos.remove(juego);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listaDatos.size();
    }   

}

````
4. Trabajar el elemento como si fuese un elemento normal de RecyclerView