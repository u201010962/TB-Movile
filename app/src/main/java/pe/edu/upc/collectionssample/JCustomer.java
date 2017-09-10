package pe.edu.upc.collectionssample;

/**
 * Created by PROTECSO-DEV on 09/09/2017.
 */

public class JCustomer {

    private int mid;
    private String mNombre;
    private String mPais;
    private String mEnlace;
    private float mLatitud;
    private float mLongitud;

    public JCustomer(int mid, String mNombre, String mPais, String mEnlace, float mLatitud, float mLongitud) {
        this.mid = mid;
        this.mNombre = mNombre;
        this.mPais = mPais;
        this.mEnlace = mEnlace;
        this.mLatitud = mLatitud;
        this.mLongitud = mLongitud;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getmNombre() {
        return mNombre;
    }

    public void setmNombre(String mNombre) {
        this.mNombre = mNombre;
    }

    public String getmPais() {
        return mPais;
    }

    public void setmPais(String mPais) {
        this.mPais = mPais;
    }

    public String getmEnlace() {
        return mEnlace;
    }

    public void setmEnlace(String mEnlace) {
        this.mEnlace = mEnlace;
    }

    public float getmLatitud() {
        return mLatitud;
    }

    public void setmLatitud(float mLatitud) {
        this.mLatitud = mLatitud;
    }

    public float getmLongitud() {
        return mLongitud;
    }

    public void setmLongitud(float mLongitud) {
        this.mLongitud = mLongitud;
    }
}
