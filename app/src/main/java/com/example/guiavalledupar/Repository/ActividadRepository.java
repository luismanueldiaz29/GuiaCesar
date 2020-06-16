package com.example.guiavalledupar.Repository;

import android.content.Context;
import android.content.res.Resources;

import com.example.guiavalledupar.Entity.Actividad;
import com.example.guiavalledupar.R;

import java.util.ArrayList;

public class ActividadRepository {
    private Context context;
    public ActividadRepository(Context context){
        this.context = context;
    }

    public ArrayList<Actividad> getActividades(){

        Resources Res = this.context.getResources();
        String[] name = Res.getStringArray(R.array.name_actividad);
        String[] description = Res.getStringArray(R.array.description_actividad);
        int[] img = {R.drawable.parapente,R.drawable.senderismo,R.drawable.avistamiento,R.drawable.ciclomontanismo};

        ArrayList<Actividad> actividades = new ArrayList<>();

        for (int i = 0; i < name.length; i++){
            Actividad actividad = new Actividad();
            actividad.Name = name[i];
            actividad.Description = description[i];
            actividad.Image = img[i];
            actividades.add(actividad);
        }

        return actividades;
    }
    public Actividad getActividad(int posicion){

        ArrayList<Actividad> actividades =  getActividades();
        return actividades.get(posicion);
    }
}

