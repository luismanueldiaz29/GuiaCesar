package com.example.guiavalledupar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.guiavalledupar.Services.SitiosServicio;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import com.example.guiavalledupar.Repository.RepositorioSitio;

public class Sitios extends AppCompatActivity {
    //RepositorioSitio repositorio;
    int numeroImagenes;
    CarouselView carouselView;

    SitiosServicio servicio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitios);
        //repositorio =new RepositorioSitio();
        servicio= new SitiosServicio();

        //numeroImagenes=repositorio.getArraySitios().size();
        numeroImagenes=servicio.getSize();


        carouselView =findViewById(R.id.carouselView);
        carouselView.setPageCount(numeroImagenes);
        carouselView.setImageListener(imageListener);

        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                SitiosInteres(position);
            }
        });
    }

    //public int getImg(int position){ return servicio.getArraySitios().get((position)).imagen; }
    //public String getNombre(int position){return servicio.getArraySitios().get(position).nombre;}

    public void SitiosInteres(int position) {
        android.widget.Toast toast1;
        toast1=Toast.makeText(getApplicationContext(),"Detalle de "+servicio.getNombre(position), Toast.LENGTH_SHORT);
        toast1.show();
        Intent intent= new Intent (this,detalleSitios.class);
        intent.putExtra("img",servicio.getImg(position));
        startActivity(intent);
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            int imagen=servicio.getImg(position);
            imageView.setImageResource(imagen);
        }
    };

    public void informacionSitio(View view) {
        Intent intent = new Intent(this, Sitios.class);
        startActivity(intent);
    }

}
