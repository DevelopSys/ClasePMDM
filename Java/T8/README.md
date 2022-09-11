<a name="tema8"></a>
## Almacenamiento				
***

a.	SharedPreferences
- http://www.developandsys.es/shared-preferences/
#### [Volver al índice](#tema8)
***

Las shared preferences representan una forma sencilla de guardar información o configuraciones de la aplicación. Se suelen utilizar para guardar elementos simples ya que se guardar en un archivo con formato par clave valor. Este archivo se puede comparir con todas las aplicaciones instaladas en el teléfono o para uso personal.

Para crear el archivo de shared: 

1. Crear una instancia del objeto en modo privado para que solo la aplicación pueda verlas
````
SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
````
Por defecto se guardará con el nombre sharedpreferences.xml

2.  Una vez creado el fichero, con la instancia anterior se puede tanto guardar elementos como leer su contenido.
- Para guardar elementos se utuliza un objeto de tipo editor
````
SharedPreferences.Editor editor = sharedPreferences.edit();
editor.putBoolean(TAG_RECORDAR,checkBox.isChecked());
editor.commit();
````
Siempre es importante terminar con un commit para garantizar la operación

- Para leer elementos simplemente se pide el tipo con la clave asociada
````
Boolean creado = sharedPreferences.getBoolean(TAG_RECORDAR,false);
````
Alternativamente se pueden obtener todas los valores guardados en un Map

````
editor.getKeys();
````
**Manejo de eventos en el archivo de shared**
Se peude actuar ante un cambio de estado en el archivo de de shared mediante el método registerOnSharedPreferenceChangeListener()

````
sharedPreferences.registerOnSharedPreferenceChangeListener(new SharedPreferences.OnSharedPreferenceChangeListener() {
    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        Log.v("test","Clave modificada "+s);
        Log.v("test","Elemento guardado:"+sharedPreferences.getBoolean(s,false));
    }
});
 
checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(TAG_RECORDAR,checkBox.isChecked());
        editor.commit();
    }
});
````

b.	SQLite3
- http://www.developandsys.es/sqlite/
- http://www.developandsys.es/sqlite-cursoradapter/
- http://www.developandsys.es/recycler-view-sqlite/

SQLite3 es el motor de base de datos interno de la aplicación, el cual viene incluido en le sdk y crea una base de datos interna. Es muy útil cuando se quiere realizar un diseño interior, es decir que no tenga comunicación con el exterior. También se puede utilizar como respaldo a una base de datos externa

1. (opcional) Crear una clase que represente la estructura de la base de datos. En ella aparecerán los nombres de la tabla y campos.

````
    public static abstract class EntradaUsuario implements BaseColumns{

		public static final int VERSION = 1;
	    public static final String NOMBRE_DB = "Usuarios.db";
        public static final String NOMBRE_TABLA = "usuarios";
        public static final String NOMBRE = "nombre";
        public static final String APELLIDO = "apellido";
        public static final String DIRECCION = "direccion";
        public static final String TELEFONO = "telefono";
        
    }
````

La implementación de la interfaz BaseColumns es útil para que se agrege un campo _id necesario para manejar de forma correcta los resultados a querys de SELECT

2. Crear un adaptador que permira la creación o utilización (en caso de que esté creada) de la base de datos. También podrá actualizar la base de datos si se indica una versión diferente a la existente

````
public class UsuarioOpenHelper extends SQLiteOpenHelper {

    

    public UsuarioOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+EntradaUsuario.NOMBRE_TABLA+" ("
                +EntradaUsuario._ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +EntradaUsuario.NOMBRE+" TEXT NOT NULL,"
                +EntradaUsuario.APELLIDO+" TEXT NOT NULL,"
                +EntradaUsuario.DIRECCION+" TEXT NOT NULL,"
                +EntradaUsuario.TELEFONO+" INTEGER NOT NULL)");
    }

	// metodo que se ejecutará si la versión cambia en algún momento (i e i1 representan versión anterior y nueva respectivamente)
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
       sqLiteDataBase.exeqSQL("DROP TABLE IF EXISTS "+ EsquemaUsuario.EntradaUsuario.NOMBRE_TABLA);
       onCreate(sqLiteDatabase);
    }
}
````
3. Una vez creada la clase anterior se puede crear un objeto de la misma (en el sitio a utilizar la base de datos) para poder tener un acceso a la bd. Se puede realizar un acceso de escritura (UPDATE, INSERT, DELETE) o de lectura (SELECT)
````
public class SqliteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        UsuarioOpenHelper usuarioOpenHelper = new UsuarioOpenHelper(getApplicationContext(),EsquemaUsuario.EntradaUsuario.NOMBRE_DB,null,EntradaUsuario.VERSION);
        SQLiteDatabase dbUsuarios = usuarioOpenHelper.getReadableDatabase();
        SQLiteDatabase dbUsuariosEscritura = usuarioOpenHelper.getWritableDatabase();
    }
}
````
Para el manejo de los datos se puede realizar de dos formas: 
- Mediante métodos específicos (insert, delete, update, select)
- Mediante la ejecución de querys

