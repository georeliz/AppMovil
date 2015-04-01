package software2.appmovil.fragments;

/**
 * Created by Gerson de Leon on 15/03/2015.
 */
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import software2.appmovil.R;

public class PrincipalFragment extends Fragment
{

    public PrincipalFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle saveInstanceState){
        return inflater.inflate(R.layout.principal_fragment,container,false);
    }
}
