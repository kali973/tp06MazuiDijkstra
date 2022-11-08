package com.example.telecom.paris.maze.ui;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;


public class MusicTest {

    public void RunMusic(String filepath) {
        try {

            File MusicPath = new File(filepath);

            if (MusicPath.exists()) {

                AudioInputStream audioInput = AudioSystem.getAudioInputStream(MusicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                //clip.loop(Clip.LOOP_CONTINUOUSLY);


            } else {
                System.out.println("fichier introuvable");
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }
}
