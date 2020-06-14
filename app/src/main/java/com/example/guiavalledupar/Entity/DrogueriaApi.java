package com.example.guiavalledupar.Entity;

public class DrogueriaApi extends ServicioApi {
    public static String URL="https://www.datos.gov.co/resource/32rd-kkaa.json";
    public static String jsonName="nombre_establecimiento";
    public static String jsonDirection="direccion";
    public static String jsonPhone="telefono";
    public static String jsonMuni="municipo";

    public static String getURLSpecial(String muni){
        return URL+"?"+jsonMuni+"="+muni+"";
    }
}
