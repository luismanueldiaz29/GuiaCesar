package com.example.guiavalledupar.Adapters;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.guiavalledupar.Entity.ServiceApi;
import com.example.guiavalledupar.R;

import java.util.ArrayList;

public class AdapterServiceApiExpandable extends RecyclerView.Adapter<AdapterServiceApiExpandable.ExpaServiceViewHolder> {
    ArrayList<ServiceApi> services;
    ImageView Ubicacion, llamar, SiteWeb;


    public AdapterServiceApiExpandable(ArrayList<ServiceApi> services){
        this.services = services;
    }

    @NonNull
    @Override
    public ExpaServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_service_expandable, parent, false);
        return new ExpaServiceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpaServiceViewHolder holder, int position) {
        ServiceApi service = services.get(position);
        holder.name.setText(service.name);
        holder.direction.setText(service.direction);
        holder.phone.setText(service.phone);
        if(service.tipo== ServiceApi.HOSPITAL){
            holder.photo.setImageResource(R.drawable.hospital);
        }else if(service.tipo== ServiceApi.HOTEL){
            holder.photo.setImageResource(R.drawable.recreacion);
        }else if(service.tipo== ServiceApi.DROGUERIA){
            holder.photo.setImageResource(R.drawable.drog);
        }
        boolean isExpanded = services.get(position).Expandable;
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return services.size();
    }

    public class ExpaServiceViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout expandableLayout;
        private TextView name;
        private TextView direction;
        private TextView phone;
        private ImageView photo;
        private LinearLayout linearServicios;

        public ExpaServiceViewHolder(@NonNull final View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.hospitalApiName2);
            direction=itemView.findViewById(R.id.hospitalApiDir2);
            phone=itemView.findViewById(R.id.hospitalApiPhone2);
            photo = (ImageView)itemView.findViewById(R.id.ivServiceImage2);
            linearServicios=itemView.findViewById(R.id.linearServicios);

            expandableLayout = itemView.findViewById(R.id.expandableServiceLayout);
            Ubicacion = itemView.findViewById(R.id.ubicacion_service);
            llamar = itemView.findViewById(R.id.llamar_service);

            linearServicios.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ServiceApi service = services.get(getAdapterPosition());
                    service.Expandable = !service.Expandable;
                    notifyItemChanged(getAdapterPosition());
                }
            });



            llamar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(itemView.getContext());
                    alertDialog.setMessage(services.get(getAdapterPosition()).phone)
                            .setTitle("¿Quiere realizar la llamada?")
                            .setCancelable(true)
                            .setPositiveButton("Llamar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intentCall = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+services.get(getAdapterPosition()).phone));

                                    int result = itemView.getContext().checkCallingOrSelfPermission(Manifest.permission.CALL_PHONE);
                                    if ( result == PackageManager.PERMISSION_GRANTED){
                                        itemView.getContext().startActivity(intentCall);}
                                    else{
                                        Toast.makeText(itemView.getContext(), "Acceso no autorizado", Toast.LENGTH_LONG).show();
                                    }
                                }
                            })
                            .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alertDialog1 = alertDialog.create();
                    alertDialog.show();
                }
            });
        }
    }
}
