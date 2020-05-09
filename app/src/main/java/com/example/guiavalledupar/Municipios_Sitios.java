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

public class Municipios_Sitios extends AppCompatActivity {

    private RecyclerView ReciclerViewMunicipio;
    private MunicipioService municipioService;
    private ArrayList<Municipio> municipios;
    private RecyclerView ReciclerViewEvento;
    private AdapterEventos adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_municipios__sitios);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        municipioService = new MunicipioService(this);
        municipios = municipioService.getMunicipios();

        ReciclerViewEvento = (RecyclerView)findViewById(R.id.ReciclerViewMunicipio);
        ReciclerViewEvento.setLayoutManager(new LinearLayoutManager(this));

        adapter = new AdapterEventos(municipios);
        ReciclerViewEvento.setAdapter(adapter);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String posicion = ReciclerViewEvento.getChildAdapterPosition(v)+"";
                DetalleSitio(posicion);
                Toast.makeText(getApplicationContext(), "click in "+posicion, Toast.LENGTH_LONG).show();
            }
        });
    }
    public void DetalleSitio(String posicion){
        Intent intent = new Intent(this, Sitios.class);
        intent.putExtra("PMunicipio", posicion);
        startActivity(intent);
    }

}
