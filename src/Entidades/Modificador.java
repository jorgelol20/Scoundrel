package Entidades;

import java.util.ArrayList;
import java.util.Collections;

import JuegoQuest.Funciones.FuncionActualizar;
import JuegoQuest.Juego;

import javax.swing.*;

public class Modificador {
    public TipoModificador tipoModificador;
    public String nombre;
    public String descripcion;
    public String icono;
    public String icono16;
    public int id;
    public JLabel labelModificador;
    public static ArrayList<Modificador> modificadores = new ArrayList<Modificador>();

    public Modificador(Modificador modificadorOriginal) {
        this.tipoModificador = modificadorOriginal.tipoModificador;
        this.nombre = modificadorOriginal.nombre;
        this.descripcion = modificadorOriginal.descripcion;
        this.icono = modificadorOriginal.icono;
        this.icono16 = modificadorOriginal.icono16;
        this.id = modificadorOriginal.id;
    }

    public enum TipoModificador {
        BUFF, DEBUFF, QUEST
    }

    public Modificador(TipoModificador tipo, String nombre, String descripcion, String icono, int id) {
        this.tipoModificador = tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.icono = icono;
        this.id = id;

    }

    public static void cargarModificadores() {
        modificadores.clear();
        //Más vida máxima #0, #1, #2
        modificadores.add(new Modificador(TipoModificador.BUFF, "Más Vida I", "<html><div style='width: 200px; text-align: justify;'>Te da vida (5) extra durante el resto de la partida.</div></html>", "src/resources/sprites/modificadores/MasVida1.png", 0));
        modificadores.add(new Modificador(TipoModificador.BUFF, "Más Vida II", "<html><div style='width: 200px; text-align: justify;'>Te da vida (10) extra durante el resto de la partida.</div></html>", "src/resources/sprites/modificadores/MasVida2.png", 1));
        modificadores.add(new Modificador(TipoModificador.BUFF, "Más Vida III", "<html><div style='width: 200px; text-align: justify;'>Te da vida (15) extra durante el resto de la partida.</div></html>", "src/resources/sprites/modificadores/MasVida3.png", 2));
        //Debuff tréboles #3, #4, #5
        modificadores.add(new Modificador(TipoModificador.DEBUFF, "Corten las flores I", "Los Tréboles hacen 1 menos de daño, las Picas hacen 1 más", "src/resources/sprites/modificadores/CortarFlores1.png", 3));
        modificadores.add(new Modificador(TipoModificador.DEBUFF, "Corten las flores II", "Los Tréboles hacen 2 menos de daño, las Picas hacen 1 más", "src/resources/sprites/modificadores/CortarFlores2.png", 4));
        modificadores.add(new Modificador(TipoModificador.DEBUFF, "Corten las flores III", "Los Tréboles hacen 3 menos de daño, las Picas hacen 1 más", "src/resources/sprites/modificadores/CortarFlores3.png", 5));
        //Debuff picas #6, #7, #8
        modificadores.add(new Modificador(TipoModificador.DEBUFF, "Que le corten la cabeza I", "Las Picas hacen 1 menos de daño, los Tréboles hacen 1 más", "src/resources/sprites/modificadores/CortarCabeza1.png", 6));
        modificadores.add(new Modificador(TipoModificador.DEBUFF, "Que le corten la cabeza II", "Las Picas hacen 2 menos de daño, los Tréboles hacen 1 más", "src/resources/sprites/modificadores/CortarCabeza2.png", 7));
        modificadores.add(new Modificador(TipoModificador.DEBUFF, "Que le corten la cabeza III", "Las Picas hacen 3 menos de daño, los Tréboles hacen 1 más", "src/resources/sprites/modificadores/CortarCabeza3.png", 8));
        //Castelvania #9
        modificadores.add(new Modificador(TipoModificador.DEBUFF, "Castlevania", "<html><div style='width: 200px; text-align: justify;'>Hasta matar al ReyPica, las curaciones restaurarán 1 menos de vida.</div></html>", "src/resources/sprites/modificadores/Castlevania.png", 9));
        //Armas #10, #11, #12
        modificadores.add(new Modificador(TipoModificador.BUFF, "Kit Armamentístico I", "<html><div style='width: 200px; text-align: justify;'>Obtienes un arma entre 2 y 4. Se añaden 3 enemigos débiles.</div></html>", "src/resources/sprites/modificadores/KitArmas1.png", 10));
        modificadores.add(new Modificador(TipoModificador.BUFF, "Kit Armamentístico II", "<html><div style='width: 200px; text-align: justify;'>Obtienes un arma entre 5 y 7. Se añaden 3 enemigos medianamente fuertes.</div></html>", "src/resources/sprites/modificadores/KitArmas2.png", 11));
        modificadores.add(new Modificador(TipoModificador.BUFF, "Kit Armamentístico III", "<html><div style='width: 200px; text-align: justify;'>Obtienes un arma entre 8 y 10. Se añaden 3 enemigos fuertes.</div></html>", "src/resources/sprites/modificadores/KitArmas3.png", 12));
        //Matadragones #13
        modificadores.add(new Modificador(TipoModificador.QUEST, "A por el dragón", "¿Lograrás matarlo?", "src/resources/sprites/modificadores/APorDragon.png", 13));
        //Berserk #14
        modificadores.add(new Modificador(TipoModificador.BUFF, "Berserk", "<html><div style='width: 200px; text-align: justify;'>Las armas hacen 3 más de daño, pero las curaciones restauran 4 menos de vida.</div></html>", "src/resources/sprites/modificadores/Berserker.png", 14));
        //Metabolistmo Rápido #15
        modificadores.add(new Modificador(TipoModificador.BUFF, "Metabolismo Rápido", "Puedes curarte tantas veces como quieras por ronda.", "src/resources/sprites/modificadores/MetabolismoRapido.png", 15));
        //Pies veloces #16
        modificadores.add(new Modificador(TipoModificador.BUFF, "Pies veloces", "Pudes huir hasta dos veces por turno.", "src/resources/sprites/modificadores/PiesVelozes.png", 16));
        //Clérigo #17
        modificadores.add(new Modificador(TipoModificador.BUFF, "Clérigo", "<html><div style='width: 200px; text-align: justify;'>Las curaciones restauran 4 más de vida pero las armas hacen 3 menos de daño.</div><html>", "src/resources/sprites/modificadores/Clerigo.png", 17));
        //Maldición del perdido #18
        modificadores.add(new Modificador(TipoModificador.DEBUFF, "Maldición del perdido", "<html><div style='width: 200px; text-align: justify;'>No puedes huir durante el resto de la partida.</div><html>", "src/resources/sprites/modificadores/MaldicionPerdido.png", 18));
        //¿Sans? #19
        modificadores.add(new Modificador(TipoModificador.QUEST, "¿Sans?", "<html><div style='width: 200px; text-align: justify;'>Mientras siga vivo CincoPica, todos los enemigos hacen 1 más de daño.</div></html>", "src/resources/sprites/modificadores/Sans.png", 19));
        //Sutnami biscosa #20
        modificadores.add(new Modificador(TipoModificador.DEBUFF, "Sutnami Viscoso", "<html><div style='width: 200px; text-align: justify;'>Se agregan 6 doses a la baraja.</div></html>", "src/resources/sprites/modificadores/TsunamiSlimes.png", 20));
        //Herido #21
        modificadores.add(new Modificador(TipoModificador.DEBUFF, "Herido", "<html><div style='width: 200px; text-align: justify;'>Cada dos rondas, pierdes 1 de vida.</div></html>", "src/resources/sprites/modificadores/Herido.png", 21));
        //Herido de gravedad #22
        modificadores.add(new Modificador(TipoModificador.DEBUFF, "Herido de gravedad", "<html><div style='width: 200px; text-align: justify;'>Cada dos rondas, pierdes 3 de vida.</div></html>", "src/resources/sprites/modificadores/GraveHerido.png", 22));
        //Paranoia #23
        modificadores.add(new Modificador(TipoModificador.DEBUFF, "Paranoia", "<html><div style='width: 200px; text-align: justify;'>Cada 5 rondas, no conoces el valor de las cartas añadidas.</div></html>", "src/resources/sprites/modificadores/Paranoia.png", 23));
        //Gastroenteritis (hay un 25% de no curarte puedes no curarte) #24
        modificadores.add(new Modificador(TipoModificador.DEBUFF, "Gastroenteritis", "<html><div style='width: 200px; text-align: justify;'>Hay un 25% de probabilidades de no curarte.</div></html>", "src/resources/sprites/modificadores/Gatronteritis.png", 24));
        //Sin escapatoria #25
        modificadores.add(new Modificador(TipoModificador.DEBUFF, "Sin escapatoria", "<html><div style='width: 200px; text-align: justify;'>Hay un 25% de probabilidad de que no puedas huir.</div></html>", "src/resources/sprites/modificadores/SinEscapatoria.png", 25));
        //Impacto crítico (25% enemigos 50% armas) #26
        modificadores.add(new Modificador(TipoModificador.BUFF, "Impacto Crítico", "<html><div style='width: 200px; text-align: justify;'>50% de pegar el doble y un 25% de recibir 150% de daño.</div></html>", "src/resources/sprites/modificadores/Critico.png", 26));
        //Pentakill #27
        modificadores.add(new Modificador(TipoModificador.BUFF, "Pentakill", "<html><div style='width: 200px; text-align: justify;'>+5 de daño cada 5 enemigos hasta curarse o cambiar arma.</div></html>", "src/resources/sprites/modificadores/Pentakill.png", 27));
        //Fatiga (probabilidad del 10% de fallar el ataque con arma) #28
        modificadores.add(new Modificador(TipoModificador.DEBUFF, "Fatiga", "<html><div style='width: 200px; text-align: justify;'>Probabilidad del 10% de fallar el ataque con arma.</div></html>", "src/resources/sprites/modificadores/Fatiga.png", 28));
        //Último suspiro #29
        modificadores.add(new Modificador(TipoModificador.BUFF, "Último suspiro", "<html><div style='width: 200px; text-align: justify;'>Si fueras a morir, sobrevivirás con una vida. Se resetea cada que superar un nivel.</div></html>", "src/resources/sprites/modificadores/UltimoSuspiro.png", 29));
        //Chupacabras #30
        modificadores.add(new Modificador(TipoModificador.BUFF, "Chupacabras", "<html><div style='width: 200px; text-align: justify;'>Si el arma es más fuerte que el enemigo, te curas 1 de vida.</div></html>", "src/resources/sprites/modificadores/Chupacabras.png", 30));
        //Espinas #31
        modificadores.add(new Modificador(TipoModificador.DEBUFF, "Espinas", "<html><div style='width: 200px; text-align: justify;'>Cada vez que cambias de arma o agarras una nuevo, te haces 1 de daño.</div></html>", "src/resources/sprites/modificadores/Espinas.png", 31));
        //ICD #32
        modificadores.add(new Modificador(TipoModificador.DEBUFF, "ICD", "<html><div style='width: 200px; text-align: justify;'>No puedes ver el número de vidas restantes.</div></html>", "src/resources/sprites/modificadores/ICD.png", 32));
        //Solo Leveling #33
        modificadores.add(new Modificador(TipoModificador.BUFF, "Solo Leveling","<html><div style='width: 200px; text-align: justify;'>Cada mazo completado, obtienes 1 más de vida.</div></html>", "src/resources/sprites/modificadores/SoloLeveling.png", 33));
    }
    public static void aplicarModificador(Modificador modificador, Juego juego) {
        String iconoPequeno = modificador.icono.replace(".png", "Pequeno.png");
        switch (modificador.id) {
            case 0:
                juego.vidaMaxima += 5;
                juego.vidas += 5;
                modificador.icono16 = iconoPequeno;
                break;
            case 1:
                juego.vidaMaxima += 10;
                juego.vidas += 10;
                modificador.icono16 = iconoPequeno;
                break;
            case 2:
                juego.vidaMaxima += 15;
                juego.vidas += 15;
                modificador.icono16 = iconoPequeno;
                break;
            case 3:
                juego.danyoExtraTreboles -= 1;
                juego.danyoExtraPicas += 1;
                modificador.icono16 = iconoPequeno;
                break;
            case 4:
                juego.danyoExtraPicas += 1;
                juego.danyoExtraTreboles -= 2;
                modificador.icono16 = iconoPequeno;
                break;
            case 5:
                juego.danyoExtraPicas += 1;
                juego.danyoExtraTreboles -= 3;
                modificador.icono16 = iconoPequeno;
                break;
            case 6:
                juego.danyoExtraPicas -= 1;
                juego.danyoExtraTreboles += 1;
                modificador.icono16 = iconoPequeno;
                break;
            case 7:
                juego.danyoExtraPicas -= 2;
                juego.danyoExtraTreboles += 1;
                modificador.icono16 = iconoPequeno;
                break;
            case 8:
                juego.danyoExtraPicas -= 3;
                juego.danyoExtraTreboles += 1;
                modificador.icono16 = iconoPequeno;
                break;
            case 9:
                juego.efectoExtraCuracion -= 1;
                modificador.icono16 = iconoPequeno;
                juego.questDracula = true;
                break;
            case 10:
                modArmas(juego, 4, 2);
                modificador.icono16 = iconoPequeno;
                break;
            case 11:
                modArmas(juego, 7, 5);
                modificador.icono16 = iconoPequeno;
                break;
            case 12:
                modArmas(juego, 10, 8);
                modificador.icono16 = iconoPequeno;
                break;
            case 13:
                modificador.icono16 = iconoPequeno;
                juego.questDragon = true;
                break;
            case 14:
                juego.danyoExtraArmas += 3;
                juego.efectoExtraCuracion -= 4;
                modificador.icono16 = iconoPequeno;
                break;
            case 15:
                juego.metabolismoRapido = true;
                modificador.icono16 = iconoPequeno;
                break;
            case 16:
                juego.huir = 2;
                juego.contadorHuir += 1;
                modificador.icono16 = iconoPequeno;
                break;
            case 17:
                juego.efectoExtraCuracion += 4;
                juego.danyoExtraArmas -= 3;
                modificador.icono16 = iconoPequeno;
                break;
            case 18:
                juego.maldicionDelPerdido = true;
                juego.botonHuir.setIcon(new ImageIcon("src/resources/sprites/botones/BotonHuirBloqueado.png"));
                juego.botonHuir.setRolloverEnabled(false);
                modificador.icono16 = iconoPequeno;
                break;
            case 19:
                juego.danyoExtraPicas += 1;
                juego.danyoExtraTreboles += 1;
                modificador.icono16 = iconoPequeno;
                juego.questSans = true;
                break;
            case 20:
                sutnamiSlimes(juego);
                modificador.icono16 = iconoPequeno;
                break;
            case 21:
                juego.herido = true;
                modificador.icono16 = iconoPequeno;
                break;
            case 22:
                juego.heridoGrave = true;
                modificador.icono16 = iconoPequeno;
                break;
            case 23:
                juego.paranoia = true;
                modificador.icono16 = iconoPequeno;
                break;
            case 24:
                juego.gastroenteritis = true;
                modificador.icono16 = iconoPequeno;
                break;
            case 25:
                juego.sinEscapatoria = true;
                modificador.icono16 = iconoPequeno;
                break;
            case 26:
                juego.criticoActivado = true;
                modificador.icono16 = iconoPequeno;
                break;
            case 27:
                juego.pentakill = true;
                juego.contadorPentakill = 0;
                modificador.icono16 = iconoPequeno;
                break;
            case 28:
                juego.fatiga = true;
                modificador.icono16 = iconoPequeno;
                break;
            case 29:
                juego.ultimoSuspiro = true;
                juego.ultimoSuspiroActivado = true;
                modificador.icono16 = iconoPequeno;
                break;
            case 30:
                juego.chupacabras = true;
                modificador.icono16 = iconoPequeno;
                break;
            case 31:
                juego.espinas = true;
                modificador.icono16 = iconoPequeno;
                break;
            case 32:
                juego.ICD = true;
                modificador.icono16 = iconoPequeno;
                break;
            case 33:
                juego.soloLeveling = true;
                modificador.icono16 = iconoPequeno;
            default:
                break;
        }
        setIconoModificador(modificador, juego);
        FuncionActualizar.comprobarVidas(juego);
    }

