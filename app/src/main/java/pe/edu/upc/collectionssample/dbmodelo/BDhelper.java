package pe.edu.upc.collectionssample.dbmodelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Casa on 22/09/2017.
 */

public class BDhelper extends SQLiteOpenHelper {

    //Versión de la base de datos
    private static final int DATABASE_VERSION = 1;
    //Nombre de la base de datos
    private static final String DATABASE_NAME = "bd_restaurante2";


    public BDhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table clientes(id text primary key ,nombre text,apellidos text, email text,usuario text,clave text)");
        sqLiteDatabase.execSQL("create table platos(id integer primary key autoincrement,resumen text,cantidad integer, foto text )");
        sqLiteDatabase.execSQL("create table pedidos(id integer primary key autoincrement,cliente_id text,fecha text,total text,FOREIGN KEY(cliente_id) REFERENCES clientes(id))");
        sqLiteDatabase.execSQL("create table platos_pedidos(pedido_id integer,plato_id integer,FOREIGN KEY(pedido_id) REFERENCES pedidos(id),FOREIGN KEY(plato_id) REFERENCES platos(id))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exit clientes");
        sqLiteDatabase.execSQL("drop table if exit platos");
        sqLiteDatabase.execSQL("drop table if exit pedidos");
        sqLiteDatabase.execSQL("drop table if exit platos_pedidos");


        onCreate(sqLiteDatabase);


    }

    protected long insertarRegistro(ContentValues valores, String tabla) {
        SQLiteDatabase db = this.getWritableDatabase();
        long res = db.insert(tabla, null, valores);
        db.close();
        return res;

    }


}


