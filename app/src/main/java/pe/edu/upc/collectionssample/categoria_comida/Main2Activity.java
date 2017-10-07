package pe.edu.upc.collectionssample.categoria_comida;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import pe.edu.upc.collectionssample.R;
import pe.edu.upc.collectionssample.adapter.Adapter;
import pe.edu.upc.collectionssample.dbmodelo.Platos;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    Platos plato;
    private RecyclerView recycler;
    // 23/09/2017 3:17 cambie Recyclerview por Adapter private Recycler.....
    private Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    ListView lv1 = null;
    ArrayList<Platos> lstPlatos = new ArrayList<Platos>();


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // 23/12/206 3:17 lo comente  setContentView(R.layout.recycler);

        plato = new Platos(this);

        lstPlatos = plato.getListadoPlatos();

        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);


        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        adapter = new Adapter(lstPlatos, this);
        recycler.setAdapter(adapter);


   }
}
