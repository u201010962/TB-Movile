package pe.edu.upc.collectionssample;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import pe.edu.upc.collectionssample.dbmodelo.BDhelper;
import pe.edu.upc.collectionssample.dbmodelo.Cliente;


/**
 * Created by Casa on 22/09/2017.
 */

public class PerfilFragment extends Fragment {

    Cliente cuenta;

    private TextView usuario,nombre_user,clave,correo,identificacion;
    int id;
    String Id;

    public  PerfilFragment(){

   }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View v= inflater.inflate(R.layout.perfil_fragment,null);
//        Id = getArguments().getString("idCliente");
        MainActivity password;
        // variables para mostrar perfil de usuario

        identificacion = (TextView)v.findViewById(R.id.texto_ident);
        usuario = (TextView)v.findViewById(R.id.texto_nombre);
        correo = (TextView)v.findViewById(R.id.texto_email);
        nombre_user = (TextView)v.findViewById(R.id.texto_username);
        clave =(TextView)v.findViewById(R.id.texto_password);

        BDhelper admin = new BDhelper(getContext());
        SQLiteDatabase bd = admin.getWritableDatabase();

        password = new MainActivity();
        // intentar con getView()
           Id = password.clave();

        Cursor fila = bd.rawQuery(  //devuelve 0 o 1 fila //es una consulta
                "select id,nombre,apellidos,email,usuario,clave  from clientes where clave='"+Id+"'", null);
        if (fila.moveToFirst()) {  //si ha devuelto 1 fila, vamos al primero (que es el unico)
            identificacion.setText(fila.getString(0));
            usuario.setText(fila.getString(1)+""+fila.getString(2));
            correo.setText(fila.getString(3));
            nombre_user.setText(fila.getString(4));
            clave.setText(fila.getString(5));

        } else{

            MainActivity activity = (MainActivity) getActivity();
            Toast.makeText(activity,""+Id, Toast.LENGTH_SHORT).show();}

        bd.close();





    return v;}


}
