package com.example.guiavalledupar;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.widget.Toast;

import com.example.guiavalledupar.Entity.Municipio;
import com.example.guiavalledupar.Entity.Restaurante;
import com.example.guiavalledupar.Services.MunicipioService;
import com.example.guiavalledupar.Services.RestauranteService;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity  implements OnMapReadyCallback {

    private GoogleMap mMap;
    private MunicipioService municipioService;
    private RestauranteService restauranteService;
    private Municipio municipio;
    private Double Latitud;
    private Double Longitud;
    private String Titulo;
    private float zoom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        municipioService = new MunicipioService(getApplicationContext());
        restauranteService = new RestauranteService(getApplicationContext());

        init();

    }

    public void init(){
        String posicion = getIntent().getStringExtra("posicion");
        if(posicion != null && !posicion.isEmpty()) {
            //String posicion = getIntent().getStringExtra("posicion");
            municipio = municipioService.getMunicipio(Integer.parseInt(posicion));
            Latitud = municipio.Latitud;
            Longitud = municipio.Longitud;
            Titulo = municipio.Name;
            zoom = 13;
            //Toast.makeText(getApplicationContext(), "name "+municipio.Name+" latitud "+municipio.Latitud+" longitud "+municipio.Longitud, Toast.LENGTH_LONG).show();

        }else if(!getIntent().getStringExtra("Titulo").isEmpty()){
            Titulo = getIntent().getStringExtra("Titulo");
            Latitud = Double.parseDouble(getIntent().getStringExtra("Latitud"));
            Longitud = Double.parseDouble(getIntent().getStringExtra("Longitud"));
            zoom = 18;
            //Toast.makeText(getApplicationContext(), "name "+Titulo+" latitud "+Latitud+" longitud "+Longitud, Toast.LENGTH_LONG).show();
        }//else{
           // Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
        //}
    }
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng cordenada = new LatLng(Latitud, Longitud);
        mMap.addMarker(new MarkerOptions().position(cordenada).title(Titulo));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cordenada, zoom));
    }

}
