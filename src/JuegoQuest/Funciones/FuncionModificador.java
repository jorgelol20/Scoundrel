package JuegoQuest.Funciones;

import Entidades.Modificador;
import Entidades.Modificador.TipoModificador;
import JuegoQuest.Juego;
import JuegoQuest.Juego.*;
import java.util.ArrayList;

public class FuncionModificador {
    private Modificador modificador;
    public FuncionModificador(Modificador modificador) {
        this.modificador = modificador;
    }
    public static void aplicarModificador(ArrayList<Modificador> modificadores, Juego juego) {
        for (Modificador modificador : modificadores) {
            modificador.aplicarModificador(juego);
        }
    }
}
