package SpringApp_withAnnotation;

import org.springframework.stereotype.Component;

;import java.util.ArrayList;
import java.util.List;

/**
 * @author Neil Alishev
 */
@Component
public class ClassicalMusic implements Music {
    public static List<String> classicalMusicSongs = new ArrayList<>();

    static {
        classicalMusicSongs.add("Classical song #1");
        classicalMusicSongs.add("Classical song #2");
        classicalMusicSongs.add("Classical song #3");
    }
    @Override
    public List<String> getList() {
        return classicalMusicSongs;
    }
}
