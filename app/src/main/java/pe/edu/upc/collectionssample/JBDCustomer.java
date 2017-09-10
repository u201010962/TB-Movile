package pe.edu.upc.collectionssample;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by PROTECSO-DEV on 09/09/2017.
 */

public class JBDCustomer extends SQLiteOpenHelper {

    private final String TAG = "JCustomer";
    private Context mContext;
    private int DATABASE_VERSION;
    private String DATABASE_ASSETS_FILE;
    private String DATABASE_NAME;
    private String DATABASE_PATH;

    private boolean mCopiarBD;

    public JBDCustomer(Context context, String bdname, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, bdname, factory, version);
        mContext = context;
        DATABASE_NAME = bdname;
        DATABASE_ASSETS_FILE = String.format("%s.sqlite", bdname);
        DATABASE_VERSION = version;
        //Por si cambia la ruta del path de la app, segun el SDK de android
        DATABASE_PATH = mContext.getApplicationInfo().dataDir + "/databases/";
        Log.e(TAG, "JBDCustomer: "+ DATABASE_PATH);
        try {
            //Comprobamos si la BD ya esta copiada en la ruta interna o aun no
            String bd_path = String.format("%s%s", DATABASE_PATH, DATABASE_NAME);
            File bd_file = new File(bd_path);
            if (bd_file.exists())
                mCopiarBD=false;
            else
                mCopiarBD=true;
        }catch (Exception e){
            Log.e(TAG, "JBDCustomer: "+ e.getMessage());
        }
    }

    public JBDCustomer(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    @Override
    public void onOpen(SQLiteDatabase db){
        //Comprobamos si hay que copiar la BD desde el assets a la ruta interna
        try {
            if (mCopiarBD) copyDB();
        }catch (Exception e){
            Log.e(TAG, "onOpen-copiarBD: "+ e.getMessage());
        }
        super.onOpen(db);
    }

    private void copyDB() throws IOException{
        try {
            InputStream myInput = mContext.getAssets().open(DATABASE_ASSETS_FILE);

            String outFileName = DATABASE_NAME;

            OutputStream myOutput = new FileOutputStream(outFileName);

            byte[] buffer = new byte[1024];

            int length;
            while((length = myInput.read(buffer)) > 0) myOutput.write(buffer,0,length);

            myOutput.flush();
            myOutput.close();
            myInput.close();

        }catch (Exception e){
            Log.e(TAG, "copyBD: "+ e.getMessage());
        }
    }

    public JCustomer cargarLugar(int ultimo_id){
        JCustomer lugar = null;
        try {
            String selectQuery = String.format("select * from lugares where _id <>'%s' order by random() limit 1", ultimo_id);
            SQLiteDatabase db = this.getReadableDatabase();
            //Cursor cursor = db.rawQuery("select * from lugares limit 1", null);

            /*if (cursor.moveToFirst()){
                lugar = new JCustomer(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getFloat(4), cursor.getFloat(5));
            }*/

            lugar = new JCustomer(0, "La Bisteca", "Perú", "https://www.labisteccalima.com/", Float.parseFloat("-12.11059"), Float.parseFloat("-76.98775"));

            db.close();
        }catch (Exception e){
            Log.e(TAG, "cargarLugar: "+ e.getMessage());
        }
        return lugar;
    }
}
