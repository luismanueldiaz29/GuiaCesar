package com.example.guiavalledupar.Services;

import android.content.Context;

import com.example.guiavalledupar.Entity.Actividad;
import com.example.guiavalledupar.Repository.ActividadRepository;

import java.util.ArrayList;

public class ActividadService {
    private Actividad actividad;
    private ActividadRepository repository;
    public ActividadService(Context context){
        repository=new ActividadRepository(context);
    }
    public ArrayList<Actividad> getActividades(){ return repository.getActividades(); }
    public Actividad getActividad(int posicion){ return repository.getActividad(posicion); }
}
