package com.example.guiavalledupar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SitiosInteres(View view) {
        android.widget.Toast toast1 =Toast.makeText(getApplicationContext(),"Sistios de interes", Toast.LENGTH_SHORT);
        toast1.show();
    }

    public void Evento(View view) {
        android.widget.Toast toast1 =Toast.makeText(getApplicationContext(),"Eventos", Toast.LENGTH_SHORT);
        toast1.show();
    }

    public void Parques(View view) {
        android.widget.Toast toast1 =Toast.makeText(getApplicationContext(),"Parques", Toast.LENGTH_SHORT);
        toast1.show();
    }

    public void PlatosTipicos(View view) {
        android.widget.Toast toast1 =Toast.makeText(getApplicationContext(),"Platos tipicos", Toast.LENGTH_SHORT);
        toast1.show();
    }

    public void Emergencias(View view) {
        android.widget.Toast toast1 =Toast.makeText(getApplicationContext(),"Emergencias", Toast.LENGTH_SHORT);
        toast1.show();
    }
}
