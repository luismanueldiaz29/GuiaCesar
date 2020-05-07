package com.example.guiavalledupar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.guiavalledupar.Services.SitioService;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

public class Sitios extends AppCompatActivity {
    //RepositorioSitio repositorio;
    int numeroImagenes;
    CarouselView carouselView;

    SitioService servicio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitios);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        servicio= new SitioService();


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


    public void SitiosInteres(int position) {
        android.widget.Toast toast1;
        toast1=Toast.makeText(getApplicationContext(),"Detalle de "+servicio.getNombre(position), Toast.LENGTH_SHORT);
        toast1.show();

        String id=String.valueOf(servicio.getId(position));
        Intent intent= new Intent (this,detalleSitios.class);
        intent.putExtra("ID",id);
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
