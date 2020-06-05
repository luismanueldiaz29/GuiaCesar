package com.example.guiavalledupar.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.guiavalledupar.Entity.ServicioApi;
import com.example.guiavalledupar.R;

import java.util.ArrayList;

public class AdapterServiceAPI extends RecyclerView.Adapter<AdapterServiceAPI.ViewHolder>implements View.OnClickListener {
    private View.OnClickListener listener;
    ArrayList<ServicioApi> servicio =new ArrayList<>();

    public AdapterServiceAPI(ArrayList<ServicioApi> hospi) {
        this.servicio =hospi ;
    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public AdapterServiceAPI.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hospital, parent, false);
        view.setOnClickListener(this);

        AdapterServiceAPI.ViewHolder viewHolder = new AdapterServiceAPI.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterServiceAPI.ViewHolder holder, int position) {
        holder.name.setText(servicio.get(position).name);
        holder.direction.setText(servicio.get(position).direction);
        holder.phone.setText(servicio.get(position).phone);
        if(servicio.get(position).tipo==2){
            holder.photo.setImageResource(R.drawable.hospital);
        }else{
            holder.photo.setImageResource(R.drawable.recreacion);
        }
    }

    @Override
    public int getItemCount() {
        return servicio.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView direction;
        private TextView phone;
        private ImageView photo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.hospitalApiName);
            direction=itemView.findViewById(R.id.hospitalApiDir);
            phone=itemView.findViewById(R.id.hospitalApiPhone);
            photo = (ImageView)itemView.findViewById(R.id.ivServiceImage);
        }
    }
}