    public static Modificador obtenerModificador() {
        Collections.shuffle(modificadores);
        Modificador modificador = modificadores.getFirst();
        modificadores.removeFirst();
        return modificador;
    }

    public static void setIconoModificador(Modificador modificador, Juego juego) {
        if (modificador.nombre.contains("Castelvania")) {
            juego.posicionModDracula = juego.contadorModificador;
        }
        if (modificador.nombre.contains("A por")) {
            juego.posicionModDragon = juego.contadorModificador;
        }
        if (modificador.nombre.contains("¿Sans?")) {
            juego.posicionModSans = juego.contadorModificador;
        }
        if (modificador.nombre.contains("Pentakill")) {
            juego.posicionModPentakill = juego.contadorModificador;
        }
        switch (juego.contadorModificador) {
            case 1:
                juego.mod1.setIcon(new ImageIcon(modificador.icono16));
                juego.mod1.setToolTipText("<html><b>" + modificador.nombre + "</b><br>" + modificador.descripcion + "</html>");
                break;
            case 2:
                juego.mod2.setIcon(new ImageIcon(modificador.icono16));
                juego.mod2.setToolTipText("<html><b>" + modificador.nombre + "</b><br>" + modificador.descripcion + "</html>");
                break;
            case 3:
                juego.mod3.setIcon(new ImageIcon(modificador.icono16));
                juego.mod3.setToolTipText("<html><b>" + modificador.nombre + "</b><br>" + modificador.descripcion + "</html>");
                break;
            case 4:
                juego.mod4.setIcon(new ImageIcon(modificador.icono16));
                juego.mod4.setToolTipText("<html><b>" + modificador.nombre + "</b><br>" + modificador.descripcion + "</html>");
                break;
            case 5:
                juego.mod5.setIcon(new ImageIcon(modificador.icono));
                juego.mod5.setToolTipText("<html><b>" + modificador.nombre + "</b><br>" + modificador.descripcion + "</html>");
                break;
            case 6:
                juego.mod6.setIcon(new ImageIcon(modificador.icono));
                juego.mod6.setToolTipText("<html><b>" + modificador.nombre + "</b><br>" + modificador.descripcion + "</html>");
                break;
            case 7:
                juego.mod7.setIcon(new ImageIcon(modificador.icono));
                juego.mod7.setToolTipText("<html><b>" + modificador.nombre + "</b><br>" + modificador.descripcion + "</html>");
                break;
            case 8:
                juego.mod8.setIcon(new ImageIcon(modificador.icono));
                juego.mod8.setToolTipText("<html><b>" + modificador.nombre + "</b><br>" + modificador.descripcion + "</html>");
                break;
            case 9:
                juego.mod9.setIcon(new ImageIcon(modificador.icono));
                juego.mod9.setToolTipText("<html><b>" + modificador.nombre + "</b><br>" + modificador.descripcion + "</html>");
                break;
            case 10:
                juego.mod10.setIcon(new ImageIcon(modificador.icono));
                juego.mod10.setToolTipText("<html><b>" + modificador.nombre + "</b><br>" + modificador.descripcion + "</html>");
                break;
            default:
                break;
        }
        juego.contadorModificador++;
    }

