package JuegoQuest.Funciones;

import Entidades.Carta;
import Entidades.Modificador;
import JuegoQuest.Juego.SonidosJuego;
import JuegoQuest.Juego;

import javax.swing.*;

public class FuncionesJuego {
    public static void funcionAtaque(Juego juego, Carta cartaArmaSeleccionada, boolean enemigoMuyFuerte, Carta cartaEnemigo){
        boolean efectoFatiga = false;
        if (juego.fatiga){
            int numAleatorio = (int) (Math.random() * 10);
            if (numAleatorio == 1){
                efectoFatiga = true;
            }
        }
        int danyoEnemigo = calcularDanyo(cartaEnemigo, juego);
        int danyoArma = 0;
        if (cartaArmaSeleccionada != null){
            danyoArma = calcularDanyo(cartaArmaSeleccionada, juego);
        }
        if (efectoFatiga || cartaArmaSeleccionada == null || (enemigoMuyFuerte && cartaEnemigo.getValorCarta().valor >= juego.ultimoEnemigoCarta.getValorCarta().valor)) {
            juego.vidas -= danyoEnemigo;
            if (efectoFatiga){
                juego.textoLogs += "La fatiga te hizo fallar el ataque y recibiste " + danyoEnemigo + "de daño\n";
            }else{
                juego.textoLogs += "Recibiste " + danyoEnemigo + " de puro pecho\n";
            }
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
                if (juego.chupacabras){
                    juego.vidas++;
                }
            }
        }
        if (cartaEnemigo.getNombreCarta().contains("ReyPica") && juego.questDracula) {
            Modificador.questDracula(juego);
        }if (cartaEnemigo.getNombreCarta().contains("AsPica") && juego.questDragon) {
            Modificador.questDragon(juego);
        }if (cartaEnemigo.getNombreCarta().contains("CincoTrebol") && juego.questSans) {
            Modificador.questSans(juego);
        }
        if (juego.pentakill){
            juego.contadorPentakill++;
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
        if (juego.pentakill){
            juego.danyoExtraArmas -= (juego.contadorPentakill / 5) * 5;
            String icono = "src/resources/sprites/modificadores/PentakillPequeno.png";
            switch (juego.posicionModPentakill){
                case 1:
                    juego.mod1.setIcon(new ImageIcon(icono));
                    break;
                case 2:
                    juego.mod2.setIcon(new ImageIcon(icono));
                    break;
                case 3:
                    juego.mod3.setIcon(new ImageIcon(icono));
                    break;
                case 4:
                    juego.mod4.setIcon(new ImageIcon(icono));
                    break;
                case 5:
                    juego.mod5.setIcon(new ImageIcon(icono));
                    break;
                case 6:
                    juego.mod6.setIcon(new ImageIcon(icono));
                    break;
                case 7:
                    juego.mod7.setIcon(new ImageIcon(icono));
                    break;
                case 8:
                    juego.mod8.setIcon(new ImageIcon(icono));
                    break;
                case 9:
                    juego.mod9.setIcon(new ImageIcon(icono));
                    break;
                case 10:
                    juego.mod10.setIcon(new ImageIcon(icono));
                    break;
                default:
                    break;
            }
        }
        juego.contadorPentakill = 0;
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
        if (juego.pentakill){
            juego.danyoExtraArmas -= (juego.contadorPentakill / 5) * 5;
            String icono = "src/resources/sprites/modificadores/PentakillPequeno.png";
            switch (juego.posicionModPentakill){
                case 1:
                    juego.mod1.setIcon(new ImageIcon(icono));
                    break;
                case 2:
                    juego.mod2.setIcon(new ImageIcon(icono));
                    break;
                case 3:
                    juego.mod3.setIcon(new ImageIcon(icono));
                    break;
                case 4:
                    juego.mod4.setIcon(new ImageIcon(icono));
                    break;
                case 5:
                    juego.mod5.setIcon(new ImageIcon(icono));
                    break;
                case 6:
                    juego.mod6.setIcon(new ImageIcon(icono));
                    break;
                case 7:
                    juego.mod7.setIcon(new ImageIcon(icono));
                    break;
                case 8:
                    juego.mod8.setIcon(new ImageIcon(icono));
                    break;
                case 9:
                    juego.mod9.setIcon(new ImageIcon(icono));
                    break;
                case 10:
                    juego.mod10.setIcon(new ImageIcon(icono));
                    break;
                default:
                    break;
            }
        }
        juego.contadorPentakill = 0;
        new FuncionSonido(Juego.SonidosJuego.GirarCarta).reproducirSonido();
    }
    private static int calcularDanyo(Carta carta, Juego juego){
        boolean criticoEfecto = false;
        if (juego.criticoActivado){
            int numeroAleatorio = 0;
            if (carta.getPaloCarta() == Carta.Palo.Diamante) {
                numeroAleatorio = (int) Math.ceil(Math.random() * (2 - 1) + 1);
                if (numeroAleatorio == 2){
                    criticoEfecto = true;
                }
            }else{
                numeroAleatorio = (int) Math.ceil(Math.random() * (4 - 1) + 1);
                if (numeroAleatorio == 4){
                    criticoEfecto = true;
                }
            }
        }
        if (carta.getPaloCarta() == Carta.Palo.Diamante){
            if (criticoEfecto){
                return (int) ((carta.getValorCarta().valor + juego.danyoExtraArmas) * 2);
            }else {
                return (carta.getValorCarta().valor + juego.danyoExtraArmas);
            }
        }else if (carta.getPaloCarta() == Carta.Palo.Pica){
            if (criticoEfecto){
                return  (int)((carta.getValorCarta().valor + juego.danyoExtraPicas) * 1.5);
            }else{
                return (carta.getValorCarta().valor + juego.danyoExtraPicas);
            }
        }else{
            if (criticoEfecto){
                return (int)((carta.getValorCarta().valor + juego.danyoExtraTreboles) * 1.5);
            }else{
                return (carta.getValorCarta().valor + juego.danyoExtraTreboles);
            }
        }
    }
}
