package com.example.guiavalledupar.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.guiavalledupar.Entity.MunicipioApi;
import com.example.guiavalledupar.R;

import java.util.ArrayList;

public class AdapterMunicipioApi extends RecyclerView.Adapter<AdapterMunicipioApi.ViewHolder>implements View.OnClickListener {
    private View.OnClickListener listener;
    public ArrayList<MunicipioApi> municipioApis;

    public AdapterMunicipioApi(ArrayList<MunicipioApi> muni) {
        this.municipioApis =muni ;
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



    @Override
    public AdapterMunicipioApi.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_municipioapi, parent, false);
        view.setOnClickListener(this);

        AdapterMunicipioApi.ViewHolder viewHolder = new AdapterMunicipioApi.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMunicipioApi.ViewHolder holder, int position) {
        holder.name.setText(municipioApis.get(position).nombre);
        holder.direction.setText("Alcaldia: "+ municipioApis.get(position).direccion);
    }

    @Override
    public int getItemCount() {
        return municipioApis.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView direction;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.municipioApiText);
            direction=itemView.findViewById(R.id.municipioApiText2);
        }
    }
}