    private static void modArmas(Juego juego, int max, int min) {
        int armaAleatoria = (int) (Math.random() * (max - min) + min);
        for (Carta.Valor valor : Carta.Valor.values()) {
            if (valor.valor == armaAleatoria) {
                juego.cartaArmaSeleccionada = new Carta(Carta.Palo.Diamante, valor);
                juego.cartaArmaSeleccionadaLabel.setIcon(new ImageIcon(juego.cartaArmaSeleccionada.imagenCarta));
            }
        }
        for (int i = 0; i < 3; i++) {
            int numeroEnemigo = (int) Math.floor(Math.random() * (max - min) + min);
            for (Carta.Valor valor : Carta.Valor.values()) {
                if (valor.valor == numeroEnemigo) {
                    if (i % 2 == 0) {
                        Juego.cartasMazo.add(new Carta(Carta.Palo.Pica, valor));
                    } else {
                        Juego.cartasMazo.add(new Carta(Carta.Palo.Trebol, valor));
                    }
                }
            }
            Collections.shuffle(Juego.cartasMazo);
            FuncionActualizar.setNumCartas(juego);
        }
    }

    public static void sutnamiSlimes(Juego juego) {
        for (int i = 0; i < 6; i++) {
            if (i % 2 == 0) {
                Juego.cartasMazo.add(new Carta(Carta.Palo.Pica, Carta.Valor.Dos));
            } else {
                Juego.cartasMazo.add(new Carta(Carta.Palo.Trebol, Carta.Valor.Dos));
            }
        }
        Collections.shuffle(Juego.cartasMazo);
        FuncionActualizar.setNumCartas(juego);
    }

