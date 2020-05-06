package com.example.guiavalledupar.Repository;

import com.example.guiavalledupar.Entity.SitioDeInteres;
import com.example.guiavalledupar.R;

import java.util.ArrayList;

public class RepositorioSitio {

    ArrayList<SitioDeInteres> arraySitios;
    public RepositorioSitio() {
        arraySitios = new ArrayList<SitioDeInteres>();
        generarSitiosDePrueba();
    }

    public ArrayList<SitioDeInteres> getArraySitios() {
        return arraySitios;
    }

    public void generarSitiosDePrueba(){
        SitioDeInteres sitio= new SitioDeInteres();
        sitio.imagen=R.drawable.glorietadelosgallos;
        sitio.nombre="Glorieta de los gallos";
        sitio.linkInformacion="https://elpilon.com.co/los-gallos-evocan-una-tradicion-cultural/";
        sitio.linkMapa="https://www.google.com/maps/place/Glorieta+Los+Gallos/@10.4670597,-73.2568375,18z/data=!4m5!3m4!1s0x8e8ab9c6df3d2b79:0x1563d0787f53fa0d!8m2!3d10.4671599!4d-73.2560328";
        sitio.descripcion="Valiéndose del hierro, acero y bronce, la escultora bogotana Elma Pignalosa creó en Valledupar el " +
                "monumento Los Gallos, ubicado en la intersección de la avenida Simón Bolívar con la transversal 16C." +
                "Esta obra escultórica representa una de las tradiciones de la región como lo es la riña de gallo fino," +
                " actividad representativa en épocas de jolgorio y tradicionalmente en cualquier concentración popular.";
        arraySitios.add(sitio);
        SitioDeInteres sitio2= new SitioDeInteres();
        sitio2.imagen= R.drawable.glorietamusicos;
        sitio2.nombre="Glorieta de los musicos";
        sitio2.linkInformacion="https://elpilon.com.co/los-musicos-un-homenaje-al-folclor/";
        sitio2.linkMapa="https://www.google.com/maps/place/Glorieta+De+Los+M%C3%BAsicos/@10.4650575,-73.2534895,18z/data=!4m5!3m4!1s0x8e8ab9bf58549001:0x68e8c3aefc01d5a4!8m2!3d10.4650628!4d-73.2527707";
        sitio2.descripcion="Con el fin de recordar y representar la tradicional música vallenata, que se caracteriza por instrumentos" +
                " representativos como caja, guacharaca y acordeón, el escultor Jorge Maestre creó el monumento Homenaje al Folclor Vallenato." +
                "La escultura, en la que se representan a tres integrantes de un conjunto típico de música vallenata," +
                " se suma a las tantas obras creadas por este hijo natal que ha plasmado en diferentes monumentos imágenes representativas" +
                " de personajes y elementos de esta tierra caribeña." +
                " Situada en la diagonal 23 con avenida Simón Bolívar, la también llamada glorieta de ‘Los músicos’," +
                " es una imagen muy llamativa al ojo humano, que hace referencia a tres hombres sentados sobre una base redonda, espalda con " +
                "espalda tocando los diferentes instrumentos musicales. Los tres personajes aparecen con pantalones remangados hasta la rodilla y sin camisas.";
        arraySitios.add(sitio2);
        SitioDeInteres sitio3= new SitioDeInteres();
        sitio3.imagen=R.drawable.glorietajuglares;
        sitio3.nombre="Glorieta de los juglares";
        sitio3.linkInformacion="";
        sitio3.linkMapa="https://www.google.com/maps/place/Glorieta+de+Los+Juglares/@10.5004141,-73.2679648,3a,75y," +
                "90t/data=!4m8!1m2!2m1!1sglorietas+valledupar!3m4!1s0x8e8ab8239ee7fa71:0x8d1c30ad5c5c3b76!8m2!3d10." +
                "5004141!4d-73.2679648?hl=es";
        sitio3.descripcion="la glorieta de Los Juglares, donde se rinde homenaje a figuras del folclor vallenato.";
        arraySitios.add(sitio3);
    }

}
