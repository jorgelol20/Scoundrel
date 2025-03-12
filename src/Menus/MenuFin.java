package Menus;

import JuegoNormal.Juego;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFin extends JPanel {
    public JPanel mainPanel;
    private JLabel imagenFondo;
    private JButton reintentarButton;
    private JButton salirButton;
    private JButton menuPrincipalButton;
    private static boolean juegoNormal;
    public void pantallaFinal(boolean victoria) {
        if(victoria){
            imagenFondo.setIcon(new ImageIcon("src/resources/sprites/victoria.png"));
        }else{
            imagenFondo.setIcon(new ImageIcon("src/resources/sprites/gameOver.png"));
        }
        Main.frame.setContentPane(this.mainPanel);
    }
    public static void llamarPantallaFinal(MenuFin menuFin, Boolean victoria, Boolean juegoNormalB) {
        if (juegoNormalB) {
            juegoNormal = true;
        }else{
            juegoNormal = false;
        }
        menuFin.pantallaFinal(victoria);
    }
    public MenuFin() {
        reintentarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(juegoNormal){
                    new JuegoNormal.Juego();
                }else{
                    new JuegoQuest.Juego();
                }
            }
        });
        menuPrincipalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.main(new String[0]);
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
