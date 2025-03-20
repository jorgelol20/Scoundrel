package JuegoQuest;

import Entidades.Carta;
import Entidades.Modificador;
import JuegoQuest.Funciones.*;
import Menus.Main;
import Menus.MenuAyuda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Juego extends JFrame {
    //Variables base (mazo y actualizar)
    public FuncionActualizar funcionActualizar = new FuncionActualizar();
    public static ArrayList<Carta> cartasMazo = new ArrayList<Carta>();

    //Componentes menú y sus variables
    public JPanel mainPanel;
    public JLabel mazo;
    public JLabel numQuest;
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
    public JTextArea log;
    public JLabel ultimoEnemigoAsimiladoLabel;
    public Carta ultimoEnemigoAsimilado;
    public String textoLogs = "";
    public boolean victoria = false;
    public boolean juegoNormal = false;

    //Variables juego base
    public boolean enemigoMuyFuerte = false;
    public int vidas = 20;
    public int vidaMaxima = 20;
    public boolean curacionDisponible = true;

    //Variables modificadores
    public boolean herido = false;
    public boolean heridoGrave = false;
    public int numRonda = 1; //Ronda dentro de la quest
    public int contadorRondaQuest = 1; //Ronda general (1-10)
    public int contadorModificador = 1;
    public int danyoExtraTreboles = 0;
    public int danyoExtraPicas = 0;
    public int efectoExtraCuracion = 0;
    public int danyoExtraArmas = 0;
    public boolean metabolismoRapido = false;
    public int contadorHuir = 1;
    public int huir = 1;
    public boolean maldicionDelPerdido = false;
    public boolean gastroenteritis = false;
    public boolean paranoia = false;
    public boolean sinEscapatoria = false;
    public boolean ultimoSuspiro = false;
    public boolean ultimoSuspiroActivado = false;
    public boolean pentakill = false;
    public int contadorPentakill = 1;
    public boolean criticoActivado = false;
    public boolean fatiga = false;
    public boolean chupacabras = false;
    public boolean espinas = false;
    public boolean ICD = false;
    public boolean soloLeveling = false;
    //Variables modificadores
    public JLabel mod1;
    public JLabel mod2;
    public JLabel mod3;
    public JLabel mod4;
    public JLabel mod5;
    public JLabel mod6;
    public JLabel mod7;
    public JLabel mod8;
    public JLabel mod9;
    public JLabel mod10;
    private JButton salir;
    private JButton ayuda;

    //Variables quest
    public int posicionModDracula = 0;
    public int posicionModDragon = 0;
    public int posicionModSans = 0;
    public int posicionModPentakill = 0;
    public boolean questDracula = false;
    public boolean questDragon = false;
    public boolean questSans = false;

    public Juego() {
        Main.frame.setContentPane(mainPanel);
        cartasMazo.clear();
        Modificador.cargarModificadores();
        FuncionesInicio.crearBaraja(this);
        new FuncionSeleccionarModificadores(this);
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
                seleccionCartaIcono(carta1Boton,carta1,carta2Boton,carta2,carta3Boton,carta3,carta4Boton,carta4);
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
                seleccionCartaIcono(carta2Boton,carta2,carta1Boton,carta1,carta3Boton,carta3,carta4Boton,carta4);
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
                seleccionCartaIcono(carta3Boton,carta3,carta1Boton,carta1,carta2Boton,carta2,carta4Boton,carta4);
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
                seleccionCartaIcono(carta4Boton,carta4,carta1Boton,carta1,carta2Boton,carta2,carta3Boton,carta3);
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
            }
        });
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opcion = JOptionPane.showOptionDialog(mainPanel,"¿Seguro que quiere salir al menú principal?","Salir",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE,null,new String[]{"Al menú","Salir del juego","No"},0);
                if (opcion == 0){
                    Main.main(new String[0]);
                }else if (opcion == 1){
                    System.exit(0);
                }
            }
        });
        ayuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new JuegoNormal.Funciones.FuncionSonido(JuegoNormal.Juego.SonidosJuego.SonidoBotones).reproducirSonido();
                new MenuAyuda();
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
        boolean efectoPersecucion = false;
        if (sinEscapatoria){
            int numAleatorio = (int) Math.ceil((Math.random() * 4));
            if (numAleatorio == 1){
                efectoPersecucion = true;
            }
        }
        if (carta4 != null && contadorHuir > 0 && !maldicionDelPerdido) {
            if (efectoPersecucion){
                textoLogs += "Intentaste escapar, pero te siguieron\n";
            }else{
                cartasMazo.addLast(new Carta(carta1));
                cartasMazo.addLast(new Carta(carta2));
                cartasMazo.addLast(new Carta(carta3));
                cartasMazo.addLast(new Carta(carta4));
                obtener4Cartas();
            }
            contadorHuir--;
            if (contadorHuir == 0) {
                botonHuir.setIcon(new ImageIcon("src/resources/sprites/botones/BotonHuirBloqueado.png"));
                botonHuir.setRolloverEnabled(false);
            }
            funcionActualizar.actualizaciones(this);
        }
    }
    //Función para comprobar el nuevo enemigo
    private void comprobarEnemigo() {
        if (ultimoEnemigoCarta == null) {
            botonAccion.setRolloverIcon(new ImageIcon(iconosBoton.AtacarConArma.iconosBoton));
        } else {
            if (ultimoEnemigoCarta.getValorCarta().valor <= enemigoActual.getValorCarta().valor) {
                botonAccion.setRolloverIcon(new ImageIcon(iconosBoton.AtacarSinArma.iconosBoton));
                enemigoMuyFuerte = true;
            } else {
                botonAccion.setRolloverIcon(new ImageIcon(iconosBoton.AtacarConArma.iconosBoton));
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
    public void seleccionCartaIcono(JButton cartaACambiarBoton, Carta cartaACambiar,JButton carta1Boton, Carta carta1, JButton carta2Boton,Carta carta2, JButton carta3Boton, Carta carta3) {
        if (paranoia){
            cartaACambiarBoton.setIcon(new ImageIcon(cartaACambiar.getPaloCarta().imagenDefaultSeleccionada));
            if (carta1 != null){
                carta1Boton.setIcon(new ImageIcon(carta1.getPaloCarta().imagenDefault));
            }
            if (carta2 != null){
                carta2Boton.setIcon(new ImageIcon(carta2.getPaloCarta().imagenDefault));
            }
            if (carta3 != null) {
                carta3Boton.setIcon(new ImageIcon(carta3.getPaloCarta().imagenDefault));
            }
        }else {
            cartaACambiarBoton.setIcon(new ImageIcon(cartaACambiar.imagenCartaSeleccionada));
            if (carta1 != null) {
                carta1Boton.setIcon(new ImageIcon(carta1.imagenCarta));
            }
            if (carta2 != null) {
                carta2Boton.setIcon(new ImageIcon(carta2.imagenCarta));
            }
            if (carta3 != null) {
                carta3Boton.setIcon(new ImageIcon(carta3.imagenCarta));
            }
        }
    }
}
