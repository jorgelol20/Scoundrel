package JuegoQuest.Funciones;
import JuegoQuest.Juego;

import static JuegoQuest.Funciones.FuncionesJuego.*;

public class FuncionBoton4 {
    public static void funcionBoton(Juego juego){
        if (juego.carta4.getNombreCarta().contains("Diamante")) {
            funcionArma(juego, juego.carta4Boton,juego.carta4);
        } else if (juego.carta4.getNombreCarta().contains("Pica") || juego.carta4.getNombreCarta().contains("Trebol")) {
            funcionAtaque(juego, juego.cartaArmaSeleccionada, juego.enemigoMuyFuerte, juego.carta4, juego.carta4Boton);
        } else if (juego.carta4.getNombreCarta().contains("Corazon")) {
            funcionCurar(juego, juego.carta4);
        }
        moverCartas(juego);
    }
    private static void moverCartas(Juego juego){
        juego.carta4Boton.setIcon(null);
        juego.carta4Boton.setSelectedIcon(null);
        juego.carta4Boton.setPressedIcon(null);
        juego.carta4Boton.setRolloverIcon(null);
        juego.carta4 = null;
    }
}
