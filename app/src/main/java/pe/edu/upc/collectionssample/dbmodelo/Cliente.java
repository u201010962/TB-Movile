package pe.edu.upc.collectionssample.dbmodelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Casa on 22/09/2017.
 */

public class Cliente extends BDhelper {

    private String id;
    private String nombres;
    private String apellidos;
    private String email;
    private String usuario;
    private String clave;

    public Cliente(){
        super(null);
    }

    public Cliente(Context baseContext) {
        super(baseContext);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public long insertar(Cliente cliente){

        ContentValues registro = new ContentValues();  //es una clase para guardar datos
        //registro.put("id", id);
        registro.put("nombre", nombres);
        registro.put("apellidos",apellidos);
        registro.put("email",email);
        registro.put("usuario",usuario);
        registro.put("clave",clave);

        return this.insertarRegistro(registro, "clientes");
    }

    public Cliente getCliente(int id){
        Cliente cliente = null;

        String selectQuery = "select * from clientes where id="+id;

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor= null;

        cursor = sqLiteDatabase.rawQuery(selectQuery,null);

        if(cursor.moveToFirst()){

            cliente = new Cliente();

            cliente.setId(cursor.getString(0));
            cliente.setNombres(cursor.getString(1));
            cliente.setApellidos(cursor.getString(2));
            cliente.setEmail(cursor.getString(3));
            cliente.setUsuario(cursor.getString(4));
            cliente.setClave(cursor.getString(5));

        }

        sqLiteDatabase.close();

        return  cliente;

    }

    public Cliente getCliente(String usuario, String clave){
        Cliente cliente = null;

        String selectQuery = "select * from clientes where usuario='"+usuario+"' and clave='"+clave+"'";

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor= null;

        cursor = sqLiteDatabase.rawQuery(selectQuery,null);

        if (cursor.moveToFirst()){

            cliente = new Cliente();

            cliente.setId(cursor.getString(0));
            cliente.setNombres(cursor.getString(1));
            cliente.setApellidos(cursor.getString(2));
            cliente.setEmail(cursor.getString(3));
            cliente.setUsuario(cursor.getString(4));
            cliente.setClave(cursor.getString(5));
        }

        sqLiteDatabase.close();

        return  cliente;
    }


}

