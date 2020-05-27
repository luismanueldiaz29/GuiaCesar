package com.example.guiavalledupar.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.guiavalledupar.Entity.Plato;
import com.example.guiavalledupar.R;

import java.util.ArrayList;

public class AdapterPlatos extends RecyclerView.Adapter<AdapterPlatos.ViewHolder> implements View.OnClickListener{

    private View.OnClickListener listener;


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

    public AdapterPlatos(ArrayList<Plato> platos){
        this.platos = platos;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_plato, parent, false);
        view.setOnClickListener(this);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(platos.get(position).Name);
        holder.description.setText(platos.get(position).Description);
        holder.fotoPlato.setImageResource(platos.get(position).Image);
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }
    @Override
    public void onClick(View v) {
        if(listener != null){
            listener.onClick(v);
        }
    }


    @Override
    public int getItemCount() {
        return platos.size();
    }
}
