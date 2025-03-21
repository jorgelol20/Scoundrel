package JuegoNormal.Funciones;

import Menus.Main;

import static JuegoNormal.Juego.*;

import javax.sound.sampled.*;
import java.io.File;

public class FuncionSonido {
    public Clip reproductor;
    public AudioInputStream reproducirAudio;
    public FloatControl controlVolumen;

    public FuncionSonido(SonidosJuego sonido) {
        try {
            reproductor = AudioSystem.getClip();
            reproducirAudio = null;
            if (sonido == SonidosJuego.GirarCarta) {
                reproducirAudio = AudioSystem.getAudioInputStream(new File(SonidosJuego.GirarCarta.getSonido()));
            } else if (sonido == SonidosJuego.PonerCarta) {
                reproducirAudio = AudioSystem.getAudioInputStream(new File(SonidosJuego.PonerCarta.getSonido()));
            } else if (sonido == SonidosJuego.SonidoBotones) {
                reproducirAudio = AudioSystem.getAudioInputStream(new File(SonidosJuego.SonidoBotones.getSonido()));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void reproducirSonido() {
        try {
            Thread hilo = new Thread(new Runnable() {
                public void run() {
                    try {
                        reproductor.open(reproducirAudio);
                        FloatControl controlVolumen = (FloatControl) reproductor.getControl(FloatControl.Type.MASTER_GAIN);
                        float min = controlVolumen.getMinimum(); // Volumen mínimo en dB
                        float max = 0.0f; // Volumen máximo en dB (normal)
                        float volumenDB;
                        volumenDB = min + (max - min) * Main.valorVolumenSonidos;
                        controlVolumen.setValue(volumenDB);
                        reproductor.start();
                        while (reproductor.isRunning()) {

                        }
                    } catch (Exception e) {
                        System.out.println("Error Sonidos");
                        System.out.println(e.getMessage());
                    }
                }
            });
            hilo.start();
        } catch (Exception e) {
            System.out.println("Error Sonidos");
            System.out.println(e.getMessage());
        }
    }

    public FuncionSonido() {
        try {
            reproductor = AudioSystem.getClip();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void ponerMusica() {
        try {
            Thread hilo = new Thread(new Runnable() {
                public void run() {
                    try {
                        while (true) {
                                reproductor.close();
                                reproductor.stop();
                                reproducirAudio = AudioSystem.getAudioInputStream(new File("src/resources/sounds/musica.wav"));
                                reproductor.open(reproducirAudio);
                                controlVolumen = (FloatControl) reproductor.getControl(FloatControl.Type.MASTER_GAIN);
                                float min = controlVolumen.getMinimum();
                                float max = 0.0f;
                                float volumenDB = min + (max - min) * Main.valorVolumenMusica;
                                controlVolumen.setValue(volumenDB);
                                reproductor.start();
                                Thread.sleep(117000);
                        }
                    }catch (Exception e) {
                        System.out.println("Error Sonidos");
                        System.out.println(e.getMessage());
                    }
                }
            });
            hilo.start();
        } catch (Exception e) {
            ponerMusica();
            System.out.println(e.getMessage());
        }
    }
}