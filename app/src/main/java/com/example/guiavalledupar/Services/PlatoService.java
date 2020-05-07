package com.example.guiavalledupar.Services;

import android.content.Context;

import com.example.guiavalledupar.Entity.Plato;
import com.example.guiavalledupar.Repository.PlatoRepository;

import java.util.ArrayList;
import java.util.List;

public class PlatoService {

    private Plato Plato;
    private PlatoRepository PlatoRepository;

    public PlatoService(Context context){
        PlatoRepository = new PlatoRepository(context);
    }

    public ArrayList<Plato> getPlatos(){
        return PlatoRepository.getPlatos();
    }
}
