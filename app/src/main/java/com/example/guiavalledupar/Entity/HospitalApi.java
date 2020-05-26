package com.example.guiavalledupar.Entity;

public class HospitalApi {
    public static String URL="https://www.datos.gov.co/resource/q2qp-usbt.json";
    public String name;
    public String direction;
    public String phone;
    public String municipio;

    public static String getURLSpecial(String muni){
        return URL+"?municipio="+muni;
         }
}
