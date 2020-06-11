package com.example.guiavalledupar.Repository;

import android.content.Context;
import android.content.res.Resources;

import com.example.guiavalledupar.Entity.Restaurante;
import com.example.guiavalledupar.R;

import java.util.ArrayList;

public class RestauranteRepository {
    private Context context;

    public RestauranteRepository(Context context){
        this.context = context;
    }

    public ArrayList<Restaurante> GetRestaurantes(int Posicion){

        ArrayList<Restaurante> restaurantes = new ArrayList<Restaurante>();

        switch (Posicion){
            case 0:
                restaurantes = GetChivoAsado();
            break;
        }

        return restaurantes;
    }

    public ArrayList<Restaurante> GetChivoAsado(){
        Resources Res = this.context.getResources();
        String NameRestaurante[] = Res.getStringArray(R.array.restaurante_name_chivo_Asado);
        String DireccionRestaurante[] = Res.getStringArray(R.array.restaurante_chivo_asado_direccion);
        String HorarioRestaurante[] = Res.getStringArray(R.array.restaurante_horario_chivo_asado);
        String LatitudRestaurante[] = Res.getStringArray(R.array.restaurante_latitud_chivo_Asado);
        String LongitudRestaurante[] = Res.getStringArray(R.array.restaurante_longitud_chivo_Asado);

        ArrayList<Restaurante> restaurantes = new ArrayList<Restaurante>();

        for (int i = 0; i < NameRestaurante.length; i++){
            Restaurante restaurante = new Restaurante();

            restaurante.Name = NameRestaurante[i];
            restaurante.Direccion = DireccionRestaurante[i];
            restaurante.Horario = HorarioRestaurante[i];
            restaurante.Longitud = Double.parseDouble(LongitudRestaurante[i]);
            restaurante.Latitud = Double.parseDouble(LatitudRestaurante[i]);

            restaurantes.add(restaurante);
        }

        return restaurantes;
    }
}
