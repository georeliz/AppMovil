package software2.appmovil.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;


import software2.appmovil.R;
import software2.appmovil.models.DestacadosModel;

/**
 * Created by Gerson de Leon on 23/03/2015.
 */
public class DestacadoAdapter extends RecyclerView.Adapter<DestacadoAdapter.ViewHolder>{

    ArrayList<DestacadosModel> destacados;
    int itemLayout;

    public  DestacadoAdapter( ArrayList<DestacadosModel> destacados, int itemLayout){
        this.itemLayout = itemLayout;
        this.destacados = destacados;
    }

    @Override
    public DestacadoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DestacadoAdapter.ViewHolder holder, int position) {

        DestacadosModel destacado = destacados.get(position);

        holder.nameEvent.setText(destacado.getNombreEvento());
        holder.estrellas.setNumStars(destacado.getEstrellas());
    }

    @Override
    public int getItemCount() {
        return destacados.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nameEvent;
        RatingBar estrellas;


        public ViewHolder(View itemView){
            super(itemView);

            nameEvent = (TextView) itemView.findViewById(R.id.nombre_evento);
            estrellas = (RatingBar) itemView.findViewById(R.id.estrellas);

        }

    }
}
