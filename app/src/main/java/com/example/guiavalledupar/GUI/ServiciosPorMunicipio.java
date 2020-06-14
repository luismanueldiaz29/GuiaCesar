package com.example.guiavalledupar.GUI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.guiavalledupar.Adapters.AdapterServiceAPI;
import com.example.guiavalledupar.Entity.DrogueriaApi;
import com.example.guiavalledupar.Entity.HospitalApi;
import com.example.guiavalledupar.Entity.HotelApi;
import com.example.guiavalledupar.Entity.ServiceApi;
import com.example.guiavalledupar.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;



public class ServiciosPorMunicipio extends AppCompatActivity {
    private RequestQueue queue;
    private ArrayList<ServiceApi> listaServices;
    private RecyclerView reciclerServices;
    private AdapterServiceAPI adapter;
    private TextView txtMuni;
    private Button btnFiltrar;
    private EditText txtFilter;

    private String municipio;
    private String URL;
    private String URL2;
    private String URL3;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios);
        setControls();
        layoutManager=new LinearLayoutManager(this);
        reciclerServices.setLayoutManager(layoutManager);

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
            URL3= DrogueriaApi.getURLSpecial(municipio);
        }
        else{
            URL="https://www.datos.gov.co/resource/q2qp-usbt.json";
            URL2="https://www.datos.gov.co/resource/87gw-ij3v.json";
            URL3="https://www.datos.gov.co/resource/32rd-kkaa.json";
        }

        txtMuni.setText(municipio);
        btnFiltrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filtrar();
            }
        });
        queue = Volley.newRequestQueue(this);
        llenarLista();
    }

    private void filtrar(){

        String buscar=txtFilter.getText().toString().trim();
        if(!buscar.equals("")) {
            ArrayList<ServiceApi> lista2;
            lista2 = new ArrayList<>();
            for (ServiceApi e : listaServices) {
                if (e.name.contains(buscar)||e.name.contains(buscar.toUpperCase())|| e.getStringTipo().contains(buscar)) {
                    lista2.add(e);
                }
            }
            adapter = new AdapterServiceAPI(lista2);
            reciclerServices.setAdapter(adapter);
        }
    }

    private void llenarLista(){
        GetVolley();
        GetVolley2();
        GetVolley3();
    }

    private void setControls(){
        reciclerServices =findViewById(R.id.listaHospitalesAPI);
        txtMuni=findViewById(R.id.muniServicioTV);
        txtFilter=findViewById(R.id.txtBuscarService);
        btnFiltrar =findViewById(R.id.btnFiltrarService);

        listaServices = new ArrayList<>();

    }

    private void GetVolley(){
        JsonArrayRequest request
                = new JsonArrayRequest(Request.Method.GET,URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            ServiceApi hospital;
                            for(int i=0;i<response.length(); i++){
                                JSONObject jsonObject=response.getJSONObject(i);
                                hospital=new HospitalApi();
                                hospital.name=jsonObject.getString(HospitalApi.jsonName);
                                hospital.direction=jsonObject.getString(HospitalApi.jsonDirection);
                                hospital.phone=jsonObject.getString(HospitalApi.jsonPhone);
                                hospital.municipio=jsonObject.getString(HospitalApi.jsonMuni);
                                hospital.tipo= ServiceApi.HOSPITAL;
                                listaServices.add(hospital);
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
    private void GetVolley2() {
        JsonArrayRequest request
                = new JsonArrayRequest(Request.Method.GET,URL2,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            ServiceApi hotel;
                            for(int i=0;i<response.length(); i++){
                                JSONObject jsonObject=response.getJSONObject(i);
                                hotel=new HotelApi();
                                hotel.name=jsonObject.getString(HotelApi.jsonName);
                                hotel.direction=jsonObject.getString(HotelApi.jsonDirection);
                                hotel.phone=jsonObject.getString(HotelApi.jsonPhone);
                                hotel.municipio=jsonObject.getString(HotelApi.jsonMuni);
                                hotel.tipo= ServiceApi.HOTEL;
                                listaServices.add(hotel);
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
    private void GetVolley3() {
        JsonArrayRequest request
                = new JsonArrayRequest(Request.Method.GET,URL3,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            ServiceApi drogueria;
                            for(int i=0;i<response.length(); i++){
                                JSONObject jsonObject=response.getJSONObject(i);
                                drogueria=new DrogueriaApi();
                                drogueria.name=jsonObject.getString(DrogueriaApi.jsonName);
                                drogueria.direction=jsonObject.getString(DrogueriaApi.jsonDirection);
                                drogueria.phone=jsonObject.getString(DrogueriaApi.jsonPhone);
                                drogueria.municipio=jsonObject.getString(DrogueriaApi.jsonMuni);
                                drogueria.tipo= ServiceApi.DROGUERIA;
                                listaServices.add(drogueria);
                                adapter = new AdapterServiceAPI(listaServices);
                                reciclerServices.setAdapter(adapter);
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