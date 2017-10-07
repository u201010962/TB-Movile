package pe.edu.upc.collectionssample.categoria_comida;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import pe.edu.upc.collectionssample.R;
import pe.edu.upc.collectionssample.dbmodelo.BDhelper;

/**
 * Created by Casa on 22/09/2017.
 */

public class Ingresar_platosFragment extends Fragment {
    private Button boton;
    private EditText precio;
    private Spinner spinner1;

    public Ingresar_platosFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.ingresar_platosfragment, null);

        precio = (EditText)view.findViewById(R.id.price);

        spinner1 = (Spinner)view.findViewById(R.id.spinner);
        ArrayAdapter spinner_adapter = ArrayAdapter.createFromResource( getActivity(), R.array.platos_arrays , android.R.layout.simple_spinner_item);
        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(spinner_adapter);
        boton = (Button)view.findViewById(R.id.btnGuardarPlato);

        boton.setOnClickListener( new View.OnClickListener() {
            Activity activity = getActivity();
            public void onClick(View view){

                // registro de platos
                BDhelper admin = new BDhelper(getContext());
                SQLiteDatabase bd = admin.getWritableDatabase();

                String name =spinner1.getSelectedItem().toString();
                String price1 =precio.getText().toString();

                int valor = Integer.parseInt(price1);



                ContentValues registro = new ContentValues();  //es una clase para guardar datos

                registro.put("resumen", name);
                registro.put("precio",valor);



                bd.insert("platos", null, registro);
                bd.close();

                precio.setText("");

                Toast.makeText(activity, "Se cargaron los datos del plato", Toast.LENGTH_SHORT).show();


            }

        });
        return view;
    }



}
