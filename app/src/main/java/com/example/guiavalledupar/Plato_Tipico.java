package com.example.guiavalledupar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    private ArrayList<Plato> platos;
    private PlatoService PlatoService;
    private RecyclerView recyclerViewPlatos;
    private Adapter adapter;

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

        adapter = new Adapter(platos);
        recyclerViewPlatos.setAdapter(adapter);
    }

}
