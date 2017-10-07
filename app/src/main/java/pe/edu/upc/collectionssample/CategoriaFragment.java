package pe.edu.upc.collectionssample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pe.edu.upc.collectionssample.R;

import pe.edu.upc.collectionssample.categoria_comida.BebidasFragment;
import pe.edu.upc.collectionssample.categoria_comida.Ingresar_platosFragment;
import pe.edu.upc.collectionssample.categoria_comida.ListaPlatosFragment;


/**
 * Created by Casa on 22/09/2017.
 */

public class CategoriaFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 3 ;

    public static CategoriaFragment newInstance(int sectionNumber) {
        CategoriaFragment fragment = new CategoriaFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /**
         *Inflate tab_layout and setup Views.
         */
        View x =  inflater.inflate(R.layout.tab_layout,null);

        viewPager = (ViewPager) x.findViewById(R.id.viewpager);

        /**
         *Set an Apater for the View Pager
         */
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        tabLayout = (TabLayout) x.findViewById(R.id.tabs);




        /**
         * Now , this is a workaround ,
         * The setupWithViewPager dose't works without the runnable .
         * Maybe a Support Library Bug .
         */

        /*tabLayout.post(new Runnable() {
            @Override
            public void run() {*/
                tabLayout.setupWithViewPager(viewPager);
           /* }
        });*/

        return x;

    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return fragment with respect to Position .
         */

        @Override
        public Fragment getItem(int position)
        {
            switch (position){
                case 0 : return new ListaPlatosFragment();
                case 1 : return new BebidasFragment();
                case 2 : return new Ingresar_platosFragment();
            }
            return null;

        }

        @Override
        public int getCount() {

            return int_items;

        }

        /**
         * This method returns the title of the tab according to the position.
         */

        @Override
        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0 :
                    return "Detalle Pedido";
                case 1 :
                    return "Bebidas";
                case 2 :
                    return "Ingresar Pedido";
            }
            return null;
        }
    }
}
