package com.example.guiavalledupar.Services;

import com.example.guiavalledupar.Entity.SitioDeInteres;
import com.example.guiavalledupar.Repository.RepositorioSitio;

import java.util.ArrayList;

public class SitiosServicio {
    RepositorioSitio repositorio;

    public SitiosServicio(){
        repositorio =new RepositorioSitio();
    }

    public int getImg(int position){ return repositorio.getArraySitios().get((position)).imagen; }

    public String getNombre(int position){ return repositorio.getArraySitios().get(position).nombre; }

    public ArrayList<SitioDeInteres> getArraySitios() {
        return repositorio.getArraySitios();
    }

    public int getSize(){ return repositorio.getArraySitios().size(); }

}
