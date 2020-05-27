package com.example.guiavalledupar.Entity;

public class HotelApi extends ServicioApi {
    public static String URL="https://www.datos.gov.co/resource/87gw-ij3v.json";//esta salen empresas turisticas"
    public static String jsonName="nombre";
    public static String jsonDirection="direccion_comercial";
    public static String jsonPhone="telefono_celular";
    public static String jsonMuni="municipio_id";
    public static String getURLSpecial(String muni){
        return URL+"?"+jsonMuni+"="+muni+"";
    }
}
