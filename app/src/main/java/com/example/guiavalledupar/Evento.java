package com.example.guiavalledupar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.guiavalledupar.Adapters.ModalBottomSheet;
import com.example.guiavalledupar.Entity.Municipio;
import com.example.guiavalledupar.Services.MunicipioService;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class Evento extends AppCompatActivity {

    private Municipio municipio;
    private MunicipioService municipioService;
    private TextView tvdescripcionMunicipio;
    private TextView tvEventoDescription;
    private TextView tvNombreMunicipio;
    private ImageView ivEventoImage;
    private FloatingActionButton btnCalendarEvento;
    private FloatingActionButton btnConsultLocalEvent;

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
        btnCalendarEvento = findViewById(R.id.btnCalendarEvento);
        btnConsultLocalEvent = findViewById(R.id.btnConsultLocalEvent);

        municipioService = new MunicipioService(this);

        if (getIntent().getStringExtra("PEvento") != null){
            int pocision = Integer.parseInt(getIntent().getStringExtra("PEvento"));
            municipio = municipioService.getMunicipio(pocision);
            DetalleMunicipio(municipio);
            Toast.makeText(this, municipio.Name, Toast.LENGTH_LONG).show();
        }

        btnCalendarEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarSBDialog(R.layout.recordatorio, tvEventoDescription.getText().toString(), tvNombreMunicipio.getText().toString());
            }
        });

        btnConsultLocalEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LanzarLocalizacion();
            }
        });
    }

    private void LanzarLocalizacion(){
        int pocision = Integer.parseInt(getIntent().getStringExtra("PEvento"));
        Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
        intent.putExtra("name", municipioService.getMunicipio(pocision).Name);
        intent.putExtra("longitud", municipioService.getMunicipio(pocision).Longitud);
        intent.putExtra("latitud", municipioService.getMunicipio(pocision).Latitud);
        startActivity(intent);
    }

    private void DetalleMunicipio(Municipio municipio) {
        tvNombreMunicipio.setText(municipio.Name);
        tvdescripcionMunicipio.setText(municipio.Description);
        tvEventoDescription.setText(municipio.Evento);
        ivEventoImage.setImageResource(municipio.img);
    }

    private void lanzarSBDialog(int layoutStyle, String descripcion, String nombre) {
        BottomSheetDialogFragment bottomSheetDialogFragment = new ModalBottomSheet(layoutStyle, descripcion, nombre);
        //si esta en FALSE obliga al usuario a pulsar un boton
        //bottomSheetDialogFragment.setCancelable(false);
        bottomSheetDialogFragment.setShowsDialog(true);
        bottomSheetDialogFragment.show(getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
    }
}
