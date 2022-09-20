package SpringApp_1;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
    private List<Music> musicList = new ArrayList<>();

    private String name;
    private int volume;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    //Inversion of Control (IoC) - Внедрение зависимостей (пример паттерна)

    /*
    Внедрение через конструктор (добавление тега constructor-arg ref="refIdBean" в applicationContext.xml)
    public MusicPlayer(Music music) {
        this.music = music;
    }
    */

    /*
    Внедрение через сеттер (добавление тега property name="setterName" ref="refIdBean" в applicationContext.xml)
    Spring создает Bean, используя пустой конструктор, а потом вызывает сеттер по name и передает в него ссылку на
    другой Bean, указанный в ref
    */
    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }

    public void playMusic() {
        for (Music music : musicList) {
            System.out.println("Playing: " + music.getSong());
        }
    }
}
