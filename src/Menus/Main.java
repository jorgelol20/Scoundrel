package Menus;

import JuegoNormal.Funciones.FuncionSonido;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;

public class Main {
    public static JFrame frame = new JFrame("Menu");
    private JPanel mainPanel;
    private JButton empezarPartidaBoton;
    private JButton empezarQuestBoton;
    private JButton salirBoton;
    public JPanel panelMenu;
    private JButton aprenderAJugarButton;
    public static float valorVolumenMusica = 0.5f;
    public static float valorVolumenSonidos = 0.5f;
    private JComboBox volumenSonidos;
    private JComboBox volumenMusica;
    private static FuncionSonido musicaFondo = new FuncionSonido();

    public static void main(String[] args) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1300, 768);
        frame.setContentPane(new Main().mainPanel);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setIconImage(new ImageIcon("src/resources/sprites/logoTemporal.png").getImage());
    }
    public Main() {
        volumenSonidos.setSelectedIndex(Integer.parseInt(String.valueOf(valorVolumenSonidos*10f).replace(".0","")));
        volumenSonidos.repaint();
        volumenMusica.setSelectedIndex(Integer.parseInt(String.valueOf(valorVolumenSonidos*10f).replace(".0","")));
        volumenMusica.repaint();
        musicaFondo.ponerMusica();
        empezarPartidaBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new JuegoNormal.Juego();
            }
        });
        empezarQuestBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                empezarQuest();
            }
        });
        salirBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        aprenderAJugarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(panelMenu,"¡Bienvenido a Scoundrel! \nUn MiniRPG de cartas \ndesarrollado por dos frikis (Jorge y Adri)","Bienvenido",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/resources/sprites/logoTemporal.png"));
                JOptionPane.showMessageDialog(panelMenu, "En Scroundle hay 4 tipos de cartas: \nlas picas, los diamantes, las picas y los tréboles.\n" +
                                                                    "Cada una de las cartas tiene sus propias acciones \ny funciones dentro del juego.", "Tipos de carta", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/resources/sprites/imagenesTutorial/imagen1.png"));
                JOptionPane.showMessageDialog(panelMenu, "Los corazones son las \"curaciones\" en este juego y \ncada una de estas te cura una cantidad \nde daño distinta correspondiente a su número.\nTen en cuenta que solo podrás curarte una vez\npor ronda, descartando la segunda curación\nque fueras a usar en ese turno","Curaciones",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/resources/sprites/imagenesTutorial/imagen2.png"));
                JOptionPane.showMessageDialog(panelMenu,"Los diamantes son las \"armas\" que usarás\npara defenderte de los enemigos.\nCada carta te defenderá del enemigo\nrestando al daño del enemigo el del arma.\nLas armas tienen condiciones que se explicarán más adelante.","Armas",JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/resources/sprites/imagenesTutorial/imagen3.png"));
                JOptionPane.showMessageDialog(panelMenu,"Los enemigos son las Picas y los Tréboles.\nEstos te harán el daño correspondiente\nal número asignado no teniendo diferencias entre\nellas excepto en el modo QUEST.","Enemigos",JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/resources/sprites/imagenesTutorial/imagen4.png"));
                JOptionPane.showMessageDialog(panelMenu,"Durante cada ronda, podrás huir una vez\ndejando las cartas que hay al final\ndel mazo y sacando las 4 siguientes.\nUna vez hayas huido una vez, se \nbloqueará la opción hasta pasar la ronda.", "Huir",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/resources/sprites/imagenesTutorial/imagen5.png"));
                JOptionPane.showMessageDialog(panelMenu,"A la hora de defenderte, solo podrás\ndefenderte si el último enemigo enfrentado\n con tu arma es más debil que el nuevo.\nSi no se cumple esta condición\nrecibirás todo el daño del enemigo.","Defenderte",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/resources/sprites/imagenesTutorial/imagen6.png"));
                JOptionPane.showMessageDialog(panelMenu, "El modo QUEST es una variación del modo\nnormal donde tu objetivo es ganar\n10 partidas seguidas sin ser derrotado.\n¡Pero no te preocupes! Este modo\ncuenta con modificadores y mejoras\nque harán de la experiencia algo más\ndesafiante y divertida para quien busca desafios.","Modo QUEST",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/resources/sprites/imagenesTutorial/imagen7.png"));
                JOptionPane.showMessageDialog(panelMenu,"Gracias por jugar Scoundrel :)\nJorge: Programador\nAdrian: Diseñador gráfico","Fin tutorial",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/resources/sprites/logoTemporal.png"));
            }
        });
        volumenMusica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valorVolumenMusica = (float) Integer.parseInt((String) volumenMusica.getSelectedItem()) / 100;
                float min = musicaFondo.controlVolumen.getMinimum(); // Volumen mínimo en dB
                float max = 0.0f; // Volumen máximo en dB (normal)
                float volumenDB;
                volumenDB = min + (max - min) * valorVolumenMusica;
                musicaFondo.controlVolumen.setValue(volumenDB);
            }
        });
        volumenSonidos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valorVolumenSonidos = (float) Integer.parseInt((String) volumenSonidos.getSelectedItem()) / 100;
            }
        });
    }
    public void empezarQuest() {
        new JuegoQuest.Juego();
    }
}
