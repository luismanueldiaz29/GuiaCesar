package com.example.guiavalledupar.GUI;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.guiavalledupar.Adapters.AdapterPlatos;
import com.example.guiavalledupar.Entity.Plato;
import com.example.guiavalledupar.R;
import com.example.guiavalledupar.Services.PlatoService;

import java.util.ArrayList;

public class Plato_Tipico extends AppCompatActivity {

    private ArrayList<Plato> platos;
    private PlatoService PlatoService;
    private RecyclerView recyclerViewPlatos;
    private AdapterPlatos adapter;
    private int click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plato__tipico);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        PlatoService = new PlatoService(this);
        platos = PlatoService.getPlatos();

        recyclerViewPlatos = (RecyclerView) findViewById(R.id.ReciclerViewPlatos);
        recyclerViewPlatos.setLayoutManager(new LinearLayoutManager(this));

        adapter = new AdapterPlatos(platos);
        recyclerViewPlatos.setAdapter(adapter);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String posicion = recyclerViewPlatos.getChildAdapterPosition(v)+"";
                Detalle(posicion);
                Toast.makeText(getApplicationContext(), "click in "+posicion, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void Detalle(String item){
        Intent intent = new Intent(this, Detalle_plato.class);
        intent.putExtra("posicion", item);
        startActivity(intent);
    }

}
