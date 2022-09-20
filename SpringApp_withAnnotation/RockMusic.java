package SpringApp_withAnnotation;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Neil Alishev
 */
@Component
public class RockMusic implements Music {
    public static List<String> rockListSongs = new ArrayList<>();

    static {
        rockListSongs.add("Rock song #1");
        rockListSongs.add("Rock song #2");
        rockListSongs.add("Rock song #3");
    }
    @Override
    public List<String> getList() {
        return rockListSongs;
    }
}
