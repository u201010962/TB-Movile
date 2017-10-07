package pe.edu.upc.collectionssample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import pe.edu.upc.collectionssample.dbmodelo.Cliente;

public class LoginActivity extends AppCompatActivity {
    public EditText username=null,password=null;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText)findViewById(R.id.usuario);
        password = (EditText)findViewById(R.id.clave);

    }


    public  void ingresar(View v){
        Cliente cliente = new Cliente(getBaseContext());

        Cliente cli=new Cliente();
        cli = cliente.getCliente(username.getText().toString(),password.getText().toString());


        if(cli != null){
            Intent intent = new Intent(this,MainActivity.class);
            intent.putExtra("idCliente", cli.getId());
            startActivity(intent);
        }else {
            Toast.makeText(getBaseContext(),"usuario o clave incorrecta", Toast.LENGTH_LONG).show();
        }

    }

    public void registrarCliente(View v){
        Intent intent = new Intent(this,ClienteActivity.class);
        startActivity(intent);

    }


    public void cancelar(View v){
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }





}
