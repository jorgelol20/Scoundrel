package Entidades;

import java.util.ArrayList;
import java.util.Collections;

import JuegoQuest.Funciones.FuncionActualizar;
import JuegoQuest.Juego;

import javax.swing.*;

public class Modificador {
    public TipoModificador tipoModificador;
    public String nombre;
    public String descripcion;
    public String icono;
    public String icono16;
    public int id;
    public JLabel labelModificador;
    public static ArrayList<Modificador> modificadores = new ArrayList<Modificador>();
    public Modificador(Modificador modificadorOriginal) {
        this.tipoModificador = modificadorOriginal.tipoModificador;
        this.nombre = modificadorOriginal.nombre;
        this.descripcion = modificadorOriginal.descripcion;
        this.icono = modificadorOriginal.icono;
        this.id = modificadorOriginal.id;
    }

    public enum TipoModificador {
        BUFF, DEBUFF, QUEST
    }

    public Modificador(TipoModificador tipo, String nombre, String descripcion, String icono, int id) {
        this.tipoModificador = tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.icono = icono;
        this.id = id;

    }
    public static void cargarModificadores(){
        //Más vida máxima
        modificadores.add(new Modificador(TipoModificador.BUFF,"Más Vida I","Te da vida (5) extra durante el resto de la partida.","src/resources/sprites/modificadores/MasVida1.png",0));
        modificadores.add(new Modificador(TipoModificador.BUFF,"Más Vida II","Te da vida (10) extra durante el resto de la partida.","src/resources/sprites/modificadores/MasVida2.png",1));
        modificadores.add(new Modificador(TipoModificador.BUFF,"Más Vida III","Te da vida (15) extra durante el resto de la partida.","src/resources/sprites/modificadores/MasVida3.png",2));
        //Debuff tréboles
        modificadores.add(new Modificador(TipoModificador.DEBUFF, "Corten las flores I", "Trébol -1 daño, Picas +1 daño", null,3));
        modificadores.add(new Modificador(TipoModificador.DEBUFF, "Corten las flores II", "Trébol -2 daño, Picas +1 daño", null,4));
        modificadores.add(new Modificador(TipoModificador.DEBUFF, "Corten las flores III", "Trébol -3 daño, Picas +1 daño",null,5));
        //Debuff picas
        modificadores.add(new Modificador(TipoModificador.DEBUFF,"Que le corten la cabeza I","Pica -1 daño, Trébol +1 daño", null,6));
        modificadores.add(new Modificador(TipoModificador.DEBUFF,"Que le corten la cabeza II","Pica -2 daño, Trébol +1 daño", null,7));
        modificadores.add(new Modificador(TipoModificador.DEBUFF,"Que le corten la cabeza III","Pica -3 daño, Trébol +1 daño", null,8));
        //Castelvania
        modificadores.add(new Modificador(TipoModificador.DEBUFF, "¿Castelvania?", "Hasta matar al ReyPica, curaciones -1 (Mejora al matar)",null,9));
    }
    public static void aplicarModificador(Modificador modificador,Juego juego) {
        switch (modificador.id){
            case 0:
                juego.vidaMaxima += 5;
                juego.vidas += 5;
                modificador.icono16 = "src/resources/sprites/modificadores/MasVida1Pequeno.png";
                break;
            case 1:
                juego.vidaMaxima += 10;
                juego.vidas += 10;
                modificador.icono16 = "src/resources/sprites/modificadores/MasVida2Pequeno.png";
                break;
            case 2:
                juego.vidaMaxima += 15;
                juego.vidas += 15;
                modificador.icono16 = "src/resources/sprites/modificadores/MasVida3Pequeno.png";
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
            case 9:
                juego.efectoExtraCuracion -= 1;
                juego.questDracula = true;
            default:
                break;
        }
        setIconoModificador(modificador,juego);
        FuncionActualizar.comprobarVidas(juego);
    }
    public static Modificador obtenerModificador() {
        ArrayList<Modificador> modificadorAleatorio = modificadores;
        Collections.shuffle(modificadorAleatorio);
        Modificador modificador = modificadorAleatorio.getFirst();
        modificadores.remove(modificador);
        return modificador;
    }
    public static void setIconoModificador(Modificador modificador, Juego juego) {
        if(modificador.nombre.contains("Castelvania")){
            juego.posicionModDracula = juego.contadorModificador;
        }
        switch (juego.contadorModificador){
            case 1:
                juego.mod1.setIcon(new ImageIcon("src/resources/sprites/modificadores/MasVida1Pequeno.png"));
                juego.mod1.setToolTipText(modificador.nombre);
                break;
            case 2:
                juego.mod2.setIcon(new ImageIcon("src/resources/sprites/modificadores/MasVida2Pequeno.png"));
                juego.mod2.setToolTipText(modificador.nombre);
                break;
            case 3:
                juego.mod3.setIcon(new ImageIcon("src/resources/sprites/modificadores/MasVida3Pequeno.png"));
                juego.mod3.setToolTipText(modificador.nombre);
                break;
            case 4:
                juego.mod4.setIcon(new ImageIcon(modificador.icono));
                juego.mod4.setToolTipText(modificador.nombre);
                break;
            case 5:
                juego.mod5.setIcon(new ImageIcon(modificador.icono));
                juego.mod5.setToolTipText(modificador.nombre);
                break;
            case 6:
                juego.mod6.setIcon(new ImageIcon(modificador.icono));
                juego.mod6.setToolTipText(modificador.nombre);
                break;
            case 7:
                juego.mod7.setIcon(new ImageIcon(modificador.icono));
                juego.mod7.setToolTipText(modificador.nombre);
                break;
            case 8:
                juego.mod8.setIcon(new ImageIcon(modificador.icono));
                juego.mod8.setToolTipText(modificador.nombre);
                break;
            case 9:
                juego.mod9.setIcon(new ImageIcon(modificador.icono));
                juego.mod9.setToolTipText(modificador.nombre);
                break;
            case 10:
                juego.mod10.setIcon(new ImageIcon(modificador.icono));
                juego.mod10.setToolTipText(modificador.nombre);
                break;
            default:
                break;
        }
        juego.contadorModificador++;
    }
    public static void questDracula(Juego juego){
        juego.efectoExtraCuracion += 4;
        switch (juego.posicionModDracula){
            case 1:
                juego.mod1.setIcon(new ImageIcon("src/resources/sprites/modificadores/MasVida1Pequeno.png"));
                juego.mod1.setToolTipText("Fin del terror");
                break;
            case 2:
                juego.mod2.setIcon(new ImageIcon("src/resources/sprites/modificadores/MasVida2Pequeno.png"));
                juego.mod2.setToolTipText("Fin del terror");
                break;
            case 3:
                juego.mod3.setIcon(new ImageIcon("src/resources/sprites/modificadores/MasVida3Pequeno.png"));
                juego.mod3.setToolTipText("Fin del terror");
                break;
            case 4:
                juego.mod4.setIcon(new ImageIcon());
                juego.mod4.setToolTipText("Fin del terror");
                break;
            case 5:
                juego.mod5.setIcon(new ImageIcon());
                juego.mod5.setToolTipText("Fin del terror");
                break;
            case 6:
                juego.mod6.setIcon(new ImageIcon());
                juego.mod6.setToolTipText("Fin del terror");
                break;
            case 7:
                juego.mod7.setIcon(new ImageIcon());
                juego.mod7.setToolTipText("Fin del terror");
                break;
            case 8:
                juego.mod8.setIcon(new ImageIcon());
                juego.mod8.setToolTipText("Fin del terror");
                break;
            case 9:
                juego.mod9.setIcon(new ImageIcon());
                juego.mod9.setToolTipText("Fin del terror");
                break;
            case 10:
                juego.mod10.setIcon(new ImageIcon());
                juego.mod10.setToolTipText("Fin del terror");
                break;
            default:
                break;
        }
    }
}
