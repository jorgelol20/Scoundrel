package JuegoQuest.Funciones;

import JuegoQuest.Juego;
import Menus.Main;
import Menus.MenuFin;

import javax.swing.*;

public class FuncionActualizar {
    public void actualizaciones(Juego juego) {
        juego.botonAccion.setIcon(new ImageIcon(Juego.iconosBoton.Seleccionar.iconosBoton));
        juego.botonAccion.setRolloverIcon(new ImageIcon(Juego.iconosBoton.Seleccionar.iconosBoton));
        juego.enemigoMuyFuerte = false;
        comprobarVidas(juego);
        desactivarBotones(juego);
        comprobacionesCartas(juego);
        comprobarVictoria(juego);
        setNumCartas(juego);
        juego.log.setText(juego.textoLogs);
        //Cambiar el número de cartas restantes.
        juego.numCartasRestantes = Juego.cartasMazo.size();
        juego.cartasRestantes.setText(juego.numCartasRestantes + "");
    }
    //Función para comprobar el número de vidas restantes.
    private void comprobarVidas(Juego juego){
        //Si al vida supera las vidas máximas, se pondrá a estas automáticamente.
        if (juego.vidas > juego.vidaMaxima){
            juego.vidas = juego.vidaMaxima;
        }
        //Si la vida es mayor que 10, se pondrá el icono de corazon entero.
        if (juego.vidas > 15) {
            juego.corazon.setIcon(new ImageIcon("src/resources/sprites/corazon/CorazonFull.png"));
        }
        //Si la vida es menor o igual a 15, se pondrá el corazon medio
        if (juego.vidas <= 15) {
            juego.corazon.setIcon(new ImageIcon("src/resources/sprites/corazon/CorazonMitad.png"));
        }
        //Si la vida es menor o igual a 5, se pondrá el corazón roto
        if (juego.vidas <= 5) {
            juego.corazon.setIcon(new ImageIcon("src/resources/sprites/corazon/CorazonMuerto.png"));
        }
        //Se la vida es menor o igual a 0, saldrá la pantalla de GameOver
        if (juego.vidas <= 0) {
            MenuFin.llamarPantallaFinal(new MenuFin(),juego.victoria, juego.juegoNormal);
        }
        juego.numVida.setText(juego.vidas + "");
    }
    //Función que desactiva los botones si no hay carta en él.
    private void desactivarBotones(Juego juego) {
        if (juego.carta3 == null){
            juego.carta3Boton.setEnabled(false);
        }
        if (juego.carta4 == null){
            juego.carta4Boton.setEnabled(false);
            juego.botonHuir.setRolloverEnabled(false);
            juego.botonHuir.setIcon(new ImageIcon("src/resources/sprites/botones/BotonHuirBloqueado.png"));
        }
        if (juego.carta2 == null && juego.numCartasRestantes == 0) {
            juego.carta2Boton.setEnabled(false);
        }
    }
    //Función para comprobar las cartas restantes y poner las nuevas
    private void comprobacionesCartas(Juego juego) {
        /*
        Si la carta 2 es nula (se ha usado) y quedan 4 o más cartas restantes en la baraja,
        se pondrán 3 cartas nuevas (la 1 siempre está).
         */
        if (juego.carta2 == null && juego.numCartasRestantes >= 3) {
            juego.carta2Boton.setIcon(new ImageIcon(Juego.cartasMazo.getFirst().imagenCarta));
            juego.carta2Boton.setPressedIcon(new ImageIcon(Juego.cartasMazo.getFirst().imagenCartaSeleccionada));
            juego.carta2Boton.setPressedIcon(new ImageIcon(Juego.cartasMazo.getFirst().imagenCartaSeleccionada));
            juego.carta2Boton.setRolloverIcon(new ImageIcon(Juego.cartasMazo.getFirst().imagenCartaSeleccionada));
            juego.carta2 = Juego.cartasMazo.getFirst();
            Juego.cartasMazo.removeFirst();
            juego.carta3Boton.setIcon(new ImageIcon(Juego.cartasMazo.getFirst().imagenCarta));
            juego.carta3Boton.setPressedIcon(new ImageIcon(Juego.cartasMazo.getFirst().imagenCartaSeleccionada));
            juego.carta3Boton.setPressedIcon(new ImageIcon(Juego.cartasMazo.getFirst().imagenCartaSeleccionada));
            juego.carta3Boton.setRolloverIcon(new ImageIcon(Juego.cartasMazo.getFirst().imagenCartaSeleccionada));
            juego.carta3Boton.setEnabled(true);
            juego.carta3 = Juego.cartasMazo.getFirst();
            Juego.cartasMazo.removeFirst();
            juego.carta4Boton.setIcon(new ImageIcon(Juego.cartasMazo.getFirst().imagenCarta));
            juego.carta4Boton.setPressedIcon(new ImageIcon(Juego.cartasMazo.getFirst().imagenCartaSeleccionada));
            juego.carta4Boton.setPressedIcon(new ImageIcon(Juego.cartasMazo.getFirst().imagenCartaSeleccionada));
            juego.carta4Boton.setRolloverIcon(new ImageIcon(Juego.cartasMazo.getFirst().imagenCartaSeleccionada));
            juego.carta4Boton.setEnabled(true);
            juego.carta4 = Juego.cartasMazo.getFirst();
            Juego.cartasMazo.removeFirst();
            if (juego.numCartasRestantes > 4) {
                juego.botonHuir.setIcon(new ImageIcon("src/resources/sprites/botones/BotonHuir.png"));
                juego.botonHuir.setRolloverEnabled(true);
            }
            juego.curacionDisponible = true;
        }
        /*
        Si la carta dos es nula y solo quedan 2 cartas en el deck, se rellenarán la carta 2 y 3.
         */
        else if (juego.carta2 == null && juego.numCartasRestantes == 2) {
            juego.carta2Boton.setIcon(new ImageIcon(Juego.cartasMazo.getFirst().imagenCarta));
            juego.carta2Boton.setPressedIcon(new ImageIcon(Juego.cartasMazo.getFirst().imagenCartaSeleccionada));
            juego.carta2Boton.setPressedIcon(new ImageIcon(Juego.cartasMazo.getFirst().imagenCartaSeleccionada));
            juego.carta2Boton.setRolloverIcon(new ImageIcon(Juego.cartasMazo.getFirst().imagenCartaSeleccionada));
            juego.carta2 = juego.cartasMazo.getFirst();
            Juego.cartasMazo.removeFirst();
            juego.carta3Boton.setIcon(new ImageIcon(Juego.cartasMazo.getFirst().imagenCarta));
            juego.carta3Boton.setPressedIcon(new ImageIcon(Juego.cartasMazo.getFirst().imagenCartaSeleccionada));
            juego.carta3Boton.setPressedIcon(new ImageIcon(Juego.cartasMazo.getFirst().imagenCartaSeleccionada));
            juego.carta3Boton.setRolloverIcon(new ImageIcon(Juego.cartasMazo.getFirst().imagenCartaSeleccionada));
            juego.carta3Boton.setEnabled(true);
            juego.carta3 = Juego.cartasMazo.getFirst();
            Juego.cartasMazo.removeFirst();
        }
        /*
        Si la carta dos es nula y solo queda 1 restante, se rellenará la carta 2 únicamente.
         */
        else if (juego.carta2 == null && juego.numCartasRestantes == 1) {
            juego.carta2Boton.setIcon(new ImageIcon(Juego.cartasMazo.getFirst().imagenCarta));
            juego.carta2Boton.setPressedIcon(new ImageIcon(Juego.cartasMazo.getFirst().imagenCartaSeleccionada));
            juego.carta2Boton.setPressedIcon(new ImageIcon(Juego.cartasMazo.getFirst().imagenCartaSeleccionada));
            juego.carta2Boton.setRolloverIcon(new ImageIcon(Juego.cartasMazo.getFirst().imagenCartaSeleccionada));
            juego.carta2 = Juego.cartasMazo.getFirst();
            Juego.cartasMazo.removeFirst();
        }
    }
    /*
    Función para comprobar si has ganado
     */
    private void comprobarVictoria(Juego juego) {
        if (juego.numCartasRestantes == 0 && juego.carta1 == null){
            FuncionesInicio.crearBaraja(juego);
        }
    }
    public static void setNumCartas(Juego juego) {
        juego.cartasRestantes.setText(String.valueOf(Juego.cartasMazo.size()));
    }
}
