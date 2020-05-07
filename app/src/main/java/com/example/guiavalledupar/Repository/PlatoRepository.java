package com.example.guiavalledupar.Repository;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.guiavalledupar.Entity.Plato;
import com.example.guiavalledupar.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class PlatoRepository {

    //private Plato Plato;
    private Context context;
    public PlatoRepository(Context context){
        this.context = context;
    }

    public ArrayList<Plato> getPlatos(){

        Resources Res = this.context.getResources();
        String[] name = Res.getStringArray(R.array.name_plato);
        String[] description = Res.getStringArray(R.array.description_plato);
        int[] img = {R.drawable.lapaz,R.drawable.lapaz,R.drawable.lapaz,R.drawable.lapaz,R.drawable.lapaz};
        ArrayList<Plato> platos = new ArrayList<>();

        ListIterator<Plato> platoListIterator;
        for (int i = 0; i < name.length; i++){
            Plato Plato = new Plato();
            Plato.Name = name[i];
            Plato.Description = description[i];
            Plato.Image = img[i];
            platos.add(Plato);

            Toast.makeText(this.context, Plato.Name+"plato y name "+name.length+" numero"+platos.size(), Toast.LENGTH_LONG).show();
        }

        return platos;
    }
}