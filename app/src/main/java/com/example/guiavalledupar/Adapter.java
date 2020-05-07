package com.example.guiavalledupar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.guiavalledupar.Entity.Plato;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name, description;
        ImageView fotoPlato;
        public ViewHolder(View itemView){
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tvPlatoName);
            description = (TextView) itemView.findViewById(R.id.tvPlatoDescription);
            fotoPlato = (ImageView)itemView.findViewById(R.id.ivPlatoImage);
        }
    }

    public ArrayList<Plato> platos;

    public Adapter(ArrayList<Plato> platos){
        this.platos = platos;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_plato, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(platos.get(position).Name);
        holder.description.setText(platos.get(position).Description);
        holder.fotoPlato.setImageResource(platos.get(position).Image);
    }

    @Override
    public int getItemCount() {
        return platos.size();
    }
}
