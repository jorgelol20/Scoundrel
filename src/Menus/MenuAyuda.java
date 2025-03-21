package Menus;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Objects;

public class MenuAyuda {
    private JPanel panelAyuda;
    private JTabbedPane menuAyuda;
    private JPanel panelGeneral;
    private JTextPane textoBienvenida;
    private JTextPane enScoundrelTuObjetivoTextPane;
    private JButton salir;
    private JScrollPane cartas;
    private JPanel AsPica;
    private JPanel AsTrebol;
    private JPanel ReyPica;
    private JPanel ReyTrebol;
    private JPanel ReinaPica;
    private JPanel ReinaTrebol;
    private JPanel SotaPica;
    private JPanel SotaTrebol;
    private JPanel DiezPica;
    private JPanel DiezTrebol;
    private JPanel DiezDiamante;
    private JPanel DiezCorazon;
    private JPanel NuevePica;
    private JPanel NueveTrebol;
    private JPanel NueveDiamante;
    private JPanel NueveCorazon;
    private JPanel OchoPica;
    private JPanel OchoTrebol;
    private JPanel OchoDiamante;
    private JPanel OchoCorazon;
    private JPanel SietePica;
    private JPanel SieteTrebol;
    private JPanel SieteDiamante;
    private JPanel SieteCorazon;
    private JPanel SeisPica;
    private JPanel SeisTrebol;
    private JPanel SeisDiamante;
    private JPanel SeisCorazon;
    private JPanel CincoCorazon;
    private JPanel CincoDiamante;
    private JPanel CincoTrebol;
    private JPanel CincoPica;
    private JPanel CuatroPica;
    private JPanel CuatroTrebol;
    private JPanel CuatroDiamante;
    private JPanel CuatroCorazon;
    private JPanel TresPIca;
    private JPanel TresTrebol;
    private JPanel TresDiamante;
    private JPanel TresCorazon;
    private JScrollPane modificadores;
    private JScrollPane combate;
    private JTextPane losDiamantesSonLasTextPane;

    public MenuAyuda() {
        JFrame frame2 = new JFrame("Modificadores");
        try {
            frame2.setIconImage(new ImageIcon("src/resources/sprites/logoTemporal.png").getImage());
        }catch(Exception e) {
            System.out.println("Error de icono");
        }
        try {
            frame2.setLocation(Main.frame.getLocation());
        }catch(Exception e) {
            System.out.println("Error de posición");
        }
        try {
            frame2.setBounds(0, 0, Main.frame.getWidth(), Main.frame.getHeight());
            frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame2.setVisible(true);
            frame2.setContentPane(panelAyuda);
            frame2.setResizable(false);
            Main.frame.setVisible(false);
        }catch (Exception e) {
            System.out.println("Error otros valores");
        }
        combate.getVerticalScrollBar().setUnitIncrement(20);
        cartas.getVerticalScrollBar().setUnitIncrement(20);
        combate.getVerticalScrollBar().setValue(0);
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame2.dispose();
                Main.frame.setVisible(true);
            }
        });
    }
}
