package com.example.guiavalledupar.GUI;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.guiavalledupar.Adapters.AdapterExpandableRestaurante;
import com.example.guiavalledupar.Entity.Plato;
import com.example.guiavalledupar.Entity.Restaurante;
import com.example.guiavalledupar.R;
import com.example.guiavalledupar.Repository.PlatoRepository;
import com.example.guiavalledupar.Services.PlatoService;
import com.example.guiavalledupar.Services.RestauranteService;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Detalle_plato extends AppCompatActivity {

    private PlatoService platoService;
    private Plato plato;
    private int pocision;
    private TextView tvNamePlato;
    private TextView tvPlatoDescription;
    private TextView tvPreparacion_plato;
    private ImageView imgPlato;
    private RestauranteService restauranteService;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_plato);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        restauranteService = new RestauranteService(getApplicationContext());

        init();


        recyclerView = findViewById(R.id.RecyclerRestaurantes);
        ArrayList<Restaurante> restaurantes;
        restaurantes = initData();
        AdapterExpandableRestaurante adapterExpandableRestaurante = new AdapterExpandableRestaurante(restaurantes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterExpandableRestaurante);
    }

    private void init(){
        tvNamePlato = findViewById(R.id.tvNamePlato);
        tvPlatoDescription = findViewById(R.id.tvPlatoDescription);
        tvPreparacion_plato = findViewById(R.id.tvPreparacion_plato);
        imgPlato = findViewById(R.id.imgPlato);

        platoService = new PlatoService(this);
        plato = new Plato();

        if(getIntent().getStringExtra("posicion") != null){
            pocision = Integer.parseInt(getIntent().getStringExtra("posicion"));
            plato = platoService.getPlato(pocision);
            DetallePlato(plato);
            Toast.makeText(this, plato.Name+" clicked in detalle", Toast.LENGTH_LONG).show();
        }
    }

    private void DetallePlato(Plato plato) {
        tvNamePlato.setText(plato.Name);
        tvPreparacion_plato.setText(plato.Preparation);
        tvPlatoDescription.setText(plato.Description);
        imgPlato.setImageResource(plato.Image);
    }

    private ArrayList<Restaurante> initData(){
        ArrayList<Restaurante> restaurantes = restauranteService.GetRestaurantes(pocision);
        //for (int i = 0; i <= 10; i++) {
        //    Restaurante restaurante = new Restaurante();
        //    restaurante.Name = "restaurante";
        //    restaurante.Direccion = "calle 10 a 47";
        //    restaurante.Horario = "300517356";
        //    restaurantes.add(restaurante);
        //}
        return  restaurantes;
    }
}
