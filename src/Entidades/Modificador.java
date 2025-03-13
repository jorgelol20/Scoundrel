package Entidades;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import JuegoQuest.Funciones.FuncionActualizar;
import JuegoQuest.Juego;
import JuegoQuest.Juego.*;
import Menus.Main;

import javax.swing.*;

public class Modificador {
    public Modificador(Modificador modificadorOriginal) {
        this.tipoModificador = modificadorOriginal.tipoModificador;
        this.nombre = modificadorOriginal.nombre;
        this.descripcion = modificadorOriginal.descripcion;
        this.icono = modificadorOriginal.icono;
        this.id = modificadorOriginal.id;
    }

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
        this.tipoModificador = tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.icono = icono;
        this.id = id;
    }
    public static void cargarModificadores(){
        //Más vida máxima
        modificadores.add(new Modificador(TipoModificador.BUFF,"Más Vida I","Te da vida (5) extra durante el resto de la partida.",null,0));
        modificadores.add(new Modificador(TipoModificador.BUFF,"Más Vida II","Te da vida (10) extra durante el resto de la partida.",null,1));
        modificadores.add(new Modificador(TipoModificador.BUFF,"Más Vida III","Te da vida (15) extra durante el resto de la partida.",null,2));
        modificadores.add(new Modificador(TipoModificador.DEBUFF, "Corten las flores I", "Trébol -1 daño, Picas +1 daño", null,3));
        modificadores.add(new Modificador(TipoModificador.DEBUFF, "Corten las flores II", "Trébol -2 daño, Picas +1 daño", null,4));
        modificadores.add(new Modificador(TipoModificador.DEBUFF, "Corten las flores III", "Trébol -3 daño, Picas +1 daño", null,5));
        modificadores.add(new Modificador(TipoModificador.DEBUFF,"Que le corten la cabeza I","Pica -1 daño, Trébol +1 daño",null,6));
        modificadores.add(new Modificador(TipoModificador.DEBUFF,"Que le corten la cabeza II","Pica -2 daño, Trébol +1 daño",null,7));
        modificadores.add(new Modificador(TipoModificador.DEBUFF,"Que le corten la cabeza III","Pica -3 daño, Trébol +1 daño",null,8));
    }
    public static void aplicarModificador(Modificador modificador,Juego juego) {
        switch (modificador.id){
            case 0:
                juego.vidaMaxima += 5;
                juego.vidas += 5;
                break;
            case 1:
                juego.vidaMaxima += 10;
                juego.vidas += 10;
                break;
            case 2:
                juego.vidaMaxima += 15;
                juego.vidas += 15;
                break;
            case 3:
                juego.danyoExtraTreboles -= 1;
                juego.danyoExtraPicas += 1;
                break;
            case 4:
                juego.danyoExtraPicas += 1;
                juego.danyoExtraTreboles -= 2;
                break;
            case 5:
                juego.danyoExtraPicas += 1;
                juego.danyoExtraTreboles -= 3;
                break;
            case 6:
                juego.danyoExtraPicas -= 1;
                juego.danyoExtraTreboles += 1;
                break;
            case 7:
                juego.danyoExtraPicas -= 2;
                juego.danyoExtraTreboles += 1;
                break;
            case 8:
                juego.danyoExtraPicas -= 3;
                juego.danyoExtraTreboles += 1;
                break;
            default:
                break;
        }
        FuncionActualizar.comprobarVidas(juego);
    }
    public static Modificador obtenerModificador() {
        ArrayList<Modificador> modificadorAleatorio = modificadores;
        Collections.shuffle(modificadorAleatorio);
        Modificador modificador = modificadorAleatorio.getFirst();
        modificadores.remove(modificador);
        return modificador;
    }
}