    public static void questDracula(Juego juego) {
        juego.efectoExtraCuracion += 4;
        String iconoPequenyo = "src/resources/sprites/modificadores/DraculaDerrotadoPequeno.png";
        switch (juego.posicionModDracula) {
            case 1:
                juego.mod1.setIcon(new ImageIcon(iconoPequenyo));
                juego.mod1.setToolTipText("<html><b>Fin del terror</b><br>Las curaciones te curan 3 más</html>");
                break;
            case 2:
                juego.mod2.setIcon(new ImageIcon(iconoPequenyo));
                juego.mod2.setToolTipText("<html><b>Fin del terror</b><br>Las curaciones te curan 3 más</html>");
                break;
            case 3:
                juego.mod3.setIcon(new ImageIcon(iconoPequenyo));
                juego.mod3.setToolTipText("<html><b>Fin del terror</b><br>Las curaciones te curan 3 más</html>");
                break;
            case 4:
                juego.mod4.setIcon(new ImageIcon(iconoPequenyo));
                juego.mod4.setToolTipText("<html><b>Fin del terror</b><br>Las curaciones te curan 3 más</html>");
                break;
            case 5:
                juego.mod5.setIcon(new ImageIcon(iconoPequenyo));
                juego.mod5.setToolTipText("<html><b>Fin del terror</b><br>Las curaciones te curan 3 más</html>");
                break;
            case 6:
                juego.mod6.setIcon(new ImageIcon(iconoPequenyo));
                juego.mod6.setToolTipText("<html><b>Fin del terror</b><br>Las curaciones te curan 3 más</html>");
                break;
            case 7:
                juego.mod7.setIcon(new ImageIcon(iconoPequenyo));
                juego.mod7.setToolTipText("<html><b>Fin del terror</b><br>Las curaciones te curan 3 más</html>");
                break;
            case 8:
                juego.mod8.setIcon(new ImageIcon(iconoPequenyo));
                juego.mod8.setToolTipText("<html><b>Fin del terror</b><br>Las curaciones te curan 3 más</html>");
                break;
            case 9:
                juego.mod9.setIcon(new ImageIcon(iconoPequenyo));
                juego.mod9.setToolTipText("<html><b>Fin del terror</b><br>Las curaciones te curan 3 más</html>");
                break;
            case 10:
                juego.mod10.setIcon(new ImageIcon(iconoPequenyo));
                juego.mod10.setToolTipText("<html><b>Fin del terror</b><br>Las curaciones te curan 3 más</html>");
                break;
            default:
                break;
        }
    }

