package com.example.guiavalledupar.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.guiavalledupar.Entity.Municipio;
import com.example.guiavalledupar.R;

import java.util.ArrayList;

public class AdapterEventos extends RecyclerView.Adapter<AdapterEventos.ViewHolder> implements View.OnClickListener{

    private View.OnClickListener listener;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name, description;
        ImageView fotoPlato;
        public ViewHolder(View itemView){
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tvEventoName);
            description = (TextView) itemView.findViewById(R.id.tvEventoDescription);
            fotoPlato = (ImageView)itemView.findViewById(R.id.ivEventoImage);
        }
    }

    public ArrayList<Municipio> municipios;

    public AdapterEventos(ArrayList<Municipio> municipios){
        this.municipios = municipios;
    }

    @Override
    public AdapterEventos.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_evento, parent, false);
        view.setOnClickListener(this);

        AdapterEventos.ViewHolder viewHolder = new AdapterEventos.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterEventos.ViewHolder holder, int position) {
        holder.name.setText(municipios.get(position).Name);
        holder.description.setText(municipios.get(position).Description);
        holder.fotoPlato.setImageResource(municipios.get(position).img);
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
        return municipios.size();
    }
}
