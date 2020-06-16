package com.example.guiavalledupar.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.guiavalledupar.Entity.Actividad;
import com.example.guiavalledupar.R;

import java.util.ArrayList;

public class AdapterActividades extends RecyclerView.Adapter<AdapterActividades.ViewHolder>implements View.OnClickListener {
    private View.OnClickListener listener;
    ArrayList<Actividad> actividades =new ArrayList<>();

    public AdapterActividades(ArrayList<Actividad> hospi) { this.actividades =hospi ; }
    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }

    public void setOnClickListener(View.OnClickListener listener) { this.listener = listener; }



    @Override
    public AdapterActividades.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_actividad, parent, false);
        view.setOnClickListener(this);

        AdapterActividades.ViewHolder viewHolder = new AdapterActividades.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterActividades.ViewHolder holder, int position) {
        holder.name.setText(actividades.get(position).Name);
        holder.photo.setImageResource(actividades.get(position).Image);
    }

    @Override
    public int getItemCount() { return actividades.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private ImageView photo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.ActividadNameTV);
            photo = (ImageView)itemView.findViewById(R.id.ivActividad);

        }
    }
}
