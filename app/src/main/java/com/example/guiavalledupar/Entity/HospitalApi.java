package com.example.guiavalledupar.Entity;

public class HospitalApi extends ServicioApi {
    public static String URL="https://www.datos.gov.co/resource/q2qp-usbt.json";
    public static String jsonName="nombre_del_prestador";
    public static String jsonDirection="direccion";
    public static String jsonPhone="tel_fono";
    public static String jsonMuni="municipio";

    public static String getURLSpecial(String muni){
        return URL+"?"+jsonMuni+"="+muni+"";
    }
}