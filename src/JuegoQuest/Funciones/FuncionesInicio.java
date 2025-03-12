package JuegoQuest.Funciones;

import Entidades.Carta;
import Entidades.Modificador;
import JuegoQuest.Juego;
import Menus.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

import static JuegoQuest.Juego.*;

public class FuncionesInicio {
    public static void crearBaraja(Juego juego) {
        for (Carta.Palo palo : Carta.Palo.values()) {
            for (Carta.Valor carta : Carta.Valor.values()) {
                cartasMazo.add(new Carta(palo, carta));
            }
        }
        Juego.cartasMazo.removeIf(carta -> ((carta.getPaloCarta() == Carta.Palo.Corazon && (carta.getValorCarta() == Carta.Valor.As || carta.getValorCarta() == Carta.Valor.Reina || carta.getValorCarta() == Carta.Valor.Rey || carta.getValorCarta() == Carta.Valor.Sota))) || ((carta.getPaloCarta() == Carta.Palo.Diamante && (carta.getValorCarta() == Carta.Valor.As || carta.getValorCarta() == Carta.Valor.Reina || carta.getValorCarta() == Carta.Valor.Rey || carta.getValorCarta() == Carta.Valor.Sota))));
        Collections.shuffle(Juego.cartasMazo);
    }
}
