package JuegoQuest.Funciones;

import Entidades.Carta;
import JuegoQuest.Juego.SonidosJuego;
import JuegoQuest.Juego;

import javax.swing.*;

public class FuncionesJuego {
    public static void funcionAtaque(Juego juego, Carta cartaArmaSeleccionada, boolean enemigoMuyFuerte, Carta cartaEnemigo, JButton cartaBoton){
        int danyoTotal = calcularDanyo(cartaEnemigo, juego);
        if (cartaArmaSeleccionada == null || (enemigoMuyFuerte && cartaEnemigo.getValorCarta().valor >= juego.ultimoEnemigoCarta.getValorCarta().valor)) {
            juego.vidas -= danyoTotal;
            juego.textoLogs += "Recibiste " + danyoTotal + " de puro pecho\n";
            juego.ultimoEnemigoAsimiladoLabel.setIcon(cartaBoton.getIcon());
            juego.ultimoEnemigoAsimilado = cartaEnemigo;
        } else {
            if ((danyoTotal - cartaArmaSeleccionada.getValorCarta().valor) > 0) {
                juego.vidas -= danyoTotal - cartaArmaSeleccionada.getValorCarta().valor;
                juego.textoLogs += "Te atacó " + cartaEnemigo.getNombreCarta() + " pero \nte defendiste con "
                        + cartaArmaSeleccionada.getNombreCarta() + "\ny solo recibiste " +
                        (danyoTotal - cartaArmaSeleccionada.getValorCarta().valor)+" de daño\n";
                juego.ultimoEnemigoCarta = cartaEnemigo;
                juego.ultimoEnemigo.setIcon(cartaBoton.getIcon());
            } else if ((danyoTotal - juego.cartaArmaSeleccionada.getValorCarta().valor) <= 0) {
                juego.ultimoEnemigoCarta = cartaEnemigo;
                juego.ultimoEnemigo.setIcon(cartaBoton.getIcon());
                juego.textoLogs += "Te atacó " + cartaEnemigo.getNombreCarta() + " pero te defendiste \ncon "
                        + cartaArmaSeleccionada.getNombreCarta() + " y no \nrecibiste daño\n ";
            }
        }
        new FuncionSonido(Juego.SonidosJuego.GirarCarta).reproducirSonido();
    }
    public static void funcionCurar(Juego juego, Carta cartaCuracion){
        if (juego.curacionDisponible && juego.vidaMaxima != juego.vidas) {
            juego.vidas += cartaCuracion.getValorCarta().valor;
            juego.textoLogs += "Te curaste "+ cartaCuracion.getValorCarta().valor+"\n";
        }else{
            juego.textoLogs += "No te curaste y tiraste la poción \n";
        }
        juego.curacionDisponible = false;

        new FuncionSonido(Juego.SonidosJuego.GirarCarta).reproducirSonido();
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
        new FuncionSonido(Juego.SonidosJuego.GirarCarta).reproducirSonido();
    }
    private static int calcularDanyo(Carta enemigo, Juego juego){
        if (enemigo.getPaloCarta() == Carta.Palo.Pica){
            return  (enemigo.getValorCarta().valor + juego.danyoExtraPicas)*juego.multiplicadorDanyoPicas;
        }else{
            return (enemigo.getValorCarta().valor + juego.danyoExtraTreboles)*juego.multiplicadorDanyoTreboles;
        }
    }
}
