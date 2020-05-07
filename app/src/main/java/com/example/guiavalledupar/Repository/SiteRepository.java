package com.example.guiavalledupar.Repository;

import com.example.guiavalledupar.Entity.SiteOfInterest;
import com.example.guiavalledupar.R;

import java.util.ArrayList;

public class SiteRepository {

    ArrayList<SiteOfInterest> siteArray;
    public SiteRepository() {
        siteArray = new ArrayList<SiteOfInterest>();
        generateMockData();
    }

    public ArrayList<SiteOfInterest> getSiteArray() {
        return siteArray;
    }

    public void generateMockData(){
        SiteOfInterest site= new SiteOfInterest();
        site.image =R.drawable.glorietadelosgallos;
        site.id=111;
        site.name ="Glorieta de los gallos";
        site.linkInformation ="https://elpilon.com.co/los-gallos-evocan-una-tradicion-cultural/";
        site.linkMap ="https://www.google.com/maps/place/Glorieta+Los+Gallos/@10.4670597,-73.2568375,18z/data=!4m5!3m4!1s0x8e8ab9c6df3d2b79:0x1563d0787f53fa0d!8m2!3d10.4671599!4d-73.2560328";
        site.description ="Valiéndose del hierro, acero y bronce, la escultora bogotana Elma Pignalosa creó en Valledupar el " +
                "monumento Los Gallos, ubicado en la intersección de la avenida Simón Bolívar con la transversal 16C." +
                "Esta obra escultórica representa una de las tradiciones de la región como lo es la riña de gallo fino," +
                " actividad representativa en épocas de jolgorio y tradicionalmente en cualquier concentración popular.";
        siteArray.add(site);
        SiteOfInterest site2= new SiteOfInterest();
        site2.image = R.drawable.glorietamusicos;
        site2.id=222;
        site2.name ="Glorieta de los musicos";
        site2.linkInformation ="https://elpilon.com.co/los-musicos-un-homenaje-al-folclor/";
        site2.linkMap ="https://www.google.com/maps/place/Glorieta+De+Los+M%C3%BAsicos/@10.4650575,-73.2534895,18z/data=!4m5!3m4!1s0x8e8ab9bf58549001:0x68e8c3aefc01d5a4!8m2!3d10.4650628!4d-73.2527707";
        site2.description ="Con el fin de recordar y representar la tradicional música vallenata, que se caracteriza por instrumentos" +
                " representativos como caja, guacharaca y acordeón, el escultor Jorge Maestre creó el monumento Homenaje al Folclor Vallenato." +
                "La escultura, en la que se representan a tres integrantes de un conjunto típico de música vallenata," +
                " se suma a las tantas obras creadas por este hijo natal que ha plasmado en diferentes monumentos imágenes representativas" +
                " de personajes y elementos de esta tierra caribeña." +
                " Situada en la diagonal 23 con avenida Simón Bolívar, la también llamada glorieta de ‘Los músicos’," +
                " es una imagen muy llamativa al ojo humano, que hace referencia a tres hombres sentados sobre una base redonda, espalda con " +
                "espalda tocando los diferentes instrumentos musicales. Los tres personajes aparecen con pantalones remangados hasta la rodilla y sin camisas.";
        siteArray.add(site2);
        SiteOfInterest site3= new SiteOfInterest();
        site3.image =R.drawable.glorietajuglares;
        site3.id=333;
        site3.name ="Glorieta de los juglares";
        site3.linkInformation ="";
        site3.linkMap ="https://www.google.com/maps/place/Glorieta+de+Los+Juglares/@10.5004141,-73.2679648,3a,75y," +
                "90t/data=!4m8!1m2!2m1!1sglorietas+valledupar!3m4!1s0x8e8ab8239ee7fa71:0x8d1c30ad5c5c3b76!8m2!3d10." +
                "5004141!4d-73.2679648?hl=es";
        site3.description ="la glorieta de Los Juglares, donde se rinde homenaje a figuras del folclor vallenato.";
        siteArray.add(site3);

        SiteOfInterest site4= new SiteOfInterest();
        site4.image=R.drawable.glorietamariamulata;
        site4.id=444;
        site4.name="Glorieta de la Maria Mulata";
        site4.linkInformation="https://elpilon.com.co/misterios-de-la-maria-mulata/";
        site4.linkMap="https://www.google.com/maps/place/" +
                "Glorieta+Maria+Mulata/@10.4691482,-73.2567478,19z/" +
                "data=!4m5!3m4!1s0x8e8ab9c65bdf4f33:0xcfdb2dd07a91ea50!8m2!3d10.4691689!4d-73.2568882";
        site4.description="Un pájaro negro de enormes proporciones representado en hierro por las manos" +
                " del extinto escultor y pintor cartagenero Enrique Grau aparece imponente en una de las " +
                "glorietas de Valledupar. Se trata del monumento de ‘La María Mulata’ o ‘María Mulata mirando arriba’" +
                " (así como la concibió su autor).";
        siteArray.add(site4);

        SiteOfInterest site5= new SiteOfInterest();
        site5.image=R.drawable.glorietapedazoacordeon;
        site5.id=5555;
        site5.name="Glorieta mi Pedazo de Acordeon";
        site5.linkInformation="https://elpilon.com.co/mi-pedazo-de-acordeon-la-exaltacion-al-juglar-alejo-duran/";
        site5.linkMap="https://www.google.com/maps/place/Glorieta+Pedazo+de+Acordeon/@10.4905618,-73.264966,19z/" +
                "data=!4m5!3m4!1s0x8e8ab82e2ee7cac3:0xce51179a6106b7f8!8m2!3d10.4905066!4d-73.2652138";
        site5.description="Plasmando una de las canciones de Alejandro ‘Alejo’ Durán," +
                " primer rey  del Festival de la Leyenda Vallenata, que lleva por nombre " +
                "‘Mi Pedazo de Acordeón’, fue creado uno de los monumentos ubicado en la avenida " +
                "Hurtado de la capital del Cesar.La obra de seis metros de alto, 10 metros de largo " +
                "y 4.5 metros de ancho, diseñada con hierro, bronce fosforado, bruñido y ensamblado se " +
                "propuso rendir un homenaje al acordeonero, cantor y compositor oriundo del municipio de El Paso," +
                " inmortalizando a los juglares de la música del acordeón, caja y guacharaca.";
        siteArray.add(site5);

        SiteOfInterest site6= new SiteOfInterest();
        site6.id=66;
        site6.image=R.drawable.glorietapiloneramayor;
        site6.name="Glorieta Pilonera Mayor";
        site6.linkInformation="https://panoramacultural.com.co/turismo/279/la-pilonera-mayor-de-la-controversia-a-la-consagracion";
        site6.linkMap="https://www.google.com/maps/place/Glorieta+La+Pilonera+Mayor/" +
                "@10.4968809,-73.2700783,18z/data=!4m5!3m4!1s0x0:0x956a2d574804cf64!8m2!3d10.4968043!4d-73.2689827";
        site6.description="Entrando a Valledupar por el puente Hurtado, la Pilonera Mayor es uno de los grandes " +
                "símbolos que acogen al visitante. A pocos metros del Parque de la Leyenda, la estatua da vida a una" +
                " de las rotondas más espaciosas y bonitas de la ciudad. Un lugar recomendado para tomarse una foto y " +
                "compartir la grandeza del foclor vallenato. Inaugurada el 18 de marzo del 2010, el monumento rinde homenaje" +
                " a la “La Cacica” Consuelo Araujonoguera (la gran impulsora del Festival de la Leyenda Vallenata) y también a " +
                "las primeras bailadores del pilón vallenato.";
        siteArray.add(site6);
    }

}
