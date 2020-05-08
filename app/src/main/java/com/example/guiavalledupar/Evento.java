package com.example.guiavalledupar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.guiavalledupar.Entity.Municipio;
import com.example.guiavalledupar.Services.MunicipioService;

public class Evento extends AppCompatActivity {

    private Municipio municipio;
    private MunicipioService municipioService;
    private TextView tvdescripcionMunicipio;
    private TextView tvEventoDescription;
    private TextView tvNombreMunicipio;
    private ImageView ivEventoImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        tvNombreMunicipio = (TextView)findViewById(R.id.tvNombreMunicipio);
        tvdescripcionMunicipio = (TextView)findViewById(R.id.tvdescripcionMunicipio);
        tvEventoDescription = (TextView)findViewById(R.id.tvEventoDescription);
        ivEventoImage = (ImageView)findViewById(R.id.ivEventoImage);

        municipioService = new MunicipioService(this);

        if (getIntent().getStringExtra("PEvento") != null){
            int pocision = Integer.parseInt(getIntent().getStringExtra("PEvento"));
            municipio = municipioService.getMunicipio(pocision);
            DetalleMunicipio(municipio);
            Toast.makeText(this, municipio.Name, Toast.LENGTH_LONG).show();
        }
    }

    private void DetalleMunicipio(Municipio municipio) {
        tvNombreMunicipio.setText(municipio.Name);
        tvdescripcionMunicipio.setText(municipio.Description);
        tvEventoDescription.setText(municipio.Evento);
        ivEventoImage.setImageResource(municipio.img);
    }
}
