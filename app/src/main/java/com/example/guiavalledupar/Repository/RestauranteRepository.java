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
            case 0: restaurantes = GetChivoAsado(); break;
            case 1: restaurantes = GetResAsada(); break;
            case 2: restaurantes = GetArrozCoco(); break;
            case 3: restaurantes = GetSancocho(); break;
            case 4: restaurantes = GetViudaPescado(); break;
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
        String TelefonoRestaurante[] = Res.getStringArray(R.array.restaurane_chivo_asado_telefono);
        String PaginaRestaurante[] = Res.getStringArray(R.array.restaurante_red_social_chivo_asado);

        ArrayList<Restaurante> restaurantes = new ArrayList<Restaurante>();

        for (int i = 0; i < NameRestaurante.length; i++){
            Restaurante restaurante = new Restaurante();

            restaurante.Name = NameRestaurante[i];
            restaurante.Direccion = DireccionRestaurante[i];
            restaurante.Horario = HorarioRestaurante[i];
            restaurante.Longitud = Double.parseDouble(LongitudRestaurante[i]);
            restaurante.Latitud = Double.parseDouble(LatitudRestaurante[i]);
            restaurante.Telefono = TelefonoRestaurante[i];
            restaurante.SitioUrl = PaginaRestaurante[i];

            restaurantes.add(restaurante);
        }

        return restaurantes;
    }

    public ArrayList<Restaurante> GetSancocho(){
        Resources Res = this.context.getResources();
        String NameRestaurante[] = Res.getStringArray(R.array.restaurante_name_sancocho);
        String DireccionRestaurante[] = Res.getStringArray(R.array.restaurante_sancocho_direccion);
        String HorarioRestaurante[] = Res.getStringArray(R.array.restaurante_horario_sancocho);
        String LatitudRestaurante[] = Res.getStringArray(R.array.restaurante_latitud_sancocho);
        String LongitudRestaurante[] = Res.getStringArray(R.array.restaurante_longitud_sancocho);
        String TelefonoRestaurante[] = Res.getStringArray(R.array.restaurane_sancocho_telefono);
        String PaginaRestaurante[] = Res.getStringArray(R.array.restaurante_red_social_sancocho);

        ArrayList<Restaurante> restaurantes = new ArrayList<Restaurante>();

        for (int i = 0; i < NameRestaurante.length; i++){
            Restaurante restaurante = new Restaurante();

            restaurante.Name = NameRestaurante[i];
            restaurante.Direccion = DireccionRestaurante[i];
            restaurante.Horario = HorarioRestaurante[i];
            restaurante.Longitud = Double.parseDouble(LongitudRestaurante[i]);
            restaurante.Latitud = Double.parseDouble(LatitudRestaurante[i]);
            restaurante.Telefono = TelefonoRestaurante[i];
            restaurante.SitioUrl = PaginaRestaurante[i];
            restaurantes.add(restaurante);
        }

        return restaurantes;
    }

    public ArrayList<Restaurante> GetResAsada(){
        Resources Res = this.context.getResources();
        String NameRestaurante[] = Res.getStringArray(R.array.restaurante_name_carne_res_asada);
        String DireccionRestaurante[] = Res.getStringArray(R.array.restaurante_sancocho_direccion);
        String HorarioRestaurante[] = Res.getStringArray(R.array.restaurante_horario_carne_res_asado);
        String LatitudRestaurante[] = Res.getStringArray(R.array.restaurante_latitud_carne_res_asado);
        String LongitudRestaurante[] = Res.getStringArray(R.array.restaurante_longitud_carne_res_asado);
        String TelefonoRestaurante[] = Res.getStringArray(R.array.restaurane_carne_res_asado_telefono);
        String PaginaRestaurante[] = Res.getStringArray(R.array.restaurante_red_social_carne_res_asada);
        ArrayList<Restaurante> restaurantes = new ArrayList<Restaurante>();

        for (int i = 0; i < NameRestaurante.length; i++){
            Restaurante restaurante = new Restaurante();

            restaurante.Name = NameRestaurante[i];
            restaurante.Direccion = DireccionRestaurante[i];
            restaurante.Horario = HorarioRestaurante[i];
            restaurante.Longitud = Double.parseDouble(LongitudRestaurante[i]);
            restaurante.Latitud = Double.parseDouble(LatitudRestaurante[i]);
            restaurante.Telefono = TelefonoRestaurante[i];
            restaurante.SitioUrl = PaginaRestaurante[i];
            restaurantes.add(restaurante);
        }

        return restaurantes;
    }

    public ArrayList<Restaurante> GetArrozCoco(){
        Resources Res = this.context.getResources();
        String NameRestaurante[] = Res.getStringArray(R.array.restaurante_name_arroz_coco);
        String DireccionRestaurante[] = Res.getStringArray(R.array.restaurante_arroz_coco_direccion);
        String HorarioRestaurante[] = Res.getStringArray(R.array.restaurante_horario_arroz_coco);
        String LatitudRestaurante[] = Res.getStringArray(R.array.restaurante_latitud_arroz_coco);
        String LongitudRestaurante[] = Res.getStringArray(R.array.restaurante_longitud_arroz_coco);
        String TelefonoRestaurante[] = Res.getStringArray(R.array.restaurane_arroz_coco_telefono);
        String PaginaRestaurante[] = Res.getStringArray(R.array.restaurante_red_social_arroz_coco);
        ArrayList<Restaurante> restaurantes = new ArrayList<Restaurante>();

        for (int i = 0; i < NameRestaurante.length; i++){
            Restaurante restaurante = new Restaurante();

            restaurante.Name = NameRestaurante[i];
            restaurante.Direccion = DireccionRestaurante[i];
            restaurante.Horario = HorarioRestaurante[i];
            restaurante.Longitud = Double.parseDouble(LongitudRestaurante[i]);
            restaurante.Latitud = Double.parseDouble(LatitudRestaurante[i]);
            restaurante.Telefono = TelefonoRestaurante[i];
            restaurante.SitioUrl = PaginaRestaurante[i];
            restaurantes.add(restaurante);
        }

        return restaurantes;
    }

    public ArrayList<Restaurante> GetViudaPescado(){
        Resources Res = this.context.getResources();
        String NameRestaurante[] = Res.getStringArray(R.array.restaurante_name_viuda_pescado);
        String DireccionRestaurante[] = Res.getStringArray(R.array.restaurant_viuda_pescado_direccion);
        String HorarioRestaurante[] = Res.getStringArray(R.array.restaurante_horario_viuda_pescado);
        String LatitudRestaurante[] = Res.getStringArray(R.array.restaurante_latitud_viuda_pescado);
        String LongitudRestaurante[] = Res.getStringArray(R.array.restaurante_longitud_viuda_pescado);
        String TelefonoRestaurante[] = Res.getStringArray(R.array.restaurane_viuda_pescado_telefono);
        String PaginaRestaurante[] = Res.getStringArray(R.array.restaurante_red_social_viuda_pescado);
        ArrayList<Restaurante> restaurantes = new ArrayList<Restaurante>();

        for (int i = 0; i < NameRestaurante.length; i++){
            Restaurante restaurante = new Restaurante();

            restaurante.Name = NameRestaurante[i];
            restaurante.Direccion = DireccionRestaurante[i];
            restaurante.Horario = HorarioRestaurante[i];
            restaurante.Longitud = Double.parseDouble(LongitudRestaurante[i]);
            restaurante.Latitud = Double.parseDouble(LatitudRestaurante[i]);
            restaurante.Telefono = TelefonoRestaurante[i];
            restaurante.SitioUrl = PaginaRestaurante[i];
            restaurantes.add(restaurante);
        }

        return restaurantes;
    }
}
