package JuegoQuest.Funciones;
import JuegoNormal.Funciones.FuncionActualizar;
import JuegoQuest.Juego;
import static JuegoQuest.Funciones.FuncionesJuego.*;

public class FuncionBoton1 {
    public static void funcionBoton(Juego juego) {
        if (juego.carta1.getNombreCarta().contains("Diamante")) {
            funcionArma(juego, juego.carta1Boton,juego.carta1);
        } else if (juego.carta1.getNombreCarta().contains("Pica") || juego.carta1.getNombreCarta().contains("Trebol")) {
            funcionAtaque(juego, juego.cartaArmaSeleccionada, juego.enemigoMuyFuerte, juego.enemigoActual, juego.carta1Boton);
        } else if (juego.carta1.getNombreCarta().contains("Corazon")) {
            funcionCurar(juego, juego.carta1);
        }
        moverCartas(juego);
        juego.funcionActualizar.actualizaciones(juego);
    }

    private static void moverCartas(Juego juego){
        juego.carta1Boton.setIcon(juego.carta2Boton.getIcon());
        juego.carta1Boton.setSelectedIcon(juego.carta2Boton.getSelectedIcon());
        juego.carta1Boton.setPressedIcon(juego.carta2Boton.getPressedIcon());
        juego.carta1Boton.setRolloverIcon(juego.carta2Boton.getRolloverIcon());
        juego.carta1 = juego.carta2;
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
