package JuegoQuest.Funciones;
import JuegoQuest.Juego;
import JuegoQuest.Juego.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;

import static JuegoQuest.Juego.SonidosJuego;

public class FuncionSonido {
    public Clip reproductor;
    public AudioInputStream reproducirAudio;
    public FuncionSonido(SonidosJuego sonido) {
        try {
            reproductor = AudioSystem.getClip();
            reproducirAudio = null;
            if (sonido == SonidosJuego.GirarCarta){
                reproducirAudio = AudioSystem.getAudioInputStream(new File(SonidosJuego.GirarCarta.getSonido()));
            } else if (sonido == SonidosJuego.PonerCarta) {
                reproducirAudio = AudioSystem.getAudioInputStream(new File(SonidosJuego.PonerCarta.getSonido()));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void reproducirSonido(){
        try {
            Thread hilo = new Thread(new Runnable(){
                public void run(){
                    try {
                        reproductor.open(reproducirAudio);
                        reproductor.start();
                        while (reproductor.isRunning()) {

                        }
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            });
            hilo.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public FuncionSonido() {
        try {
            reproductor = AudioSystem.getClip();
            reproducirAudio = AudioSystem.getAudioInputStream(new File("src/resources/sounds/musica.wav"));
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void ponerMusica(){
        try {
            Thread hilo = new Thread(new Runnable(){
                public void run(){
                    try {
                        reproductor.open(reproducirAudio);
                        FloatControl controlVolumen = (FloatControl) reproductor.getControl(FloatControl.Type.MASTER_GAIN);
                        float min = controlVolumen.getMinimum(); // Volumen mínimo en dB
                        float max = 0.0f; // Volumen máximo en dB (normal)
                        float volumenDB = min + (max - min) * 0.99f;
                        controlVolumen.setValue(volumenDB);
                        reproductor.start();
                        while (reproductor.isRunning()) {

                        }
                        if(!reproductor.isRunning()){
                            run();
                        }
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            });
            hilo.start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}