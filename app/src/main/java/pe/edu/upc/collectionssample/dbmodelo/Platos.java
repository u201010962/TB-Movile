package pe.edu.upc.collectionssample.dbmodelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import pe.edu.upc.collectionssample.categoria_comida.ListaPlatosFragment;

import java.util.ArrayList;

/**
 * Created by Casa on 22/09/2017.
 */

public class Platos extends BDhelper {

    private int id;
    private String nombre;
    private Integer precio;
    private String foto;

    public  Platos(){
        super(null);
    }

    public Platos(Context context) {

        super(context);
    }


    public Platos(int id, String nombre, int precio, String foto) {
        super(null);
        this.id = id;
        this.nombre = nombre;

        this.precio = precio;
        this.foto = foto;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResumen() {
        return nombre;
    }

    public void setResumen(String resumen) {
        this.nombre = resumen;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public long insertar(Platos platos){

        ContentValues registro = new ContentValues();  //es una clase para guardar datos

        registro.put("resumen", nombre);
        registro.put("precio",precio);
        registro.put("foto",foto);


        return this.insertarRegistro(registro, "platos");
    }

    public Platos getPlatos(int id){
        Platos platos = null;

        String selectQuery = "select * from platos where id="+id;

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor= null;

        cursor = sqLiteDatabase.rawQuery(selectQuery,null);

        if(cursor.moveToFirst()){

            platos = new Platos();

            platos.setId(cursor.getInt(0));
            platos.setResumen(cursor.getString(1));


        }

        sqLiteDatabase.close();

        return  platos;

    }

    public ArrayList<Platos> getListadoPlatos() {
		/* lstPlatos ArrayList para almacenar todos los platos obtenidos en la busqueda*/
        ArrayList<Platos> lstPlatos = new ArrayList<>();
		/* Instrucción SQL para obtener todos los platos*/
        String selectQuery = "select resumen , precio from platos";
		/*
		 * SQLiteDatabase db = this.getWritableDatabase(); Crea o abre una base
		 * de datos que se usara para lectura y escritura usando instrucciones
		 * SQL.
		 */
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
		/*
		 * c variable de tipo Cursor que posteriormente podremos recorrer para
		 * procesar los registros obtenidos de la consulta sql selectQuery
		 */
        Cursor c = null;
		/*
		 * El método rawQuery() de la clase SQLiteDatabase, recibe como
		 * argumento un comando SQL a ejecutar, retorna un Cursor
		 */
        c = sqLiteDatabase.rawQuery(selectQuery, null);

		/*
		 * moveToFirst(): mueve el puntero del cursor al primer registro
		 * obtenido.
		 */
        if (c.moveToFirst()) { /* moveToFirst() devuelve TRUE en caso de haber realizado el movimiento */
            do {
				/* Creaamos un objeto de la clase Plato */
                Platos plato = new Platos();
				/* al objeto de tipo Plato le asignamos el valor del campo id obtenido de la consulta */
               /*  plato.setId(c.getInt(0));
				al objeto de tipo Plato le asignamos el valor del campo resumen obtenido de la consulta */
                plato.setResumen(c.getString(0));
				/* al objeto de tipo Plato le asignamos el valor del campo precio obtenido de la consulta */
                plato.setPrecio(c.getInt(1));
				/* Agregamos cada plato al listado*/
                lstPlatos.add(plato);
            } while (c.moveToNext());
        }
        sqLiteDatabase.close();
        return lstPlatos;
    }

}
