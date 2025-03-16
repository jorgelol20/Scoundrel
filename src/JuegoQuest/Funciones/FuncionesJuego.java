package JuegoQuest.Funciones;

import Entidades.Carta;
import Entidades.Modificador;
import JuegoQuest.Juego.SonidosJuego;
import JuegoQuest.Juego;

import javax.swing.*;

public class FuncionesJuego {
    public static void funcionAtaque(Juego juego, Carta cartaArmaSeleccionada, boolean enemigoMuyFuerte, Carta cartaEnemigo){
        int danyoEnemigo = calcularDanyo(cartaEnemigo, juego);
        int danyoArma = 0;
        if (cartaArmaSeleccionada != null){
            danyoArma = calcularDanyo(cartaArmaSeleccionada, juego);
        }
        if (cartaArmaSeleccionada == null || (enemigoMuyFuerte && cartaEnemigo.getValorCarta().valor >= juego.ultimoEnemigoCarta.getValorCarta().valor)) {
            juego.vidas -= danyoEnemigo;
            juego.textoLogs += "Recibiste " + danyoEnemigo + " de puro pecho\n";
            juego.ultimoEnemigoAsimiladoLabel.setIcon(new ImageIcon(cartaEnemigo.imagenCarta));
            juego.ultimoEnemigoAsimilado = cartaEnemigo;
        } else {
            if ((danyoEnemigo - danyoArma) > 0) {
                juego.vidas -= danyoEnemigo - danyoArma;
                juego.textoLogs += "Te atacó " + cartaEnemigo.getNombreCarta() + " pero \nte defendiste con "
                        + cartaArmaSeleccionada.getNombreCarta() + "\ny solo recibiste " +
                        (danyoEnemigo - danyoArma)+" de daño\n";
                juego.ultimoEnemigoCarta = cartaEnemigo;
                juego.ultimoEnemigo.setIcon(new ImageIcon(cartaEnemigo.imagenCarta));
            } else if ((danyoEnemigo - danyoArma) <= 0) {
                juego.ultimoEnemigoCarta = cartaEnemigo;
                juego.ultimoEnemigo.setIcon(new ImageIcon(cartaEnemigo.imagenCarta));
                juego.textoLogs += "Te atacó " + cartaEnemigo.getNombreCarta() + " pero te defendiste \ncon "
                        + cartaArmaSeleccionada.getNombreCarta() + " y no \nrecibiste daño\n";
            }
        }
        if (cartaEnemigo.getNombreCarta().contains("ReyPica") && juego.questDracula) {
            Modificador.questDracula(juego);
        }if (cartaEnemigo.getNombreCarta().contains("AsPica") && juego.questDragon) {
            Modificador.questDragon(juego);
        }if (cartaEnemigo.getNombreCarta().contains("CuatroPica") && juego.questSans) {
            Modificador.questSans(juego);
        }
        new FuncionSonido(Juego.SonidosJuego.GirarCarta).reproducirSonido();
    }
    public static void funcionCurar(Juego juego, Carta cartaCuracion){
        boolean gastroEnteritisEfecto = false;
        if (juego.gastroenteritis){
            int numeroAleatorio = (int) Math.ceil(Math.random() * (4 - 1)+1);
            if (numeroAleatorio == 4){
                gastroEnteritisEfecto = true;
            }
        }
        if (!gastroEnteritisEfecto && (juego.metabolismoRapido || (juego.curacionDisponible && juego.vidaMaxima != juego.vidas && cartaCuracion.getValorCarta().valor + juego.efectoExtraCuracion > 0))) {
            juego.vidas += cartaCuracion.getValorCarta().valor + juego.efectoExtraCuracion;
            juego.textoLogs += "Te curaste "+ (cartaCuracion.getValorCarta().valor+juego.efectoExtraCuracion)+"\n";
        }else if (!gastroEnteritisEfecto){
            juego.textoLogs += "No te curaste y tiraste la poción\n";
        }else{
            juego.textoLogs += "Vomitaste la comida y no te curaste\n";
        }
        juego.curacionDisponible = false;

        new FuncionSonido(Juego.SonidosJuego.GirarCarta).reproducirSonido();
    }
    public static void funcionArma(Juego juego, Carta cartaArma){
        juego.cartaArmaSeleccionadaLabel.setIcon(new ImageIcon(cartaArma.imagenCarta));
        juego.cartaArmaSeleccionada = cartaArma;
        juego.textoLogs += "Arma seleccionada: " + juego.cartaArmaSeleccionada.getNombreCarta()+"\n";
        juego.ultimoEnemigoCarta = null;
        juego.ultimoEnemigo.setIcon(null);
        juego.ultimoEnemigoAsimilado = null;
        juego.ultimoEnemigoAsimiladoLabel.setIcon(null);
        juego.enemigoMuyFuerte = false;
        new FuncionSonido(Juego.SonidosJuego.GirarCarta).reproducirSonido();
    }
    private static int calcularDanyo(Carta carta, Juego juego){
        if (carta.getPaloCarta() == Carta.Palo.Diamante){
            return (carta.getValorCarta().valor + juego.danyoExtraArmas);
        }else if (carta.getPaloCarta() == Carta.Palo.Pica){
            return  (carta.getValorCarta().valor + juego.danyoExtraPicas);
        }else{
            return (carta.getValorCarta().valor + juego.danyoExtraTreboles);
        }
    }
}
