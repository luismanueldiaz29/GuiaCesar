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
import com.example.guiavalledupar.Entity.HotelApi;
import com.example.guiavalledupar.Entity.ServicioApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;



public class Hospitales extends AppCompatActivity {
    private RequestQueue queue;
    private ArrayList<ServicioApi> servicioApis;
    private RecyclerView lista;
    private AdapterHospitalAPI adapter;
    private String municipio;
    private String URL;
    private String URL2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitales);
        lista=findViewById(R.id.listaHospitalesAPI);
        lista.setLayoutManager(new LinearLayoutManager(this));
        servicioApis = new ArrayList<>();
        if((getIntent().getStringExtra("PMunicipio") != null)){
            municipio = getIntent().getStringExtra("PMunicipio");
            if(municipio=="RIO DE ORO"){
                municipio="RÍO DE ORO";
            }
            if(municipio=="CURUMANI"){
                municipio="CURUMANÍ";
            }
            if(municipio=="GONZALEZ"){
                municipio="GONZÁLEZ";
            }
            if(municipio=="CHIRIGUANA"){
                municipio="CHIRIGUANÁ";
            }
            if(municipio=="SAN MARTIN"){
                municipio="SAN MARTÍN";
            }
            if(municipio=="AGUSTIN CODAZZI"){
                municipio="AGUSTÍN CODAZZI";
            }


            URL=HospitalApi.getURLSpecial(municipio);
            URL2= HotelApi.getURLSpecial(municipio);
        }else{
            URL="https://www.datos.gov.co/resource/q2qp-usbt.json";
            URL2="https://www.datos.gov.co/resource/87gw-ij3v.json";
        }
        queue = Volley.newRequestQueue(this);
        GetVolley();
        GetVolley2();
    }

    private void GetVolley2() {
        JsonArrayRequest request
                = new JsonArrayRequest(Request.Method.GET,URL2,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            ServicioApi hotel;
                            for(int i=0;i<response.length(); i++){
                                JSONObject jsonObject=response.getJSONObject(i);
                                hotel=new HotelApi();
                                hotel.name=jsonObject.getString(HotelApi.jsonName);
                                hotel.direction=jsonObject.getString(HotelApi.jsonDirection);
                                hotel.phone=jsonObject.getString(HotelApi.jsonPhone);
                                hotel.municipio=jsonObject.getString(HotelApi.jsonMuni);
                                servicioApis.add(hotel);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        adapter = new AdapterHospitalAPI(servicioApis);
                        lista.setAdapter(adapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        this.queue.add(request);
    }

    private void GetVolley(){
        JsonArrayRequest request
                = new JsonArrayRequest(Request.Method.GET,URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            ServicioApi hospital;
                            for(int i=0;i<response.length(); i++){
                                JSONObject jsonObject=response.getJSONObject(i);
                                hospital=new HospitalApi();
                                hospital.name=jsonObject.getString(HospitalApi.jsonName);
                                hospital.direction=jsonObject.getString(HospitalApi.jsonDirection);
                                hospital.phone=jsonObject.getString(HospitalApi.jsonPhone);
                                hospital.municipio=jsonObject.getString(HospitalApi.jsonMuni);
                                servicioApis.add(hospital);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        this.queue.add(request);
    }
}