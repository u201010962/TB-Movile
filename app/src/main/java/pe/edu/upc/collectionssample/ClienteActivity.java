package pe.edu.upc.collectionssample;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import pe.edu.upc.collectionssample.R;

import pe.edu.upc.collectionssample.dbmodelo.BDhelper;

public class ClienteActivity extends AppCompatActivity {

    private EditText ident,nombre,apell,user,password,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // variables para ingresar cliente
        setContentView(R.layout.activity_cliente);

        ident = (EditText)findViewById(R.id.ident);
        nombre = (EditText)findViewById(R.id.nombre);
        apell=(EditText)findViewById(R.id.apellidos);
        user = (EditText)findViewById(R.id.usuario);
        password = (EditText)findViewById(R.id.clave);
        email = (EditText)findViewById(R.id.email);









    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    public void registar(View v) {
        BDhelper admin = new BDhelper(getBaseContext());
        SQLiteDatabase bd = admin.getWritableDatabase();
        String id = ident.getText().toString();
        String name = nombre.getText().toString();
        String apellidos = apell.getText().toString();
        String usuario = user.getText().toString();
        String clave = password.getText().toString();
        String address = email.getText().toString();



        ContentValues registro = new ContentValues();  //es una clase para guardar datos
        registro.put("id", id);
        registro.put("nombre", name);
        registro.put("apellidos",apellidos);
        registro.put("email",address);
        registro.put("usuario",usuario);
        registro.put("clave",clave);


        bd.insert("clientes", null, registro);
        bd.close();

        nombre.setText("");
        ident.setText("");
        apell.setText("");
        user.setText("");
        email.setText("");
        password.setText("");
        Toast.makeText(this, "Se cargaron los datos de la persona", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
    public void consulta(View v) {

        BDhelper admin = new BDhelper(getBaseContext());
        SQLiteDatabase bd = admin.getWritableDatabase(); //Create and/or open a database that will be used for reading and writing.
        String id = ident.getText().toString();
        Cursor fila = bd.rawQuery(  //devuelve 0 o 1 fila //es una consulta
                "select id,nombre,apellidos,email,usuario,clave  from clientes where id=" +id, null);



    }

}
