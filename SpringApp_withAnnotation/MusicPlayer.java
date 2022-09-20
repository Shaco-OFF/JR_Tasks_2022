package SpringApp_withAnnotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

/**
 * @author Neil Alishev
 */
@Component
public class MusicPlayer {
    /*
    Внедрение зависимости @Autowired происходит через конструктор/сеттер/поле (последнее не рекомендуется, т.к.
    используется Рефлексия). Способ внедрения в проект лучше использовать один и тот же.
    */
    private Music music1;
    private Music music2;
    @Autowired
    public MusicPlayer(@Qualifier("rockMusic") Music music1,
                       @Qualifier("classicalMusic") Music music2) {
        this.music1 = music1;
        this.music2 = music2;
    }
    /*
        @Component - аннотация, указание Spring создать бин
        @Autowired - аннотация, указание зависимости между бинами
        @Qualifier - аннотация для уточнения id бина для внедрения зависимости
        Если мы в качестве аргумента передаем интерфейс, то Spring сканирует все бины, которые реализует данный интерфейс
        В случае, если под аннотацию @Autowired подходит несколько бинов (например @Component есть у двух классов, реализующих
        данный интерфейс), то Spring выдаст ошибку, т.к. не понимает для какого бина прописывать зависимость.
        @Autowired
        public MusicPlayer(Music music) {
            this.music = music;
        }
        */
    public String playMusic(MusicalGenres genre) {
        String playingSong = "";
        List<String> playList;
        Random random = new Random();

        switch (genre) {
            case ROCK:
                playList = music1.getList();
                playingSong = playList.get(random.nextInt(playList.size()));
                break;
            case CLASSICAL:
                playList = music2.getList();
                playingSong = playList.get(random.nextInt(playList.size()));
                break;
        }
        return playingSong;
    }
}
