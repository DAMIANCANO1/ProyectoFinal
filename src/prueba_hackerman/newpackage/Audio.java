/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba_hackerman.newpackage;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

/**
 *
 * @author canod
 */
public class Audio {
    private static Clip musicaFondoActual;
    public static void reproducirEfecto(String ruta) {
        try {
            URL url = Audio.class.getResource(ruta); 
            if (url != null) {
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.start(); 
            } else {
                System.out.println(" No se encontró efecto -> " + ruta);
            }
        } catch (Exception e) {
            System.out.println("Error de efecto  " + e.getMessage());
        }
    }
    public static void iniciarMusicaFondo(String ruta) {
        detenerMusicaFondo();

        try {
            URL url = Audio.class.getResource(ruta);
            if (url != null) {
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
                musicaFondoActual = AudioSystem.getClip();
                musicaFondoActual.open(audioIn);
                musicaFondoActual.loop(Clip.LOOP_CONTINUOUSLY); 
            } else {
                System.out.println("LOG DE AUDIO: No se encontró música -> " + ruta);
            }
        } catch (Exception e) {
            System.out.println("LOG DE AUDIO: Error de música -> " + e.getMessage());
        }
    }

    public static void detenerMusicaFondo() {
        if (musicaFondoActual != null && musicaFondoActual.isRunning()) {
            musicaFondoActual.stop();
            musicaFondoActual.close(); 
        }
    }
}
    

