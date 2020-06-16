package com.example.guiavalledupar.GUI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.guiavalledupar.Entity.Actividad;
import com.example.guiavalledupar.R;
import com.example.guiavalledupar.Repository.ActividadRepository;

public class detalle_actividad extends AppCompatActivity {

    private Actividad actividad;
    private int pocision;
    private TextView tvName;
    private TextView tvDescription;
    private ImageView imgActividad;
    ActividadRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_actividad);
        tvName=findViewById(R.id.tvNameActividad);
        tvDescription=findViewById(R.id.tvActividadDescription);
        imgActividad=findViewById(R.id.imgActividadDe);
        repository=new ActividadRepository(this);

        if(getIntent().getStringExtra("posicion") != null) {
            pocision = Integer.parseInt(getIntent().getStringExtra("posicion"));
            actividad = repository.getActividad(pocision);
            detalleActividad();
            Toast.makeText(this, actividad.Name + " clicked in detalle", Toast.LENGTH_LONG).show();
        }

    }
    private void detalleActividad(){
        imgActividad.setImageResource(actividad.Image);
        tvName.setText(actividad.Name);
        tvDescription.setText(actividad.Description);
    }


}
