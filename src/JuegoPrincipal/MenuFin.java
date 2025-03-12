package JuegoPrincipal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFin extends JPanel {
    public JPanel mainPanel;
    private JLabel imagenFondo;
    private JButton reintentarButton;
    private JButton salirButton;
    private JButton menuPrincipalButton;
    public void pantallaFinal(boolean victoria){
        if(victoria){
            imagenFondo.setIcon(new ImageIcon("src/resources/sprites/victoria.png"));
        }else{
            imagenFondo.setIcon(new ImageIcon("src/resources/sprites/gameOver.png"));
        }
        Main.frame.setContentPane(this.mainPanel);
    }
    public static void llamarPantallaFinal(MenuFin menuFin, Boolean victoria){
        menuFin.pantallaFinal(victoria);
    }
    public MenuFin() {
        reintentarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new Juego();
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
