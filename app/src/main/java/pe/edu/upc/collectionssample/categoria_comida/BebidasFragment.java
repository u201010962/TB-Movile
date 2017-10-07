package pe.edu.upc.collectionssample.categoria_comida;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pe.edu.upc.collectionssample.R;

/**
 * Created by Casa on 22/09/2017.
 */

public class BebidasFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bedidasfragment,null);
    }
}
