package com.example.guiavalledupar.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.guiavalledupar.Entity.ServicioApi;
import com.example.guiavalledupar.R;

import java.util.ArrayList;

public class AdapterHospitalAPI extends RecyclerView.Adapter<AdapterHospitalAPI.ViewHolder>implements View.OnClickListener {
    private View.OnClickListener listener;
    ArrayList<ServicioApi> servicio =new ArrayList<>();

    public AdapterHospitalAPI(ArrayList<ServicioApi> hospi) {
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
    public AdapterHospitalAPI.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hospital, parent, false);
        view.setOnClickListener(this);

        AdapterHospitalAPI.ViewHolder viewHolder = new AdapterHospitalAPI.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHospitalAPI.ViewHolder holder, int position) {
        holder.name.setText(servicio.get(position).name);
        holder.direction.setText(servicio.get(position).direction);
        holder.phone.setText(servicio.get(position).phone);
    }

    @Override
    public int getItemCount() {
        return servicio.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView direction;
        private TextView phone;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.hospitalApiName);
            direction=itemView.findViewById(R.id.hospitalApiDir);
            phone=itemView.findViewById(R.id.hospitalApiPhone);

        }
    }
}
