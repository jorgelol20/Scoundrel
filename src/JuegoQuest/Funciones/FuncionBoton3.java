package JuegoQuest.Funciones;
import JuegoQuest.Juego;

import static JuegoQuest.Funciones.FuncionesJuego.*;

public class FuncionBoton3{
    public static void funcionBoton(Juego juego){
        if (juego.carta3.getNombreCarta().contains("Diamante")) {
            funcionArma(juego,juego.carta3);
        } else if (juego.carta3.getNombreCarta().contains("Pica") || juego.carta3.getNombreCarta().contains("Trebol")) {
            funcionAtaque(juego, juego.cartaArmaSeleccionada, juego.enemigoMuyFuerte, juego.carta3);
        } else if (juego.carta3.getNombreCarta().contains("Corazon")) {
            funcionCurar(juego, juego.carta3);
        }
        moverCartas(juego);
        juego.funcionActualizar.actualizaciones(juego);
    }

    private static void moverCartas(Juego juego){
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
