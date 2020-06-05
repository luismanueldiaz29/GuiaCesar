package com.example.guiavalledupar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.guiavalledupar.Adapters.AdapterMunicipioApi;
import com.example.guiavalledupar.Entity.MunicipioApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Emergencia extends AppCompatActivity {
    private RequestQueue queue;
    private ArrayList<MunicipioApi>municipios;
    private RecyclerView lista;
    private AdapterMunicipioApi adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergencia);
        lista=findViewById(R.id.reciclerMApi);
        lista.setLayoutManager(new LinearLayoutManager(this));
        municipios= new ArrayList<MunicipioApi>();

        queue = Volley.newRequestQueue(this);
        GetVolley();
    }
    private void GetVolley(){
        String URL="https://www.datos.gov.co/resource/29nu-8d2m.json";
        JsonArrayRequest request
                = new JsonArrayRequest(Request.Method.GET,URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            MunicipioApi muni;
                            for(int i=0;i<response.length(); i++){
                                JSONObject jsonObject=response.getJSONObject(i);
                                muni=new MunicipioApi();
                                muni.nombre=jsonObject.getString("municipio");
                                muni.direccion=jsonObject.getString("direccion");
                                municipios.add(muni);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        setearAdapter();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        this.queue.add(request);
    }


    private void setearAdapter(){
        adapter=new AdapterMunicipioApi(municipios);
        lista.setAdapter(adapter);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String posicion = lista.getChildAdapterPosition(v)+"";
                mostrarHospitales(posicion);
            }
        });
    }

    private void mostrarHospitales(String posicion){
        Intent intent = new Intent(this, Hospitales.class);
        int posInt=Integer.parseInt(posicion);
        String muni=municipios.get(posInt).nombre;
        intent.putExtra("PMunicipio", muni);
        startActivity(intent);
    }


}