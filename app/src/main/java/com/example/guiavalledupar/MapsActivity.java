package com.example.guiavalledupar;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity  implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Double latitud;
    private Double longitud;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        //ActionBar actionBar = getSupportActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(true);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        name = getIntent().getStringExtra("name");
        latitud = Double.parseDouble(getIntent().getStringExtra("latitud"));
        longitud = Double.parseDouble(getIntent().getStringExtra("longitud"));

        Toast.makeText(getApplicationContext(), "name "+name+" latitud "+latitud+" longitud "+longitud, Toast.LENGTH_LONG).show();
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
        LatLng cordenada = new LatLng(latitud, longitud);
        mMap.addMarker(new MarkerOptions().position(cordenada).title(name));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cordenada, 13));
    }
}
