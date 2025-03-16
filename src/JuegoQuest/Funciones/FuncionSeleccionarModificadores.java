package JuegoQuest.Funciones;

import Entidades.Modificador;
import JuegoQuest.Juego;
import Menus.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FuncionSeleccionarModificadores {
    private JPanel panelModificadores;
    private JButton selecMod1;
    private Modificador mod1;
    private JButton selecMod2;
    private Modificador mod2;
    private JButton selecMod3;
    private Modificador mod3;
    private JLabel nombreMod1;
    private JLabel nombreMod2;
    private JLabel nombreMod3;
    private JLabel descripcionMod1;
    private JLabel descripcionMod2;
    private JLabel descripcionMod3;
    private JLabel iconoMod1;
    private JLabel iconoMod2;
    private JLabel iconoMod3;

    public FuncionSeleccionarModificadores(Juego juego) {
        JFrame frame2 = new JFrame("Modificadores");
        frame2.setIconImage(Main.frame.getIconImage());
        frame2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame2.setBounds(0,0, 1300, 768);
        frame2.setUndecorated(true);
        frame2.setLocationRelativeTo(Main.frame);
        frame2.setContentPane(panelModificadores);
        frame2.setVisible(true);;
        frame2.setContentPane(panelModificadores);
        Main.frame.setVisible(false);
        mod1 = new Modificador(Modificador.obtenerModificador());
        mod2 = new Modificador(Modificador.obtenerModificador());
        mod3 = new Modificador(Modificador.obtenerModificador());
        nombreMod1.setText(mod1.nombre);
        nombreMod2.setText(mod2.nombre);
        nombreMod3.setText(mod3.nombre);
        descripcionMod1.setText(mod1.descripcion);
        descripcionMod2.setText(mod2.descripcion);
        descripcionMod3.setText(mod3.descripcion);
        iconoMod1.setIcon(new ImageIcon(mod1.icono));
        iconoMod2.setIcon(new ImageIcon(mod2.icono));
        iconoMod3.setIcon(new ImageIcon(mod3.icono));
        panelModificadores.setLayout(new BorderLayout());
        selecMod1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FuncionSeleccionarModificadores.aplicar(juego, mod1);
                frame2.dispose();
                Main.frame.setVisible(true);
            }
        });
        selecMod2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FuncionSeleccionarModificadores.aplicar(juego, mod2);
                frame2.dispose();
                Main.frame.setVisible(true);
            }
        });
        selecMod3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FuncionSeleccionarModificadores.aplicar(juego, mod3);
                frame2.dispose();
                Main.frame.setVisible(true);
            }
        });
    }
    public static void aplicar(Juego juego, Modificador modificador) {
        Modificador.aplicarModificador(modificador,juego);
    }
}
