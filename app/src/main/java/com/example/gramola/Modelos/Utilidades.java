package com.example.gramola.Modelos;


import static android.os.Build.VERSION_CODES.R;

import com.example.gramola.R;

import java.util.ArrayList;

public class Utilidades {
    public static ArrayList<Album>albList=new ArrayList<>();

    static{

        albList.add(new Album(2,"La Voz","Héctor Lavoe",1975,"La voz es el título del álbum debut de estudio en la carrera como solista grabado por el cantautor puertorriqueño-estadounidense Héctor Lavoe, se grabó en Good Vibrations Sound Studios en 1440 Broadway, en la ciudad de Nueva York en el año 1974 como álbum de estudio y fue lanzado en 1975 por el sello Fania Records. \n  ", com.example.gramola.R.drawable.hector));
        albList.add(new Album(3,"Master of puppets","Metallica",1986,"Master of Puppets es el tercer álbum de estudio del grupo musical de thrash metal estadounidense Metallica. Fue lanzado al mercado el 3 de marzo de 1986, bajo el sello discográfico Elektra Records, alcanzando el puesto 29 en el Billboard 200. El álbum fue el primer disco de oro de la banda tras vender 500.000 copias en Estados Unidos, aunque luego superaría las 6 millones ", com.example.gramola.R.drawable.metalicared));
        albList.add(new Album(4,"Illmatic","Nas",1994,"Illmatic es el álbum de debut del rapero estadounidense Nas, lanzado el 19 de abril de 1994 por Columbia Records. Después de firmar con el sello con la ayuda de MC Serch, Nas grabó el álbum en 1992-1993 en Chung King Studios, Battery Studios, y Unique Recording Studios en Nueva York. Su producción estuvo a cargo de Nas, Large Professor, Pete Rock, Q-Tip, L.E.S., y DJ Premier. Diseñado como un álbum de hardcore hip hop, Illmatic cuenta con rimas internas de varias sílabas y narraciones basadas en las experiencias de Nas en las viviendas públicas de Queensbridge, Nueva York.", com.example.gramola.R.drawable.nas));
        albList.add(new Album(5,"La Leyenda del Tiempo","Camarón de la Isla",1979,"La leyenda del tiempo es el décimo álbum de estudio del cantaor español Camarón de la Isla, publicado el 16 de junio de 1979 por PolyGram. Está considerada una de las obras más importantes de la historia del flamenco.Un disco revolucionario, que espantó en un primer momento a los puristas, para posteriormente ser considerado un clásico. No solo por la osadía de Camarón de incorporar elementos como el bajo eléctrico,sino también por la calidad de los participantes: Tomatito, Raimundo Amador, Kiko Veneno, bajo la producción de Ricardo Pachón.", com.example.gramola.R.drawable.camaron));
        albList.add(new Album(6,"Odisea en el Lodo","SFDK",2001,"es el tercer disco del grupo de rap sevillano SFDK. Llegaron a vender 15.000 copias y recorrieron la mayoría de capitales españolas con gran acogida por parte del público. Hablando con un criterio objetivo, siempre se ha dicho que este ha sido el mejor disco de SFDK y uno de los mejores de la historia del rap en español", com.example.gramola.R.drawable.sfdk));
        albList.add(new Album(7,"A.D.R.O.M.I.C.F.M.S","Yung Beef",2013,"Yung Beef lanzó el 6 de diciembre del 2013, su primer álbum: A.D.R.O.M.I.C.F.M.S. producido completamente por Steve Lean. El nombre es un acrónimo de ‘All Diz Ratchets On Me I Can't Feel Ma Soul’. Un álbum con el sonido trap y cloud rap que caracterizaba a los Kefta Boyz, con una estética Vaporwave de donde saldría uno de los mayores clásicos de Yung Beef, su «Intro A.D.R.O.M.I.C.F.M.S.» que lo catapultó al estrellato acumulando casi 16 millones de visitas en YouTube, hasta que la plataforma borró el videoclip. La canción fue considerada una de las 30 mejores canciones del 2014 por la revista Rolling Stone", com.example.gramola.R.drawable.yungbeef));
        albList.add(new Album(8,"Demasiados enemigos","Eskorbuto",1991,"Demasiados enemigos es el sexto álbum de estudio del grupo punk español Eskorbuto. También es el último publicado con la formación clásica de Eskorbuto con Iosu Expósito, Juanma Suárez y Pako Galán. Se publicó a finales de 1991, a través del sello Matraka Diskak y contiene 11 canciones, de los cuales una de ellas era inédita de estudio: \"No quiero cambiar", com.example.gramola.R.drawable.eskorbuto));
        albList.add(new Album(9,"Legend","Bob Marley and the Wailers ",1984,"Es el álbum más vendido de la historia del reggae, aunque existe cierta controversia a causa de que sólo se incluyen canciones de la etapa final de la carrera del jamaicano, sin atender a sus primeras grabaciones. Tras 35 años de haber salido a la venta en 1984 registra más de 25 millones de copias vendidas a nivel mundial.", com.example.gramola.R.drawable.marley));
    }


    public static ArrayList<Album> getAlbumlist(){
        return albList;
    }


        }



