package JuegoNormal;

import JuegoNormal.Funciones.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import JuegoNormal.Funciones.FuncionActualizar;
import Entidades.Carta;
import Menus.Main;

public class Juego extends JFrame {
    private FuncionActualizar funcionActualizar = new FuncionActualizar();
    public JPanel mainPanel;
    public static ArrayList<Carta> cartasMazo = new ArrayList<Carta>();
    public JLabel mazo;
    private Carta cartaSeleccionada;
    public JLabel cartaArmaSeleccionadaLabel;
    public Carta cartaArmaSeleccionada;
    public JButton carta1Boton;
    public Carta carta1;
    public JButton carta2Boton;
    public Carta carta2;
    public JButton carta3Boton;
    public Carta carta3;
    public JButton carta4Boton;
    public Carta carta4;
    public JLabel cartasRestantes;
    public int numCartasRestantes;
    public JButton botonHuir;
    public JButton botonAccion;
    public JLabel numVida;
    public JLabel corazon;
    public JLabel ultimoEnemigo;
    public Carta ultimoEnemigoCarta;
    public Carta enemigoActual;
    public boolean enemigoMuyFuerte = false;
    public int vidas = 20;
    public boolean curacionDisponible = true;
    public JTextArea log;
    public JLabel ultimoEnemigoAsimiladoLabel;
    public Carta ultimoEnemigoAsimilado;
    public String textoLogs = "";
    public boolean victoria = false;
    public boolean juegoNormal = true;

