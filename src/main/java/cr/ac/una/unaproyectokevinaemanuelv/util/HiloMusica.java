/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.unaproyectokevinaemanuelv.util;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author kevin
 */
public class HiloMusica extends Thread {
    String mensaje;
    String sonido;
    int timeRep=0;
    boolean stop=false;
    public HiloMusica(){
        mensaje="Hola";
    }
    public HiloMusica(String sonido){
        this.sonido=sonido;
    }
    public HiloMusica(String sonido,boolean stop){
        this.sonido=sonido;
        stop=false;
    }
    public void run(){
        repSonido(sonido);
        System.out.println("Este proceso ha terminado:"+this.getName());
    }

    public void setMensaje(String msj){
        this.mensaje = msj;
    }
    
    public void repSonido(String sonido){
        SourceDataLine soundLine = null;
        int BUFFER_SIZE = 64*1024;  // 64 KB
        // Set up an audio input stream piped from the sound file.
        try {
           File soundFile = new File(sonido);
           AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
           AudioFormat audioFormat = audioInputStream.getFormat();
           DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
           soundLine = (SourceDataLine) AudioSystem.getLine(info);
           soundLine.open(audioFormat);
           soundLine.start();
           int nBytesRead = 0;
           byte[] sampledData = new byte[BUFFER_SIZE];
           while (nBytesRead != -1) {
              nBytesRead = audioInputStream.read(sampledData, 0, sampledData.length);
              if (nBytesRead >= 0) {
                 // Writes audio data to the mixer via this source data line.
                 soundLine.write(sampledData, 0, nBytesRead);
              }
           }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.err.println("Error: "+ex.getMessage());
        } finally {
           soundLine.drain();
           soundLine.close();
        }
    }
}
