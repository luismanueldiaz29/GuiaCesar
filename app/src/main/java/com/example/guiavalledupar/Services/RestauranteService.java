package com.example.guiavalledupar.Services;

import android.content.Context;

import com.example.guiavalledupar.Entity.Restaurante;
import com.example.guiavalledupar.Repository.PlatoRepository;
import com.example.guiavalledupar.Repository.RestauranteRepository;

import java.util.ArrayList;

public class RestauranteService {

    private RestauranteRepository restauranteRepository;

    public RestauranteService(Context context){
        restauranteRepository = new RestauranteRepository(context);
    }

    public ArrayList<Restaurante> GetRestaurantes(int Posicion){
        return restauranteRepository.GetRestaurantes(Posicion);
    }

}
