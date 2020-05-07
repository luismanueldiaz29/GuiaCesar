package com.example.guiavalledupar.Services;

import com.example.guiavalledupar.Entity.SiteOfInterest;
import com.example.guiavalledupar.Repository.SiteRepository;

import java.util.ArrayList;

public class SitioService {
    SiteRepository repository;

    public SitioService(){
        repository =new SiteRepository();
    }

    public int getImg(int position){ return repository.getSiteArray().get((position)).image; }

    public String getNombre(int position){ return repository.getSiteArray().get(position).name; }

    public ArrayList<SiteOfInterest> getArraySitios() {
        return repository.getSiteArray();
    }

    public int getId(int position){ return repository.getSiteArray().get(position).id; }
    public int getSize(){ return repository.getSiteArray().size(); }
    public SiteOfInterest getSite(int id){
        ArrayList<SiteOfInterest> Sitios=getArraySitios();
        for (SiteOfInterest e:  Sitios ){
            if(e.id==id){
                return e;
            }
        }
        return null;
    }

}
