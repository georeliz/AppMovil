package software2.appmovil.fragments;

/**
 * Created by Gerson de Leon on 15/03/2015.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import software2.appmovil.R;
import software2.appmovil.adapters.DestacadoAdapter;
import software2.appmovil.models.DestacadosModel;

public class DestacadosFragment extends Fragment
{

    public DestacadosFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle saveInstanceState){
        View destacadosView = inflater.inflate(R.layout.destacados_fragment,container,false);

        ArrayList<DestacadosModel> destacados = new ArrayList<>();

        DestacadosModel destacado = new DestacadosModel();
        destacado.setEstrellas(5);
        destacado.setNombreEvento("10k Nocturno");
        destacados.add(destacado);

        RecyclerView recyclerView = (RecyclerView) destacadosView.findViewById(R.id.my_recycler_view_destacados);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new DestacadoAdapter(destacados, R.layout.row_destacados));



        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);
        recyclerView.setLayoutManager(layoutManager);

        return destacadosView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }
}