    public Juego() {
        Main.frame.setContentPane(mainPanel);
        FuncionesInicio.crearBaraja();
        obtener4Cartas();
        funcionActualizar.actualizaciones(this);
        carta1Boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (carta1.getNombreCarta().contains("Diamante")) {
                    botonAccion.setIcon(new ImageIcon(iconosBoton.ElegirArma.iconosBoton));
                    botonAccion.setRolloverIcon(new ImageIcon(iconosBoton.ElegirArmaSeleccionado.iconosBoton));
                } else if (carta1.getNombreCarta().contains("Pica") || carta1.getNombreCarta().contains("Trebol")) {
                    botonAccion.setIcon(new ImageIcon(iconosBoton.Atacar.iconosBoton));
                    if (cartaArmaSeleccionada != null) {
                        enemigoActual = carta1;
                        comprobarEnemigo();
                    } else {
                        botonAccion.setRolloverIcon(new ImageIcon(iconosBoton.AtacarSinArma.iconosBoton));
                    }
                } else if (carta1.getNombreCarta().contains("Corazon")) {
                    botonAccion.setIcon(new ImageIcon(iconosBoton.Curarse.iconosBoton));
                    if (curacionDisponible) {
                        botonAccion.setRolloverIcon(new ImageIcon(iconosBoton.CurarseSeleccionado.iconosBoton));
                    } else {
                        botonAccion.setRolloverIcon(new ImageIcon(iconosBoton.Descartar.iconosBoton));
                    }
                }
                cartaSeleccionada = carta1;
            }
        });

        carta2Boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (carta2.getNombreCarta().contains("Diamante")) {
                    botonAccion.setIcon(new ImageIcon(iconosBoton.ElegirArma.iconosBoton));
                    botonAccion.setRolloverIcon(new ImageIcon(iconosBoton.ElegirArmaSeleccionado.iconosBoton));
                } else if (carta2.getNombreCarta().contains("Pica") || carta2.getNombreCarta().contains("Trebol")) {
                    botonAccion.setIcon(new ImageIcon(iconosBoton.Atacar.iconosBoton));
                    if (cartaArmaSeleccionada != null) {
                        enemigoActual = carta2;
                        comprobarEnemigo();
                    } else {
                        botonAccion.setRolloverIcon(new ImageIcon(iconosBoton.AtacarSinArma.iconosBoton));
                    }
                } else if (carta2.getNombreCarta().contains("Corazon")) {
                    botonAccion.setIcon(new ImageIcon(iconosBoton.Curarse.iconosBoton));
                    if (curacionDisponible) {
                        botonAccion.setRolloverIcon(new ImageIcon(iconosBoton.CurarseSeleccionado.iconosBoton));
                    } else {
                        botonAccion.setRolloverIcon(new ImageIcon(iconosBoton.Descartar.iconosBoton));
                    }

                }
                cartaSeleccionada = carta2;
            }
        });

        carta3Boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (carta3.getNombreCarta().contains("Diamante")) {
                    botonAccion.setIcon(new ImageIcon(iconosBoton.ElegirArma.iconosBoton));
                    botonAccion.setRolloverIcon(new ImageIcon(iconosBoton.ElegirArmaSeleccionado.iconosBoton));
                } else if (carta3.getNombreCarta().contains("Pica") || carta3.getNombreCarta().contains("Trebol")) {
                    botonAccion.setIcon(new ImageIcon(iconosBoton.Atacar.iconosBoton));
                    if (cartaArmaSeleccionada != null) {
                        enemigoActual = carta3;
                        comprobarEnemigo();
                    } else {
                        botonAccion.setRolloverIcon(new ImageIcon(iconosBoton.AtacarSinArma.iconosBoton));
                    }
                } else if (carta3.getNombreCarta().contains("Corazon")) {
                    botonAccion.setIcon(new ImageIcon(iconosBoton.Curarse.iconosBoton));
                    if (curacionDisponible) {
                        botonAccion.setRolloverIcon(new ImageIcon(iconosBoton.CurarseSeleccionado.iconosBoton));
                    } else {
                        botonAccion.setRolloverIcon(new ImageIcon(iconosBoton.Descartar.iconosBoton));
                    }
                }
                cartaSeleccionada = carta3;
            }
        });
        carta4Boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (carta4.getNombreCarta().contains("Diamante")) {
                    botonAccion.setIcon(new ImageIcon(iconosBoton.ElegirArma.iconosBoton));
                    botonAccion.setRolloverIcon(new ImageIcon(iconosBoton.ElegirArmaSeleccionado.iconosBoton));
                } else if (carta4.getNombreCarta().contains("Pica") || carta4.getNombreCarta().contains("Trebol")) {
                    botonAccion.setIcon(new ImageIcon(iconosBoton.Atacar.iconosBoton));
                    if (cartaArmaSeleccionada != null) {
                        enemigoActual = carta4;
                        comprobarEnemigo();
                    } else {
                        botonAccion.setRolloverIcon(new ImageIcon(iconosBoton.AtacarSinArma.iconosBoton));
                    }
                } else if (carta4.getNombreCarta().contains("Corazon")) {
                    botonAccion.setIcon(new ImageIcon(iconosBoton.Curarse.iconosBoton));
                    if (curacionDisponible && vidas != 20) {
                        botonAccion.setRolloverIcon(new ImageIcon(iconosBoton.CurarseSeleccionado.iconosBoton));
                    } else {
                        botonAccion.setRolloverIcon(new ImageIcon(iconosBoton.Descartar.iconosBoton));
                    }
                }
                cartaSeleccionada = carta4;
            }
        });
        botonHuir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!botonHuir.getIcon().toString().contains("Bloqueado")) {
                    cartasTrasHuir();
                }
            }
        });
        botonAccion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cartaSeleccionada == carta1) {
                    FuncionBoton1.funcionBoton(Juego.this);
                } else if (cartaSeleccionada == carta2) {
                    FuncionBoton2.funcionBoton(Juego.this);
                } else if (cartaSeleccionada == carta3) {
                    FuncionBoton3.funcionBoton(Juego.this);
                } else if (cartaSeleccionada == carta4) {
                    FuncionBoton4.funcionBoton(Juego.this);
                }
                funcionActualizar.actualizaciones(Juego.this);
            }
        });
    }

    public void obtener4Cartas() {
        new FuncionSonido(SonidosJuego.PonerCarta).reproducirSonido();
        carta1Boton.setAlignmentX(getAlignmentX() + 100);
        carta1Boton.setIcon(new ImageIcon(cartasMazo.getFirst().imagenCarta));
        carta1Boton.setSelectedIcon(new ImageIcon(cartasMazo.getFirst().imagenCartaSeleccionada));
        carta1Boton.setPressedIcon(new ImageIcon(cartasMazo.getFirst().imagenCartaSeleccionada));
        carta1Boton.setRolloverIcon(new ImageIcon(cartasMazo.getFirst().imagenCartaSeleccionada));
        carta1 = cartasMazo.getFirst();
        cartasMazo.removeFirst();
        carta2Boton.setIcon(new ImageIcon(cartasMazo.getFirst().imagenCarta));
        carta2Boton.setSelectedIcon(new ImageIcon(cartasMazo.getFirst().imagenCartaSeleccionada));
        carta2Boton.setPressedIcon(new ImageIcon(cartasMazo.getFirst().imagenCartaSeleccionada));
        carta2Boton.setRolloverIcon(new ImageIcon(cartasMazo.getFirst().imagenCartaSeleccionada));
        carta2 = cartasMazo.getFirst();
        cartasMazo.removeFirst();
        carta3Boton.setIcon(new ImageIcon(cartasMazo.getFirst().imagenCarta));
        carta3Boton.setSelectedIcon(new ImageIcon(cartasMazo.getFirst().imagenCartaSeleccionada));
        carta3Boton.setPressedIcon(new ImageIcon(cartasMazo.getFirst().imagenCartaSeleccionada));
        carta3Boton.setRolloverIcon(new ImageIcon(cartasMazo.getFirst().imagenCartaSeleccionada));
        carta3 = cartasMazo.getFirst();
        cartasMazo.removeFirst();
        carta4Boton.setIcon(new ImageIcon(cartasMazo.getFirst().imagenCarta));
        carta4Boton.setSelectedIcon(new ImageIcon(cartasMazo.getFirst().imagenCartaSeleccionada));
        carta4Boton.setPressedIcon(new ImageIcon(cartasMazo.getFirst().imagenCartaSeleccionada));
        carta4Boton.setRolloverIcon(new ImageIcon(cartasMazo.getFirst().imagenCartaSeleccionada));
        carta4 = cartasMazo.getFirst();
        cartasMazo.removeFirst();
    }

    public void cartasTrasHuir() {
        if (carta4 != null) {
            cartasMazo.addLast(new Carta(carta1));
            cartasMazo.addLast(new Carta(carta2));
            cartasMazo.addLast(new Carta(carta3));
            cartasMazo.addLast(new Carta(carta4));
            botonHuir.setIcon(new ImageIcon("src/resources/sprites/botones/BotonHuirBloqueado.png"));
            botonHuir.setRolloverEnabled(false);
            obtener4Cartas();
            funcionActualizar.actualizaciones(Juego.this);
        }
    }
    //Función para comprobar el nuevo enemigo
    private void comprobarEnemigo() {
        if (ultimoEnemigoCarta == null) {
            botonAccion.setRolloverIcon(new ImageIcon(iconosBoton.AtacarConArma.iconosBoton));
        } else {
            if (ultimoEnemigoCarta.getValorCarta().valor <= enemigoActual.getValorCarta().valor) {
                botonAccion.setRolloverIcon(new ImageIcon(iconosBoton.AtacarSinArma.iconosBoton));
                ultimoEnemigoAsimilado = enemigoActual;
                enemigoMuyFuerte = true;
            } else {
                botonAccion.setRolloverIcon(new ImageIcon(iconosBoton.AtacarConArma.iconosBoton));
                ultimoEnemigoCarta = enemigoActual;
            }
        }
    }

    public enum iconosBoton {
        Atacar("src/resources/sprites/botones/BotonAtacar.png"),
        AtacarConArma("src/resources/sprites/botones/BotonAtacarConArma.png"),
        AtacarSinArma("src/resources/sprites/botones/BotonAtacarSinArmas.png"),
        Curarse("src/resources/sprites/botones/BotonCurarse.png"),
        CurarseSeleccionado("src/resources/sprites/botones/BotonCurarseSeleccionado.png"),
        ElegirArma("src/resources/sprites/botones/BotonElegirArma.png"),
        ElegirArmaSeleccionado("src/resources/sprites/botones/BotonElegirArmaSeleccionado.png"),
        Seleccionar("src/resources/sprites/botones/BotonSeleccionar.png"),
        Descartar("src/resources/sprites/botones/BotonDescartar.png");

        public final String iconosBoton;

        iconosBoton(String iconosBoton) {
            this.iconosBoton = iconosBoton;
        }
    }

    public enum SonidosJuego {
        GirarCarta("src/resources/sounds/girarCarta.wav"), PonerCarta("src/resources/sounds/ponerCartas.wav");
        public final String sonidoJuego;
        SonidosJuego(String sonidosJuego) {
            this.sonidoJuego = sonidosJuego;
        }
        public String getSonido(){
            return sonidoJuego;
        }
    }
}
