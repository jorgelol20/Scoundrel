package Menus;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuAyuda {
    private JPanel panelAyuda;
    private JTabbedPane menuAyuda;
    private JPanel panelGeneral;
    private JPanel panelCombate;
    private JPanel modificadores;
    private JTextPane textoBienvenida;
    private JTextPane enScoundrelTuObjetivoTextPane;
    private JButton button1;
    private JScrollPane cartas;

    public MenuAyuda() {
        JFrame frame2 = new JFrame("Modificadores");
        frame2.setIconImage(Main.frame.getIconImage());
        frame2.setLocation(Main.frame.getLocation());
        frame2.setBounds(0,0, 1400, 768);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(true);
        frame2.setContentPane(panelAyuda);
        frame2.setResizable(false);
        Main.frame.setVisible(false);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame2.dispose();
                Main.frame.setVisible(true);
            }
        });
    }
    /*
    JOptionPane.showMessageDialog(panelMenu,"¡Bienvenido a Scoundrel! \nUn MiniRPG de cartas \ndesarrollado por dos frikis (Jorge y Adri)","Bienvenido",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/resources/sprites/logoTemporal.png"));
                JOptionPane.showMessageDialog(panelMenu, "En Scoundrel hay 4 tipos de cartas: \nlos corazones, los diamantes, las picas y los tréboles.\n" +
                                                                    "Cada una de las cartas tiene sus propias acciones \ny funciones dentro del juego.", "Tipos de carta", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/resources/sprites/imagenesTutorial/imagen1.png"));
                JOptionPane.showMessageDialog(panelMenu, "Los corazones son las \"curaciones\" en este juego y \ncada una de estas te cura una cantidad \nde daño distinta correspondiente a su número.\nTen en cuenta que solo podrás curarte una vez\npor ronda, descartando la segunda curación\nque fueras a usar en ese turno","Curaciones",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/resources/sprites/imagenesTutorial/imagen2.png"));
                JOptionPane.showMessageDialog(panelMenu,"Los diamantes son las \"armas\" que usarás\npara defenderte de los enemigos.\nCada carta te defenderá del enemigo\nrestando al daño del enemigo el del arma.\nLas armas tienen condiciones que se explicarán más adelante.","Armas",JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/resources/sprites/imagenesTutorial/imagen3.png"));
                JOptionPane.showMessageDialog(panelMenu,"Los enemigos son las Picas y los Tréboles.\nEstos te harán el daño correspondiente\nal número asignado no teniendo diferencias entre\nellas excepto en el modo QUEST.","Enemigos",JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/resources/sprites/imagenesTutorial/imagen4.png"));
                JOptionPane.showMessageDialog(panelMenu,"Durante cada ronda, podrás huir una vez\ndejando las cartas que hay al final\ndel mazo y sacando las 4 siguientes.\nUna vez hayas huido una vez, se \nbloqueará la opción hasta pasar la ronda.", "Huir",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/resources/sprites/imagenesTutorial/imagen5.png"));
                JOptionPane.showMessageDialog(panelMenu,"A la hora de defenderte, solo podrás\ndefenderte si el último enemigo enfrentado\n con tu arma es más debil que el nuevo.\nSi no se cumple esta condición\nrecibirás todo el daño del enemigo.","Defenderte",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/resources/sprites/imagenesTutorial/imagen6.png"));
                JOptionPane.showMessageDialog(panelMenu, "El modo QUEST es una variación del modo\nnormal donde tu objetivo es ganar\n10 partidas seguidas sin ser derrotado.\n¡Pero no te preocupes! Este modo\ncuenta con modificadores y mejoras\nque harán de la experiencia algo más\ndesafiante y divertida para quien busca desafios.","Modo QUEST",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/resources/sprites/imagenesTutorial/imagen7.png"));
                JOptionPane.showMessageDialog(panelMenu,"Gracias por jugar Scoundrel :)\nJorge: Programador\nAdrian: Diseñador gráfico","Fin tutorial",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/resources/sprites/logoTemporal.png"));

     */
}
