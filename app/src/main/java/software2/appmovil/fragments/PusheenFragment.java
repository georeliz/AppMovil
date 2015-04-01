package software2.appmovil.fragments;


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
import software2.appmovil.adapters.PusheenAdapter;
import software2.appmovil.models.Pusheen;


public class PusheenFragment extends Fragment {

    ArrayList<Pusheen> pusheensData;



    public PusheenFragment(){

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View pusheenView = inflater.inflate(R.layout.pusheen_fragment, container, false);

        ArrayList<Pusheen> pusheens = new ArrayList<>();

        Pusheen pusheen = new Pusheen();
        pusheen.setId(1);
        pusheen.setName("15 Festival Internacional de Jazz");
        pusheen.setPasTime("22 de Marzo 2015" );
        pusheens.add(pusheen);

        Pusheen pusheen2 = new Pusheen();
        pusheen2.setId(2);
        pusheen2.setName("Mes de la Francofonia");
        pusheen2.setPasTime("Fecha");
        pusheens.add(pusheen2);

        Pusheen pusheen3 = new Pusheen();
        pusheen3.setId(3);
        pusheen3.setName("Festival Poetico Grito de Mujer");
        pusheen3.setPasTime("Viernes, 13 de marzo a la(s) 18:30");
        pusheens.add(pusheen3);

        Pusheen pusheen4 = new Pusheen();
        pusheen4.setId(4);
        pusheen4.setName("Evento 4");
        pusheen4.setPasTime("Fecha");
        pusheens.add(pusheen4);

        Pusheen pusheen5 = new Pusheen();
        pusheen5.setId(5);
        pusheen5.setName("Evento 5");
        pusheen5.setPasTime("Fecha");
        pusheens.add(pusheen5);

        Pusheen pusheen6 = new Pusheen();
        pusheen5.setId(6);
        pusheen5.setName("Evento 6");
        pusheen5.setPasTime("Fecha");
        pusheens.add(pusheen6);

        Pusheen pusheen7 = new Pusheen();
        pusheen5.setId(7);
        pusheen5.setName("Evento 7");
        pusheen5.setPasTime("Fecha");
        pusheens.add(pusheen7);

        Pusheen pusheen8 = new Pusheen();
        pusheen5.setId(8);
        pusheen5.setName("Evento 8");
        pusheen5.setPasTime("Fecha");
        pusheens.add(pusheen8);
        //Fin de nuestro dataset

        //Configuración del recyclerView, con nuestro dataSet y nuestro Adapter

        //Aqui buscamos el Widget recyclerView
        RecyclerView recyclerView = (RecyclerView) pusheenView.findViewById(R.id.my_recycler_view);

        //A pesar del tamaño de la pantalla, asegurar que los elementos se vean siempre igual.
        recyclerView.setHasFixedSize(true);

        //Configuramos la animación por defecto
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //Ahora le pasamos nuestro dataset y la forma en que se vera cada fila.
        recyclerView.setAdapter(new PusheenAdapter(pusheens, R.layout.row));

        //Importante, ahora podemos indicar si mostrar los elementos como fila o como grilla, en este
        //caso setLayoutManager() esta  configurado como grilla de una columna, es por es eso que se ve
        //como fila, recordar que el mismo resultado se obtiene con
        // recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);
        recyclerView.setLayoutManager(layoutManager);

        return pusheenView;


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);




    }

}
