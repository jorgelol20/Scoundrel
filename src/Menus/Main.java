package Menus;

import JuegoNormal.Funciones.FuncionSonido;
import JuegoNormal.*;
import JuegoQuest.*;
import JuegoQuest.Juego;


import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
    private static FuncionSonido musicaFondo = new FuncionSonido();

    public static void main(String[] args) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1400, 768);
        frame.setContentPane(new Main().mainPanel);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setIconImage(new ImageIcon("src/resources/sprites/logoTemporal.png").getImage());
    }
    public Main() {
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
                valorVolumenMusica = (float) volumenMusica.getValue() / 100;
                float min = musicaFondo.controlVolumen.getMinimum(); // Volumen mínimo en dB
                float max = 0.0f; // Volumen máximo en dB (normal)
                float volumenDB;
                volumenDB = min + (max - min) * valorVolumenMusica;
                musicaFondo.controlVolumen.setValue(volumenDB);
            }
        });
        volumenSonidos.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                valorVolumenSonidos = (float)  volumenSonidos.getValue() / 100;

            }
        });
    }
    public void empezarQuest() {
        juegoQuest = new JuegoQuest.Juego();
    }
}
