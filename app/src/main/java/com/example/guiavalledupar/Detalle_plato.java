package com.example.guiavalledupar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.guiavalledupar.Entity.Plato;
import com.example.guiavalledupar.Repository.PlatoRepository;
import com.example.guiavalledupar.Services.PlatoService;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Detalle_plato extends AppCompatActivity {

    private PlatoService platoService;
    private Plato plato;

    private TextView tvNamePlato;
    private TextView tvPlatoDescription;
    private TextView tvPreparacion_plato;
    private ImageView imgPlato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_plato);

        tvNamePlato = findViewById(R.id.tvNamePlato);
        tvPlatoDescription = findViewById(R.id.tvPlatoDescription);
        tvPreparacion_plato = findViewById(R.id.tvPreparacion_plato);
        imgPlato = findViewById(R.id.imgPlato);

        platoService = new PlatoService(this);
        plato = new Plato();

        if(getIntent().getStringExtra("posicion") != null){
            int pocision = Integer.parseInt(getIntent().getStringExtra("posicion"));
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
}
