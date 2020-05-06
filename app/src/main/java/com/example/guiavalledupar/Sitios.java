package com.example.guiavalledupar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import com.example.guiavalledupar.Repository.RepositorioSitio;

public class Sitios extends AppCompatActivity {
    RepositorioSitio repositorio;
    int numeroImagenes;
    CarouselView carouselView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitios);
        repositorio =new RepositorioSitio();
        numeroImagenes=repositorio.getArraySitios().size();

        carouselView =findViewById(R.id.carouselView);
        carouselView.setPageCount(numeroImagenes);
        carouselView.setImageListener(imageListener);

        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {

                //crear la otra actividad
            }
        });
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            int imagen=repositorio.getArraySitios().get(position).imagen;
            imageView.setImageResource(imagen);
        }
    };

    public void informacionSitio(View view) {
        Intent intent = new Intent(this, Sitios.class);
        startActivity(intent);
    }

}
