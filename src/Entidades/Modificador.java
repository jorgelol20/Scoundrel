package Entidades;

import java.util.ArrayList;
import java.util.HashMap;
import JuegoQuest.Juego;
import JuegoQuest.Juego.*;
import Menus.Main;

import javax.swing.*;

public class Modificador {
    public enum TipoModificador {
        BUFF, DEBUFF
    }
    public TipoModificador tipoModificador;
    public String nombre;
    public String descripcion;
    public String icono;
    public int id;
    public static ArrayList<Modificador> modificadores = new ArrayList<Modificador>();
    public Modificador(TipoModificador tipo, String nombre, String descripcion, String icono, int id) {
        this.tipoModificador = TipoModificador.BUFF;
    }
    public static void cargarModificadores(){
        //Más vida máxima
        modificadores.add(new Modificador(TipoModificador.BUFF,"Más Vida I","Te da vida (5) extra durante el resto de la partida.",null,0));
        modificadores.add(new Modificador(TipoModificador.BUFF,"Más Vida II","Te da vida (10) extra durante el resto de la partida.",null,1));
        modificadores.add(new Modificador(TipoModificador.BUFF,"Más Vida III","Te da vida (15) extra durante el resto de la partida.",null,2));
    }
    public void aplicarModificador(Juego juego) {
        System.out.println(id);
        switch (id){
            case 1:
                juego.vidaMaxima += 5;
                juego.vidas += 5;
                break;
            case 2:
                juego.vidaMaxima += 10;
                juego.vidas += 10;
                break;
            case 3:
                juego.vidaMaxima += 15;
                juego.vidas += 15;
                break;
            default:
                break;
        }
        Main.frame.setContentPane(juego.mainPanel);
    }
    public static Modificador obtenerModificador(int numModificador) {
        return modificadores.get(numModificador);
    }
}
