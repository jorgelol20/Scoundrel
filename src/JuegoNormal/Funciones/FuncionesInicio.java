package JuegoNormal.Funciones;
import static JuegoNormal.Juego.*;
import Entidades.Carta;
import JuegoNormal.Juego;

import java.util.Collections;

public class FuncionesInicio {
    public static void crearBaraja() {
        for (Carta.Palo palo : Carta.Palo.values()) {
            for (Carta.Valor carta : Carta.Valor.values()) {
                cartasMazo.add(new Carta(palo, carta));
            }
        }
        Juego.cartasMazo.removeIf(carta -> ((carta.getPaloCarta() == Carta.Palo.Corazon && (carta.getValorCarta() == Carta.Valor.As || carta.getValorCarta() == Carta.Valor.Reina || carta.getValorCarta() == Carta.Valor.Rey || carta.getValorCarta() == Carta.Valor.Sota))) || ((carta.getPaloCarta() == Carta.Palo.Diamante && (carta.getValorCarta() == Carta.Valor.As || carta.getValorCarta() == Carta.Valor.Reina || carta.getValorCarta() == Carta.Valor.Rey || carta.getValorCarta() == Carta.Valor.Sota))));
        Collections.shuffle(Juego.cartasMazo);

    }

    public static String cargarImagenes(Carta carta) {
        return "src/resources/sprites/cartas/"+carta.getValorCarta()+carta.getPaloCarta()+".png";
    }
    public static String cargarImagenesSeleccion(Carta carta) {
        return "src/resources/sprites/cartas/"+carta.getValorCarta()+carta.getPaloCarta()+"Seleccionado.png";
    }


}
