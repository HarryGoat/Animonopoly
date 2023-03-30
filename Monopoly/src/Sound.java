import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Sound {

    public void PlayMusic ()
    {
        String filepath = "themeSong.wav";
        try {
            File musicPath = new File(filepath);

            if (musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            else {
                System.out.println("Cannot find file");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void PlayAnimalSound (String animalFile)
    {
        try {
            File musicPath = new File(animalFile);

            if (musicPath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            }
            else {
                System.out.println("Cannot find file");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}

// :]