public class AdaptadorListas extends BaseAdapter{

    ArrayList<Restaurante> listaRestaurantes;
    Context context;

    public AdaptadorListas(Context context, ArrayList lista){
        this.context = context;
        this.listaRestaurantes = lista;
    }

    public int getCount(){
        return listaRestaurantes.size();
    }

    public Object getItem(int position){
        return listaRestaurantes.get(position);
    }

    public long getItemId(int position){
        return position;
    }

    public View getView(View convertView, int posicion, ViewGroup parent ){

        convertView = LayoutInflater.from(context).inflate(R.layout.mi_vista,parent,false);
        TextView titulo = convertView.findViewById(R.id.titulo);
        TextView subTitulo = convertView.findViewById(R.id.sub_titulo);
        Restaurante restauranteActual = listaRestaurantes.get(posicion);
        titulo.setText(restauranteActual.getNombre());
        subTitulo.setText(restauranteActual.getLocalidad());



        return convertView;
    }

}