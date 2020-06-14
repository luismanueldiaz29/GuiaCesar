
package com.example.guiavalledupar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.example.guiavalledupar.GUI.Emergencia;
import com.example.guiavalledupar.GUI.List_Evento;
import com.example.guiavalledupar.GUI.Municipios_Sitios;
import com.example.guiavalledupar.GUI.Plato_Tipico;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

public class MainActivity extends AppCompatActivity {

    CarouselView carouselView;
    TextView textInfoCarrusel;
    int[] sampleImages = {R.drawable.laduda, R.drawable.lajunta, R.drawable.callejonpurruputu, R.drawable.pueblobello, R.drawable.canaberales, R.drawable.lapaz, R.drawable.colegioloperena};
    String[] nameImg = {"LA DUDA", "lA JUNTA", "CALLEJON DE LA PURRUPUTU", "PUEBLO BELLO", "MANANTIAL DE CAÑAVERALES", "LA PAZ", "COLEGIO NACIONAL LOPERENA"};
    String[] LatitudImg = {"10.053117", "10.774313", "10.478926", "10.410502", "10.749664", "10.388072", "10.473482"};
    String[] LongitudImg = {"-73.176672", "-73.145745", "-73.246718", "-73.591400", "-72.841748", "-73.169526", "-73.248729"};
    private static final String USGS_REQUEST_URL = "https://ws.audioscrobbler.com/2.0/?method=chart.gettoptracks&api_key=b284db959637031077380e7e2c6f2775&format=json";
    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    public void init(){
        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);

        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                //Toast.makeText(MainActivity.this, "LA FOTO FUE TOMADA EN "+nameImg[position], Toast.LENGTH_SHORT).show();
                Dialog(position);
            }
        });
    }

    public void Dialog(final int position){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage("LA FOTO FUE TOMADA EN "+nameImg[position])
                .setTitle("Informacion del lugar")
                .setCancelable(true)
                .setPositiveButton("Ubicacion", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //dialog.cancel();
                        LanzarIntent(position);
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

    private void LanzarIntent(int position){
        Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
        intent.putExtra("Latitud", LatitudImg[position]);
        intent.putExtra("Longitud", LongitudImg[position]);
        intent.putExtra("Titulo", nameImg[position]);
        startActivity(intent);
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
        Intent intent =new Intent(this, Emergencia.class);
        startActivity(intent);
    }


}