#### Inserciones

1. Partiendo del adaptador creado anteriormente, se abre la base de datos en escritura
````
SQLiteDatabase dbUsuariosEscritura = usuarioOpenHelper.getWritableDatabase();
````
2. Se crea un objeto de tipo ContentValue y se pasa en formato clave valor la columna donde se inserta y el dato a insertar. 
````
SQLiteDatabase dbUsuariosEscritura = usuarioOpenHelper.getWritableDatabase();
ContentValues nuevoRegistro = new ContentValues();
nuevoRegistro.put(EntradaUsuario.NOMBRE, "Nombre1");
nuevoRegistro.put(EntradaUsuario.APELLIDO, "Apellido1");
nuevoRegistro.put(EntradaUsuario.DIRECCION, "Direccion1");
nuevoRegistro.put(EntradaUsuario.TELEFONO, 111111);
````
3. Por último se ejecuta el método insert al cual se le pasan el nombre de la tabla, un CursorFactory y el ContentValue creado. 
````
SQLiteDatabase dbUsuariosEscritura = usuarioOpenHelper.getWritableDatabase();
ContentValues nuevoRegistro = new ContentValues();
nuevoRegistro.put(EntradaUsuario.NOMBRE, "Nombre1");
nuevoRegistro.put(EntradaUsuario.APELLIDO, "Apellido1");
nuevoRegistro.put(EntradaUsuario.DIRECCION, "Direccion1");
nuevoRegistro.put(EntradaUsuario.TELEFONO, 111111);
dbUsuariosEscritura.insert(EntradaUsuario.NOMBRE_TABLA,null,nuevoRegistro);
dbUsuariosEscritura.close();
````
Es importante que siempre que se utilice la base de datos se cierra (con cada uso se hace una apertura y un cerrado)

**Mediante Query**

1. Partiendo del adaptador creado anteriormente, se abre la base de datos en escritura
````
SQLiteDatabase dbUsuariosEscritura = usuarioOpenHelper.getWritableDatabase();
````
2. Se crea la query que realiza la inserción. Se puede hacer directa o mediante el formateo de un string
````
String query = "INSERT INTO %s (%s,%s,%s) VALUES ('%s','%s','%s')";
dbUsuariosEscritura.execSQL(String.format(query
                        , EntradaUsuario.NOMBRE_TABLA
                        , EntradaUsuario.NOMBRE
                        , EntradaUsuario.APELLIDO
                        , EntradaUsuario.DIECCION
                        , "NombreSQL"
                        , "ApellidoSQL"
                        , "CorreoSQL"));
dbUsuariosEscritura.close();
````

#### Borrados

1. Abrir la base de datos de escritura
````
baseDatos = helperDB.getWritableDatabase();
````
2. Ejecutar el método delete indicando el nombre de la tabla, las clausulas where y los parámetros de las mismas
````
dbUsuariosEscritura.delete(EntradaUsuario.NOMBRE_TABLA, EntradaUsuario.NOMBRE+"=?",new String[]{"Nombre1"});
dbUsueriosEscritura.close();
````
**Mediante Query**

1. Partiendo del adaptador creado anteriormente, se abre la base de datos en escritura
````
SQLiteDatabase dbUsuariosEscritura = usuarioOpenHelper.getWritableDatabase();
````
2. Se crea la query que realiza el borrado. Se puede hacer directa o mediante el formateo de un string
````
dbUsuariosEscritura = helperDB.getWritableDatabase();
String query = "DELETE FROM %s WHERE %s='%s'";
                baseDatos.execSQL(String.format(query
                , EntradaUsuario.NOMBRE_TABLA
                , EntradaUsuario.NOMBRE
                , "NombreCV"));
dbUsuariosEscritura.close();
````

#### Actualización

1. Partiendo del adaptador creado anteriormente, se abre la base de datos en escritura
````
SQLiteDatabase dbUsuariosEscritura = usuarioOpenHelper.getWritableDatabase();
````
2. Se crea un objeto de tipo ContentValue y se pasa en formato clave valor la columna donde se actualiza y el dato a actualizar
````
SQLiteDatabase dbUsuariosEscritura = usuarioOpenHelper.getWritableDatabase();
ContentValues actualizaUsuario = new ContentValues();
actualizaUsuario.put(EntradaUsuario.NOMBRE,"NombreNuevo");
````
3. Se ejecuta el método update donde se indica el nombre de la tabla, el objeto ContentValue, las clausulas where y los parámetros de las mismas
````
SQLiteDatabase dbUsuariosEscritura = usuarioOpenHelper.getWritableDatabase();
ContentValues actualizaUsuario = new ContentValues();
actualizaUsuario.put(EntradaUsuario.NOMBRE,"NombreNuevo");
dbUsuariosEscritura.update(EsquemaUsuario.NOMBRE_TABLA,actualizarUsuario,EntradaUsuario.NOMBRE+"=?",new String[]{"Nombre1"});
dbUsuariosEscritura.close();
````

