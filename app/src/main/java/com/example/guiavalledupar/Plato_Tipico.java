package com.example.guiavalledupar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.guiavalledupar.Entity.Plato;
import com.example.guiavalledupar.Services.PlatoService;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

public class Plato_Tipico extends AppCompatActivity {

    CarouselView carouselView;
    private ArrayList<Plato> platos;
    private PlatoService PlatoService;
    TextView patos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plato__tipico);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        PlatoService = new PlatoService(this);

        platos = PlatoService.getPlatos();

        patos = findViewById(R.id.textplatos);
        //Toast.makeText(this, PlatoService.getPlatos().get()+" platos", Toast.LENGTH_LONG).show();
        this.get();
        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(this.platos.size());

        carouselView.setImageListener(imageListener);

        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                //Toast.makeText(MainActivity.this, "LA FOTO FUE TOMADA EN "+nameImg[position], Toast.LENGTH_SHORT).show();
            }
        });
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(PlatoService.getPlatos().get(position).Image);
        }
    };

    public void get(){
        for (int i = 0; i < platos.size(); i++){
            patos.setText(patos.getText()+"\n nombre "+this.platos.get(i).Name+" descripcion "+this.platos.get(i).Description);
        }
    }

}
