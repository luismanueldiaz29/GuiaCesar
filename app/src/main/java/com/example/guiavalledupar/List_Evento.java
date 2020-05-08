package com.example.guiavalledupar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.guiavalledupar.Entity.Municipio;
import com.example.guiavalledupar.Services.MunicipioService;

import java.util.ArrayList;

public class List_Evento extends AppCompatActivity {

    private MunicipioService municipioService;
    private ArrayList<Municipio> municipios;
    private RecyclerView ReciclerViewEvento;
    private AdapterEventos adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list__evento);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        municipioService = new MunicipioService(this);
        municipios = municipioService.getMunicipios();

        ReciclerViewEvento = (RecyclerView)findViewById(R.id.ReciclerViewEvento);
        ReciclerViewEvento.setLayoutManager(new LinearLayoutManager(this));

        adapter = new AdapterEventos(municipios);
        ReciclerViewEvento.setAdapter(adapter);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String posicion = ReciclerViewEvento.getChildAdapterPosition(v)+"";
                DetalleEvento(posicion);
                Toast.makeText(getApplicationContext(), "click in "+posicion, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void DetalleEvento(String posicion){
        Intent intent = new Intent(this, Evento.class);
        intent.putExtra("PEvento", posicion);
        startActivity(intent);
    }
}
