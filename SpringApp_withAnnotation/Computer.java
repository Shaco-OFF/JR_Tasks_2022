package SpringApp_withAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Computer {
    private int id;
    private MusicPlayer musicPlayer;

    private MusicalGenres genre;

    public void setGenre(MusicalGenres genre) {
        this.genre = genre;
    }

    //Прописываем зависимость от бина MusicPlayer, который в свою очередь также имеет зависимость от бина с типом Music
    @Autowired
    public Computer(MusicPlayer musicPlayer) {
        this.id = 1;
        this.musicPlayer = musicPlayer;
    }

    @Override
    public String toString() {
        return "Computer " + id + " " + musicPlayer.playMusic(genre);
    }
}
