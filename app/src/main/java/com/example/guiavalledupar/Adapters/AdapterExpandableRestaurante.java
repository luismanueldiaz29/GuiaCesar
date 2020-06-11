package com.example.guiavalledupar.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.guiavalledupar.Entity.Restaurante;
import com.example.guiavalledupar.MapsActivity;
import com.example.guiavalledupar.R;

import java.util.ArrayList;

import static androidx.core.content.ContextCompat.startActivity;
import static java.security.AccessController.getContext;

public class AdapterExpandableRestaurante extends RecyclerView.Adapter<AdapterExpandableRestaurante.ExpaPlatoViewHolder>{

    ArrayList<Restaurante> restaurantes;
    ImageView Ubicacion;

    public AdapterExpandableRestaurante(ArrayList<Restaurante> restaurantes){
        this.restaurantes = restaurantes;
    }

    @NonNull
    @Override
    public ExpaPlatoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_restaurante, parent, false);
        return new ExpaPlatoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpaPlatoViewHolder holder, int position) {

        Restaurante restaurante = restaurantes.get(position);
        holder.titleTextView.setText(restaurante.Name);
        holder.yearTextView.setText(restaurante.Direccion);
        holder.ratingTextView.setText(restaurante.Horario);

        boolean isExpanded = restaurantes.get(position).Expandable;
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return restaurantes.size();
    }

    public class ExpaPlatoViewHolder extends RecyclerView.ViewHolder {

        ConstraintLayout expandableLayout;
        TextView titleTextView, yearTextView, ratingTextView;

        public ExpaPlatoViewHolder(@NonNull final View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.titleTextView);
            yearTextView = itemView.findViewById(R.id.yearTextView);
            ratingTextView = itemView.findViewById(R.id.ratingTextView);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);

            Ubicacion = itemView.findViewById(R.id.Ubicacion);

            titleTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Restaurante restaurante = restaurantes.get(getAdapterPosition());
                    restaurante.Expandable = !restaurante.Expandable;
                    notifyItemChanged(getAdapterPosition());
                }
            });

            Ubicacion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), MapsActivity.class);
                    intent.putExtra("Latitud", restaurantes.get(getAdapterPosition()).Latitud.toString());
                    intent.putExtra("Longitud", restaurantes.get(getAdapterPosition()).Longitud.toString());
                    intent.putExtra("Titulo", restaurantes.get(getAdapterPosition()).Name);
                    //Toast.makeText(itemView.getContext(), "name "+restaurantes.get(getAdapterPosition()).Name+" latitud "+restaurantes.get(getAdapterPosition()).Latitud+" longitud "+restaurantes.get(getAdapterPosition()).Longitud, Toast.LENGTH_LONG).show();
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
    /*        private ImageView Ubicacion;
        Ubicacion = (ImageView) findViewById(R.id.Ubicacion);
        Ubicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "my location", Toast.LENGTH_LONG).show();
            }
        });*/
}
