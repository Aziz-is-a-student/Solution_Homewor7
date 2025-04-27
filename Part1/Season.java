package Part1;

import java.util.ArrayList;
import java.util.List;

// Класс сезона. Здесь храним эпизоды.
public class Season {
    private List<Episode> episodes = new ArrayList<>();

    public void addEpisode(Episode e) {
        episodes.add(e);
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }
}
