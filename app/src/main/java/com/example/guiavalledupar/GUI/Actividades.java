package com.example.guiavalledupar.GUI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.guiavalledupar.Adapters.AdapterActividades;
import com.example.guiavalledupar.Entity.Actividad;
import com.example.guiavalledupar.R;
import com.example.guiavalledupar.Services.ActividadService;

import java.util.ArrayList;

public class Actividades extends AppCompatActivity {
    private ArrayList<Actividad> actividades;
    private ActividadService service;
    private RecyclerView recyclerView;
    private AdapterActividades adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades);

        service=new ActividadService(this);
        actividades=service.getActividades();

        recyclerView=findViewById(R.id.reciclerActi);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerViewPlatos.setLayoutManager(new LinearLayoutManager(this));
        adapter=new AdapterActividades(actividades);
        recyclerView.setAdapter(adapter);
        //Toast toast1 = Toast.makeText(getApplicationContext(),actividades.size(), Toast.LENGTH_SHORT);
        /*
        *<androidx.recyclerview.widget.RecyclerView
        android:id="@+id/reciclerActividades2"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />*/
        //toast1.show();
    }
}
