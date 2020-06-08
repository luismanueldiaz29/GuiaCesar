package com.example.guiavalledupar.Repository;

import android.content.Context;
import android.content.res.Resources;

import com.example.guiavalledupar.Entity.Municipio;
import com.example.guiavalledupar.Entity.Plato;
import com.example.guiavalledupar.R;

import java.util.ArrayList;
import java.util.ListIterator;

public class MunicipioRepository {

    private Context context;

    public MunicipioRepository(Context context){
        this.context = context;
    }

    public ArrayList<Municipio> getMunicipios(){

        Resources Res = this.context.getResources();
        String[] name = Res.getStringArray(R.array.name_municipios);
        String[] description = Res.getStringArray(R.array.Descripcion_municipios);
        int[] img = {R.drawable.valledupar,R.drawable.lapazcesar,R.drawable.manaure,R.drawable.pueblobellocesar};
        String[] sitio = Res.getStringArray(R.array.municipio_sitio);
        String[] eventos = Res.getStringArray(R.array.desciption_eventos);
        String[] latitud = Res.getStringArray(R.array.latitud);
        String[] longitud = Res.getStringArray(R.array.longitud);

        ArrayList<Municipio> municipios = new ArrayList<>();

        for (int i = 0; i < name.length; i++){
            Municipio municipio = new Municipio();
            municipio.Name = name[i];
            municipio.Description = description[i];
            municipio.Evento = eventos[i];
            municipio.img = img[i];
            municipio.Sitio = sitio[i];
            municipio.Latitud = latitud[i];
            municipio.Longitud = longitud[i];
            municipios.add(municipio);
        }

        return municipios;
    }

    public Municipio getMunicipio(int posicion){
        ArrayList<Municipio> municipios =  getMunicipios();
        return municipios.get(posicion);
    }
}
