package com.example.guiavalledupar.Services;

import android.content.Context;

import com.example.guiavalledupar.Entity.Municipio;
import com.example.guiavalledupar.Entity.Plato;
import com.example.guiavalledupar.Repository.MunicipioRepository;

import java.util.ArrayList;

public class MunicipioService {

    private MunicipioRepository municipioRepository;
    public MunicipioService(Context context){
        this.municipioRepository = new MunicipioRepository(context);
    }

    public ArrayList<Municipio> getMunicipios(){
        return municipioRepository.getMunicipios();
    }

    public Municipio getMunicipio(int posicion){
        return municipioRepository.getMunicipio(posicion);
    }

}
