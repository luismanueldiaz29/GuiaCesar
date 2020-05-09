
package com.example.guiavalledupar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

public class MainActivity extends AppCompatActivity {

    CarouselView carouselView;
    TextView textInfoCarrusel;
    int[] sampleImages = {R.drawable.laduda, R.drawable.lajunta, R.drawable.callejonpurruputu, R.drawable.pueblobello, R.drawable.canaberales, R.drawable.lapaz, R.drawable.colegioloperena};
    String[] nameImg = {"LA DUDA", "lA JUNTA", "CALLEJON DE LA PURRUPUTU", "PUEBLO BELLO", "MANANTIAL DE CAÑAVERALES", "LA PAZ", "COLEGIO NACIONAL LOPERENA"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //textInfoCarrusel = findViewById(R.id.infocarrusel);

        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(imageListener);

        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(MainActivity.this, "LA FOTO FUE TOMADA EN "+nameImg[position], Toast.LENGTH_SHORT).show();
            }
        });
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

    public void SitiosInteres(View view) {
        Intent intent = new Intent(this, Municipios_Sitios.class);
        startActivity(intent);
        android.widget.Toast toast1 =Toast.makeText(getApplicationContext(),"Sistios de interes", Toast.LENGTH_SHORT);
        toast1.show();
    }

    public void Evento(View view) {
        Intent intent = new Intent(this, List_Evento.class);
        startActivity(intent);
        android.widget.Toast toast1 =Toast.makeText(getApplicationContext(),"Eventos", Toast.LENGTH_SHORT);
        toast1.show();
    }

    public void Parques(View view) {
        android.widget.Toast toast1 =Toast.makeText(getApplicationContext(),"Parques", Toast.LENGTH_SHORT);
        toast1.show();
    }

    public void PlatosTipicos(View view) {
        Intent intent = new Intent(this, Plato_Tipico.class);
        startActivity(intent);
        android.widget.Toast toast1 =Toast.makeText(getApplicationContext(),"Platos tipicos", Toast.LENGTH_SHORT);
        toast1.show();
    }

    public void Emergencias(View view) {
        android.widget.Toast toast1 =Toast.makeText(getApplicationContext(),"Emergencias", Toast.LENGTH_SHORT);
        toast1.show();
    }
}