    public static void questDragon(Juego juego) {
        juego.danyoExtraArmas += 2;
        String iconoPequenyo = "src/resources/sprites/modificadores/DragonDerrotadoPequeno.png";
        switch (juego.posicionModDragon) {
            case 1:
                juego.mod1.setIcon(new ImageIcon(iconoPequenyo));
                juego.mod1.setToolTipText("<html><b>Dovahkiin</b><br>Tus armas ahora están potenciadas (+2 daño)</html>");
                break;
            case 2:
                juego.mod2.setIcon(new ImageIcon(iconoPequenyo));
                juego.mod2.setToolTipText("<html><b>Dovahkiin</b><br>Tus armas ahora están potenciadas (+2 daño)</html>");
                break;
            case 3:
                juego.mod3.setIcon(new ImageIcon(iconoPequenyo));
                juego.mod3.setToolTipText("<html><b>Dovahkiin</b><br>Tus armas ahora están potenciadas (+2 daño)</html>");
                break;
            case 4:
                juego.mod4.setIcon(new ImageIcon(iconoPequenyo));
                juego.mod4.setToolTipText("<html><b>Dovahkiin</b><br>Tus armas ahora están potenciadas (+2 daño)</html>");
                break;
            case 5:
                juego.mod5.setIcon(new ImageIcon(iconoPequenyo));
                juego.mod5.setToolTipText("<html><b>Dovahkiin</b><br>Tus armas ahora están potenciadas (+2 daño)</html>");
                break;
            case 6:
                juego.mod6.setIcon(new ImageIcon(iconoPequenyo));
                juego.mod6.setToolTipText("<html><b>Dovahkiin</b><br>Tus armas ahora están potenciadas (+2 daño)</html>");
                break;
            case 7:
                juego.mod7.setIcon(new ImageIcon(iconoPequenyo));
                juego.mod7.setToolTipText("<html><b>Dovahkiin</b><br>Tus armas ahora están potenciadas (+2 daño)</html>");
                break;
            case 8:
                juego.mod8.setIcon(new ImageIcon(iconoPequenyo));
                juego.mod8.setToolTipText("<html><b>Dovahkiin</b><br>Tus armas ahora están potenciadas (+2 daño)</html>");
                break;
            case 9:
                juego.mod9.setIcon(new ImageIcon(iconoPequenyo));
                juego.mod9.setToolTipText("<html><b>Dovahkiin</b><br>Tus armas ahora están potenciadas (+2 daño)</html>");
                break;
            case 10:
                juego.mod10.setIcon(new ImageIcon(iconoPequenyo));
                juego.mod10.setToolTipText("<html><b>Dovahkiin</b><br>Tus armas ahora están potenciadas (+2 daño)</html>");
                break;
            default:
                break;
        }
    }

