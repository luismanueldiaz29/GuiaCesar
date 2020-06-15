package com.example.guiavalledupar.Entity;

public class ServiceApi {
    public String name;
    public String direction;
    public String phone;
    public String municipio;
    public Boolean Expandable;

    public static String jsonName="";
    public static String jsonDirection="";
    public static String jsonPhone="";
    public static String URL="";
    public int tipo;
    public static final int HOTEL=1;
    public static final int HOSPITAL=2;
    public static final int DROGUERIA=3;
    public String getStringTipo(){
        switch(tipo){
            case 1:return"HOTEL";
            case 2:return"HOSPITAL";
            case 3:return "DROGUERIA";
        }
        return "";
    }
    public static String getURLSpecial(String muni){
        return URL+"?municipio="+muni;
    }
}