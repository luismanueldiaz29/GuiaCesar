package com.example.guiavalledupar.GUI;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.guiavalledupar.Entity.SiteOfInterest;
import com.example.guiavalledupar.R;
import com.example.guiavalledupar.Services.SitioService;

public class detalleSitios extends AppCompatActivity {

    SitioService servicio;
    String message;
    TextView tituloView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_sitios);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        servicio=new SitioService();
        Intent intent=getIntent();
        message=intent.getStringExtra("ID");
        if(intent.getStringExtra("ID")!=null){
            int id=Integer.parseInt(message);

            SiteOfInterest sitio=servicio.getSite(id);

            android.widget.Toast toast1;
            toast1= Toast.makeText(getApplicationContext(),"Detalle de "+sitio.name+" "+ id, Toast.LENGTH_SHORT);
            toast1.show();
            setValues(sitio);
        }
    }
    public void setValues(SiteOfInterest site){
        tituloView=findViewById(R.id.title);tituloView.setText(site.name);
        //descripcionView=findViewById(R.id.descripcion); descripcionView.setText(sitio.descripcion);
    }
}
