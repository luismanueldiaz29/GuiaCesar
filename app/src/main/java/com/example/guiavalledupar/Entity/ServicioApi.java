package com.example.guiavalledupar.Entity;

public class ServicioApi {
    public String name;
    public String direction;
    public String phone;
    public String municipio;
    public static String jsonName="";
    public static String jsonDirection="";
    public static String jsonPhone="";
    public static String URL="";
    public int tipo;
    public static final int HOTEL=1;
    public static final int HOSPITAL=2;
    public static String getURLSpecial(String muni){
        return URL+"?municipio="+muni;
    }
}