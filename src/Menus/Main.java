package Menus;

import JuegoNormal.Funciones.FuncionSonido;


import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static JFrame frame = new JFrame("Menu");
    private JPanel mainPanel;
    private JButton empezarPartidaBoton;
    private JButton empezarQuestBoton;
    private JButton salirBoton;
    public JPanel panelMenu;
    private JButton aprenderAJugarButton;
    private JuegoNormal.Juego juego;
    private JuegoQuest.Juego juegoQuest;
    public static float valorVolumenMusica = 0.5f;
    public static float valorVolumenSonidos = 0.5f;
    private JSlider volumenSonidos;
    private JSlider volumenMusica;
    private JCheckBox fullScreen;
    private JButton botonMusica;
    private JButton botonSonidos;
    private static FuncionSonido musicaFondo = new FuncionSonido();
    private static boolean fullScreenSelected = false;
    private static int volumenMusicaSelected = 50;
    private static int volumenSonidosSelected = 50;

    public static void main(String[] args) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1400, 768);
        frame.setContentPane(new Main().mainPanel);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setIconImage(new ImageIcon("src/resources/sprites/logoTemporal.png").getImage());
    }
    public Main() {
        fullScreen.setSelected(fullScreenSelected);
        if (fullScreenSelected) {
            frame.setBounds(0, 0, 1920, 1080);
        }
        if (valorVolumenMusica == 0) {
            cambiarIconoMusica();
        }
        if (valorVolumenSonidos == 0) {
            cambiarIconoSonidos();
        }
        volumenSonidos.setMaximum(100);
        volumenSonidos.setMinimum(0);
        volumenSonidos.setValue(Integer.parseInt(String.valueOf(valorVolumenSonidos*100f).replace(".0","")));
        volumenMusica.setMaximum(100);
        volumenMusica.setMinimum(0);
        volumenMusica.setValue(Integer.parseInt(String.valueOf(valorVolumenMusica*100f).replace(".0","")));
        musicaFondo.ponerMusica();
        empezarPartidaBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FuncionSonido(JuegoNormal.Juego.SonidosJuego.SonidoBotones).reproducirSonido();
                juego = new JuegoNormal.Juego();
            }
        });
        empezarQuestBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FuncionSonido(JuegoNormal.Juego.SonidosJuego.SonidoBotones).reproducirSonido();
                empezarQuest();
            }
        });
        salirBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FuncionSonido(JuegoNormal.Juego.SonidosJuego.SonidoBotones).reproducirSonido();
                System.exit(0);
            }
        });
        aprenderAJugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FuncionSonido(JuegoNormal.Juego.SonidosJuego.SonidoBotones).reproducirSonido();
                new MenuAyuda();
            }
        });
        volumenMusica.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (volumenMusica.getValue() != 0) {
                    volumenMusicaSelected = volumenMusica.getValue();
                }
                cambiarVolumenMusica();
            }
        });
        volumenSonidos.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (volumenSonidos.getValue() != 0) {
                    volumenSonidosSelected = volumenSonidos.getValue();
                }
                cambiarVolumenSonidos();
            }
        });
        fullScreen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                if (fullScreen.isSelected()) {
                    frame.setBounds(0, 0, screenSize.width, screenSize.height);
                    fullScreenSelected = true;
                }else{
                    frame.setBounds(0, 0, 1400, 768);
                    fullScreenSelected = false;
                }
            }
        });
        botonMusica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarIconoMusica();
                cambiarVolumenMusica();
            }
        });
        botonSonidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarIconoSonidos();
                cambiarVolumenSonidos();
            }
        });
    }
    public void cambiarVolumenMusica() {
        valorVolumenMusica = (float) volumenMusica.getValue() / 100;
        float min = musicaFondo.controlVolumen.getMinimum(); // Volumen mínimo en dB
        float max = 0.0f; // Volumen máximo en dB (normal)
        float volumenDB;
        volumenDB = min + (max - min) * valorVolumenMusica;
        musicaFondo.controlVolumen.setValue(volumenDB);
    }
    public void cambiarVolumenSonidos() {
        valorVolumenSonidos = (float)  volumenSonidos.getValue() / 100;
    }
    public void empezarQuest() {
        juegoQuest = new JuegoQuest.Juego();
    }
    private void cambiarIconoMusica() {
        if (botonMusica.getIcon().toString().contains("No")) {
            botonMusica.setIcon(new ImageIcon("src/resources/sprites/botones/Musica.png"));
            botonMusica.setPressedIcon(new ImageIcon("src/resources/sprites/botones/MusicaSeleccionado.png"));
            botonMusica.setRolloverIcon(new ImageIcon("src/resources/sprites/botones/MusicaSeleccionado.png"));
            botonMusica.setSelectedIcon(new ImageIcon("src/resources/sprites/botones/MusicaSeleccionado.png"));
            volumenMusica.setValue(volumenMusicaSelected);
        }else{
            botonMusica.setIcon(new ImageIcon("src/resources/sprites/botones/NoMusica.png"));
            botonMusica.setSelectedIcon(new ImageIcon("src/resources/sprites/botones/NoMusicaSeleccionado.png"));
            botonMusica.setPressedIcon(new ImageIcon("src/resources/sprites/botones/NoMusicaSeleccionado.png"));
            botonMusica.setRolloverIcon(new ImageIcon("src/resources/sprites/botones/NoMusicaSeleccionado.png"));
            volumenMusica.setValue(0);
        }
    }
    private void cambiarIconoSonidos() {
        if (botonSonidos.getIcon().toString().contains("No")) {
            botonSonidos.setIcon(new ImageIcon("src/resources/sprites/botones/Efectos.png"));
            botonSonidos.setRolloverIcon(new ImageIcon("src/resources/sprites/botones/EfectosSeleccionado.png"));
            botonSonidos.setSelectedIcon(new ImageIcon("src/resources/sprites/botones/EfectosSeleccionado.png"));
            botonSonidos.setPressedIcon(new ImageIcon("src/resources/sprites/botones/EfectosSeleccionado.png"));
            volumenSonidos.setValue(volumenSonidosSelected);
        }else {
            botonSonidos.setIcon(new ImageIcon("src/resources/sprites/botones/NoEfectos.png"));
            botonSonidos.setRolloverIcon(new ImageIcon("src/resources/sprites/botones/NoEfectosSeleccionado.png"));
            botonSonidos.setSelectedIcon(new ImageIcon("src/resources/sprites/botones/NoEfectosSeleccionado.png"));
            botonSonidos.setPressedIcon(new ImageIcon("src/resources/sprites/botones/NoEfectosSeleccionado.png"));
            volumenSonidos.setValue(0);
        }
    }
}
