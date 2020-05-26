package com.example.guiavalledupar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.guiavalledupar.Adapters.AdapterHospitalAPI;
import com.example.guiavalledupar.Entity.HospitalApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class Hospitales extends AppCompatActivity {
    private RequestQueue queue;
    private ArrayList<HospitalApi> hospitales;
    private RecyclerView lista;
    private AdapterHospitalAPI adapter;
    private String municipio;
    private String URL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitales);
        lista=findViewById(R.id.listaHospitalesAPI);
        lista.setLayoutManager(new LinearLayoutManager(this));
        hospitales= new ArrayList<HospitalApi>();

        if((getIntent().getStringExtra("PMunicipio") != null)){
            municipio = getIntent().getStringExtra("PMunicipio");
            URL=HospitalApi.getURLSpecial(municipio);
        }else{
            URL="https://www.datos.gov.co/resource/q2qp-usbt.json";
        }
        queue = Volley.newRequestQueue(this);
        GetVolley();
    }
    private void GetVolley(){
        JsonArrayRequest request
                = new JsonArrayRequest(Request.Method.GET,URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            HospitalApi hospital;
                            for(int i=0;i<response.length(); i++){
                                JSONObject jsonObject=response.getJSONObject(i);
                                hospital=new HospitalApi();
                                hospital.name=jsonObject.getString("nombre_del_prestador");
                                hospital.direction=jsonObject.getString("direccion");
                                hospital.phone=jsonObject.getString("tel_fono");
                                hospital.municipio=jsonObject.getString("municipio");
                                hospitales.add(hospital);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        adapter = new AdapterHospitalAPI(hospitales);
                        lista.setAdapter(adapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        this.queue.add(request);
    }


}
