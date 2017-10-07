package pe.edu.upc.collectionssample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import pe.edu.upc.collectionssample.R;
import pe.edu.upc.collectionssample.dbmodelo.Platos;

import java.util.List;

/**
 * Created by Casa on 22/09/2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private List<Platos> listData;
    private Context mainContext;
    private LayoutInflater layoutInflater;

    public Adapter(List<Platos> listData, Context context) {
        this.mainContext = context;
        this.listData = listData;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imagen;
        public TextView nombre;
        public TextView precio;




        public ViewHolder(View v) {
            super(v);
            this.imagen = (ImageView)v.findViewById(R.id.imageView2);
            this.nombre = (TextView) v.findViewById(R.id.descripcion);
            this.precio = (TextView)v.findViewById(R.id.precio);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                                 int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listaplatosfragment, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Platos plato =listData.get(position);

        if ((listData.get(position).getResumen()).equals("hamburguesa")){
            holder.imagen.setImageResource(R.drawable.hamburguesa);
        }else if ((listData.get(position).getResumen()).equals("pollo apanado")){
            holder.imagen.setImageResource(R.drawable.pollo);
        }else if ((listData.get(position).getResumen()).equals("pizza")){
            holder.imagen.setImageResource(R.drawable.pizza);
        }else if ((listData.get(position).getResumen()).equals("cubano")){
            holder.imagen.setImageResource(R.drawable.cubano);
        }else if ((listData.get(position).getResumen()).equals("cervesa")){
            holder.imagen.setImageResource(R.drawable.cerveza);
        }

        holder.nombre.setText(listData.get(position).getResumen());

        holder.precio.setText("Cantidad: "+listData.get(position).getPrecio());


    }

    @Override
    public int getItemCount() {
        return listData.size();
    }







}