    public static void questSans(Juego juego) {
        juego.danyoExtraArmas += 2;
        juego.danyoExtraPicas -= 1;
        juego.danyoExtraTreboles -= 1;
        String iconoPequenyo = "src/resources/sprites/modificadores/SansDerrotadoPequeno.png";
        switch (juego.posicionModSans) {
            case 1:
                juego.mod1.setIcon(new ImageIcon(iconoPequenyo));
                juego.mod1.setToolTipText("<html><b>Pasaste un mal rato</b><br>Los genocidas obtienen +2 daño</html>");
                break;
            case 2:
                juego.mod2.setIcon(new ImageIcon(iconoPequenyo));
                juego.mod2.setToolTipText("<html><b>Pasaste un mal rato</b><br>Los genocidas obtienen +2 daño</html>");
                break;
            case 3:
                juego.mod3.setIcon(new ImageIcon(iconoPequenyo));
                juego.mod3.setToolTipText("<html><b>Pasaste un mal rato</b><br>Los genocidas obtienen +2 daño</html>");
                break;
            case 4:
                juego.mod4.setIcon(new ImageIcon(iconoPequenyo));
                juego.mod4.setToolTipText("<html><b>Pasaste un mal rato</b><br>Los genocidas obtienen +2 daño</html>");
                break;
            case 5:
                juego.mod5.setIcon(new ImageIcon(iconoPequenyo));
                juego.mod5.setToolTipText("<html><b>Pasaste un mal rato</b><br>Los genocidas obtienen +2 daño</html>");
                break;
            case 6:
                juego.mod6.setIcon(new ImageIcon(iconoPequenyo));
                juego.mod6.setToolTipText("<html><b>Pasaste un mal rato</b><br>Los genocidas obtienen +2 daño</html>");
                break;
            case 7:
                juego.mod7.setIcon(new ImageIcon(iconoPequenyo));
                juego.mod7.setToolTipText("<html><b>Pasaste un mal rato</b><br>Los genocidas obtienen +2 daño</html>");
                break;
            case 8:
                juego.mod8.setIcon(new ImageIcon(iconoPequenyo));
                juego.mod8.setToolTipText("<html><b>Pasaste un mal rato</b><br>Los genocidas obtienen +2 daño</html>");
                break;
            case 9:
                juego.mod9.setIcon(new ImageIcon(iconoPequenyo));
                juego.mod9.setToolTipText("<html><b>Pasaste un mal rato</b><br>Los genocidas obtienen +2 daño</html>");
                break;
            case 10:
                juego.mod10.setIcon(new ImageIcon(iconoPequenyo));
                juego.mod10.setToolTipText("<html><b>Pasaste un mal rato</b><br>Los genocidas obtienen +2 daño</html>");
                break;
            default:
                break;
        }
    }
}

