package pe.edu.upc.collectionssample;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.service.voice.VoiceInteractionSession;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    private TextView nameTextView;
    private TextView descriptionTextView;
    private ImageView pictureView;

    private int mUltimoID;
    private JCustomer mi_lugar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        /*nameTextView = (TextView)findViewById(R.id.nameTextView);
        descriptionTextView = (TextView)findViewById(R.id.descriptionTextView);
        pictureView = (ImageView)findViewById(R.id.pictureView);*/

        /*Button btnCargar = (Button)findViewById(R.id.cargarImagen);

        btnCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarLugar();
            }
        });

        mUltimoID = 0;
        cargarLugar();

        //Registramos el eventp clic para el boton "ver mapa"
        Button btnVerMapa = (Button)findViewById(R.id.verMapa);
        btnVerMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                intent.putExtra("nombre", mi_lugar.getmNombre());
                intent.putExtra("latitud", mi_lugar.getmLatitud());
                intent.putExtra("longitud", mi_lugar.getmLongitud());
                startActivity(intent);
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void cargarLugar(){
        try {
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), 0);
            JBDCustomer bd = new JBDCustomer(MainActivity.this, "customers", null, info.versionCode);

            mi_lugar = bd.cargarLugar(mUltimoID);

            nameTextView.setText(mi_lugar.getmNombre());
            descriptionTextView.setText(mi_lugar.getmPais());

            String imagen = String.format("img_%s", 2);
            int resId = getResources().getIdentifier(imagen,"drawable", getPackageName());

            pictureView.setImageResource(resId);

            mUltimoID = mi_lugar.getMid();
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "cargarLugar: "+ e.getMessage());
        }

    }
}
