package Part1;

import java.util.List;

// Итератор по эпизодам сезона в прямом порядке
public class SeasonIterator implements IEpisodeIterator {
    private List<Episode> episodes;
    private int index = 0;

    public SeasonIterator(List<Episode> episodes) {
        this.episodes = episodes;
    }

    public boolean hasNext() {
        return index < episodes.size();
    }

    public Episode next() {
        return episodes.get(index++);
    }
}
