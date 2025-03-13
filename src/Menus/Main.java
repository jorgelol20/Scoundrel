package Menus;

import JuegoNormal.Funciones.FuncionSonido;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static FuncionSonido musicaFondo = new FuncionSonido();
    public static JFrame frame = new JFrame("Menu");

    public static void main(String[] args) {
        if ((musicaFondo.reproductor.isRunning())) {

        }else{
            musicaFondo.ponerMusica();
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1300, 768);
        frame.setContentPane(new Main().mainPanel);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setIconImage(new ImageIcon("src/resources/sprites/logoTemporal.png").getImage());

    }

    private JPanel mainPanel;
    private JButton empezarPartidaBoton;
    private JButton empezarQuestBoton;
    private JButton salirBoton;
    private JPanel panelMenu;
    private JButton aprenderAJugarButton;

    public Main() {
        empezarPartidaBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new JuegoNormal.Juego();
            }
        });
        empezarQuestBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new JuegoQuest.Juego();
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

            }
        });
    }
}
