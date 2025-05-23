package Part1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Класс сезона. Здесь храним эпизоды.
public class Season implements Iterable<Episode> {
    private List<Episode> episodes = new ArrayList<>();

    public void addEpisode(Episode e) {
        episodes.add(e);
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    @Override
    public Iterator<Episode> iterator() {
        return episodes.iterator(); // стандартный Java итератор для for-each
    }

    //Кастомный итератор по умолчанию
    public IEpisodeIterator getEpisodeIterator() {
        return new SeasonIterator(episodes); // обычный порядок
    }
}