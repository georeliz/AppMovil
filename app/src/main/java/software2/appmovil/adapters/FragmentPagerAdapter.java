package software2.appmovil.adapters;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;

import software2.appmovil.fragments.DestacadosFragment;
import software2.appmovil.fragments.HelloFragment;
import software2.appmovil.fragments.PusheenFragment;
import software2.appmovil.fragments.fragment1;
import software2.appmovil.models.Pusheen;


public class FragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {

    private final String [] TITLES = {"Pagina Principal", "Recientes", "Destacados"};
    private final int FRAGMENT_COUNT = 3;


    public FragmentPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public int getCount() {
        return FRAGMENT_COUNT;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return new fragment1();
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return new PusheenFragment();
            case 2: // Fragment # 1 - This will show SecondFragment
                return new DestacadosFragment();
            default:
                return null;
        }



    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }


}