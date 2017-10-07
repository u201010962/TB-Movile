package pe.edu.upc.collectionssample.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import pe.edu.upc.collectionssample.R;
import pe.edu.upc.collectionssample.dbmodelo.Platos;

import java.util.ArrayList;

/**
 * Created by Casa on 22/09/2017.
 */

public class PlatoListAdapter extends BaseAdapter {

    private ArrayList<Platos> listData = new ArrayList<Platos>();
    private LayoutInflater layoutInflater;


    public PlatoListAdapter(Context aContext, ArrayList<Platos> listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }


    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.listaplatosfragment, null);
            holder = new ViewHolder();

            holder.txtResumen = (TextView) convertView.findViewById(R.id.descripcion);

            holder.txtPrecio = (TextView)convertView.findViewById(R.id.precio);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }



        holder.txtResumen.setText(listData.get(position).getResumen());
        holder.txtPrecio.setText("Cantidad: "+listData.get(position).getPrecio());

        return convertView;
    }

    class ViewHolder {
        TextView txtId;

        TextView txtPrecio;
        TextView txtResumen;

    }

}





