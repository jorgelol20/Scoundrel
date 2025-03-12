package JuegoQuest.Funciones;

import Entidades.Modificador;
import JuegoQuest.Juego;
import Menus.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FuncionSeleccionarModificadores {
    private JPanel panelModificadores;
    private JButton selecMod1;
    private JButton selecMod2;
    private JButton selecMod3;
    private JLabel nombreMod1;
    private JLabel nombreMod2;
    private JLabel nombreMod3;
    private JLabel descripcionMod1;
    private JLabel descripcionMod2;
    private JLabel descripcionMod3;
    public FuncionSeleccionarModificadores(Juego juego) {
        JFrame frame2 = new JFrame("Modificadores");
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame2.setBounds(0,0, 1300, 768);
        frame2.setLocationRelativeTo(Main.frame);
        frame2.setUndecorated(true);
        frame2.setContentPane(panelModificadores);
        frame2.setVisible(true);
        int[] numModificadores = new int[Modificador.modificadores.size()];
        for(int i = 0; i< Modificador.modificadores.size(); i++) {
            numModificadores[i] = (int) (Math.random() * Modificador.modificadores.size());
        }
        Modificador mod1 = Modificador.modificadores.get(numModificadores[0]);
        Modificador mod2 = Modificador.modificadores.get(numModificadores[1]);
        Modificador mod3 = Modificador.modificadores.get(numModificadores[2]);
        nombreMod1.setText(mod1.nombre);
        nombreMod2.setText(mod2.nombre);
        nombreMod3.setText(mod3.nombre);
        descripcionMod1.setText(mod1.descripcion);
        descripcionMod2.setText(mod2.descripcion);
        descripcionMod3.setText(mod3.descripcion);
        panelModificadores.setLayout(new BorderLayout());
        selecMod1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aplicar(juego, mod1);
                frame2.dispose();
            }
        });
        selecMod2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aplicar(juego, mod2);
                frame2.dispose();
            }
        });
        selecMod3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aplicar(juego, mod3);
                frame2.dispose();
            }
        });
    }
    public void aplicar(Juego juego, Modificador modificador) {
        modificador.aplicarModificador(juego);
        juego.mainPanel.repaint();
    }
}
