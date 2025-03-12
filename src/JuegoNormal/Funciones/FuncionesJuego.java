package JuegoNormal.Funciones;

import Entidades.Carta;
import JuegoNormal.Juego;
import JuegoNormal.Juego.*;


import javax.swing.*;

public class FuncionesJuego {
    public static void funcionAtaque(Juego juego, Carta cartaArmaSeleccionada, boolean enemigoMuyFuerte, Carta cartaEnemigo, JButton cartaBoton){
        if (cartaArmaSeleccionada == null || (enemigoMuyFuerte && cartaEnemigo.getValorCarta().valor >= juego.ultimoEnemigoCarta.getValorCarta().valor)) {
            juego.vidas -= cartaEnemigo.getValorCarta().valor;
            juego.textoLogs += "Recibiste " + cartaEnemigo.getValorCarta().valor + " de puro pecho\n";
            juego.ultimoEnemigoAsimiladoLabel.setIcon(cartaBoton.getIcon());
        } else {
            if ((cartaEnemigo.getValorCarta().valor - cartaArmaSeleccionada.getValorCarta().valor) > 0) {
                juego.vidas -= cartaEnemigo.getValorCarta().valor - cartaArmaSeleccionada.getValorCarta().valor;
                juego.textoLogs += "Te atacó " + cartaEnemigo.getNombreCarta() + " pero \nte defendiste con "
                        + cartaArmaSeleccionada.getNombreCarta() + "\ny solo recibiste " +
                        (cartaEnemigo.getValorCarta().valor - cartaArmaSeleccionada.getValorCarta().valor)+" de daño\n";
                juego.ultimoEnemigoCarta = cartaEnemigo;
                juego.ultimoEnemigo.setIcon(cartaBoton.getIcon());
            } else if ((cartaEnemigo.getValorCarta().valor - juego.cartaArmaSeleccionada.getValorCarta().valor) <= 0) {
                juego.ultimoEnemigoCarta = cartaEnemigo;
                juego.ultimoEnemigo.setIcon(cartaBoton.getIcon());
                juego.textoLogs += "Te atacó " + cartaEnemigo.getNombreCarta() + " pero te defendiste \ncon "
                        + cartaArmaSeleccionada.getNombreCarta() + " y no \nrecibiste daño\n ";
            }
        }
        new FuncionSonido(SonidosJuego.GirarCarta).reproducirSonido();
    }
    public static void funcionCurar(Juego juego, Carta cartaCuracion){
        System.out.println(juego.curacionDisponible);
        if (juego.curacionDisponible && juego.vidas != 20) {
            juego.vidas += cartaCuracion.getValorCarta().valor;
            juego.textoLogs += "Te curaste "+ cartaCuracion.getValorCarta().valor+"\n";
        }else{
            juego.textoLogs += "No te curaste y tiraste la poción \n";
        }
        juego.curacionDisponible = false;

        new FuncionSonido(SonidosJuego.GirarCarta).reproducirSonido();
    }
    public static void funcionArma(Juego juego, JButton cartaBoton, Carta cartaArma){
        juego.cartaArmaSeleccionadaLabel.setIcon(cartaBoton.getIcon());
        juego.cartaArmaSeleccionada = cartaArma;
        juego.textoLogs += "Arma seleccionada: " + juego.cartaArmaSeleccionada.getNombreCarta()+"\n";
        juego.ultimoEnemigoCarta = null;
        juego.ultimoEnemigo.setIcon(null);
        juego.ultimoEnemigoAsimilado = null;
        juego.ultimoEnemigoAsimiladoLabel.setIcon(null);
        juego.enemigoMuyFuerte = false;
        new FuncionSonido(SonidosJuego.GirarCarta).reproducirSonido();
    }
}