**Mediante Query**
1. Partiendo del adaptador creado anteriormente, se abre la base de datos en escritura
````
SQLiteDatabase dbUsuariosEscritura = usuarioOpenHelper.getWritableDatabase();
````
2. Se crea la query que realiza el borrado. Se puede hacer directa o mediante el formateo de un string
````
SQLiteDatabase dbUsuariosEscritura = usuarioOpenHelper.getWritableDatabase();
String query = "UPDATE %s SET %s='%s' WHERE %s='%s'";
                dbUsuariosEscritura.execSQL(String.format(query,EntradaUsuario.NOMBRE_TABLA,
                        EntradaUsuario.NOMBRE
                        , "NombreNuevo"
                        , DatosBD.NOMBRE
                        , "NombreSQL"));
dbUsuariosEscritura.close();
````

#### Selección

1. Partiendo del adaptador creado anteriormente, se abre la base de datos en lectura
````
SQLiteDatabase dbUsuariosLectura = helperDB.getReadableDatabase();
````
2. Crear la query que realiza la selección e igualarla a un objeto de tipo Cursos (un mapa de datos)
````
String query = "SELECT * FROM %s";
Cursor c = baseDatos.rawQuery(String.format(query,DatosBD.NOMBRE_TABLA),null);
````
3. Se recorre el cursor para extraer todos los registros. Para ello se utiliza el método moveToFirst y moveToNext()
````
 while (c.moveToNext()){
            int id = c.getInt(c.getColumnIndex(DatosBD._ID));
            String nombre = c.getString(c.getColumnIndex(DatosBD.TAB_ALU_COL_NOM));
            String apellido = c.getString(c.getColumnIndex(DatosBD.TAB_ALU_COL_APE));
            String correo = c.getString(c.getColumnIndex(DatosBD.TAB_ALU_COL_CORR));
            Usuarios u = new Usuarios(id,nombre,apellido,correo);
            Log.v("bd",String.valueOf(u.getId())+" "+u.getNombre());
        }

dbUsuariosLectura.close();
````
Adicionalmente se utiliza el método cursos.getTipo() el cual admite como parámetro un número que representa la posición de la columna que se quiere utilizar. Para ello se puede obtener de forma directa (si se sabe) o mediante el método getColumnIndex con el nombre de la columna de la que se quiere obtener la posición


**Adaptador para cursores**
Al igual que pasaba en las listas de datos personalizadas, también se puede crear un adaptador personalizado con datos que provienen de una base de datos sqlite3. 
Es muy importante que el cursor que se utilice para el adaptador cuente con una columna _id. Esta columna se puede crear manualmente o implementando la interfaz BaseColumns como se hizo en el ejemplo anterior
Para ello:
1. Crear una clase que exitienda de CursorAdapter
````
public class AdaptadorCursor extends CursorAdapter {
 
    public AdaptadorCursor(Context context, Cursor c) {
        super(context, c, 0);
    }
 
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
 
        return null;
    }
 
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        
    }
}
````
Los métodos que se implementan son los siguientes:
- newView: El cual retorna la vista que será utilizada en cada una de las filas de la lista
- bindView: La forma en la que se rellenan cada una de las filas

2. Teniendo en cuenta que se ha creado un xml que represente el aspecto de la fila:
````
public class AdaptadorCursor extends CursorAdapter {

    public AdaptadorCursor(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.item_layout, viewGroup,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView nombre, apellido, direccion, telefono;
        nombre = view.findViewById(R.id.text_nombre_item);
        apellido = view.findViewById(R.id.text_apellido_item);
        direccion = view.findViewById(R.id.text_direccion_item);
        telefono = view.findViewById(R.id.text_telefono_item);

        nombre.setText(cursor.getString(cursor.getColumnIndex(EsquemaUsuario.EntradaUsuario.NOMBRE)));
        apellido.setText(cursor.getString(cursor.getColumnIndex(EsquemaUsuario.EntradaUsuario.APELLIDO)));
        direccion.setText(cursor.getString(cursor.getColumnIndex(EsquemaUsuario.EntradaUsuario.DIRECCION)));
        telefono.setText(String.valueOf(cursor.getInt(cursor.getColumnIndex(EsquemaUsuario.EntradaUsuario.TELEFONO))));
    }
}
````
3. Asociar el cursor creado con una lista de datos
````
SQLiteDatabase dbUsuariosLectura = usuarioOpenHelper.getReadableDatabase();
Cursor c = dbUsuariosLectura.query(EsquemaUsuario.EntradaUsuario.NOMBRE_TABLA, null, null, null, null, null, null);
AdaptadorCursor adaptador = new AdaptadorCursor(this,c);
lista.setAdapter(adaptador);
dbUsuariosLectura.close();
````


#### [Volver al índice](#tema8)
***


c.	Comunicación http
- http://www.developandsys.es/base-datos-externa/

#### [Volver al índice](#tema8)
***


d.	Firebase
- http://www.developandsys.es/firebase-database/
- http://www.developandsys.es/firebase-recyclerview/
- http://www.developandsys.es/iniciar-sesion-crear-usuarios-firebase/
				
#### [Volver al índice](#tema8)
***

