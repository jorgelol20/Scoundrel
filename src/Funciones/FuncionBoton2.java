package Funciones;

import JuegoPrincipal.Juego;

import static Funciones.FuncionesJuego.*;
import static JuegoPrincipal.Juego.*;

public class FuncionBoton2 {
    public static void funcionBoton(Juego juego){
        if (juego.carta2.getNombreCarta().contains("Diamante")) {
            funcionArma(juego, juego.carta2Boton,juego.carta2);
        } else if (juego.carta2.getNombreCarta().contains("Pica") || juego.carta2.getNombreCarta().contains("Trebol")) {
            funcionAtaque(juego, juego.cartaArmaSeleccionada, juego.enemigoMuyFuerte, juego.carta2, juego.carta2Boton);
        } else if (juego.carta2.getNombreCarta().contains("Corazon")) {
            funcionCurar(juego, juego.carta2);
        }
        moverCartas(juego);
    }
    private static void moverCartas(Juego juego){
        juego.carta2Boton.setIcon(juego.carta3Boton.getIcon());
        juego.carta2Boton.setSelectedIcon(juego.carta3Boton.getSelectedIcon());
        juego.carta2Boton.setPressedIcon(juego.carta3Boton.getPressedIcon());
        juego.carta2Boton.setRolloverIcon(juego.carta3Boton.getRolloverIcon());
        juego.carta2 = juego.carta3;
        juego.carta3Boton.setIcon(juego.carta4Boton.getIcon());
        juego.carta3Boton.setSelectedIcon(juego.carta4Boton.getSelectedIcon());
        juego.carta3Boton.setPressedIcon(juego.carta4Boton.getPressedIcon());
        juego.carta3Boton.setRolloverIcon(juego.carta4Boton.getRolloverIcon());
        juego.carta3 = juego.carta4;
        juego.carta4Boton.setIcon(null);
        juego.carta4Boton.setSelectedIcon(null);
        juego.carta4Boton.setPressedIcon(null);
        juego.carta4Boton.setRolloverIcon(null);
        juego.carta4 = null;
    }
}
