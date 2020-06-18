package com.example.guiavalledupar.GUI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        Init();
    }

    private void Init(){
        service=new ActividadService(this);
        actividades=service.getActividades();

        recyclerView=findViewById(R.id.reciclerActi);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter=new AdapterActividades(actividades);
        recyclerView.setAdapter(adapter);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String posicion = recyclerView.getChildAdapterPosition(v)+"";
                Detalle(posicion);
                Toast.makeText(getApplicationContext(), "click in "+posicion, Toast.LENGTH_LONG).show();
            }
        });
    }
    public void Detalle(String item){
        Intent intent = new Intent(this, detalle_actividad.class);
        intent.putExtra("posicion", item);
        startActivity(intent);
    }
}
