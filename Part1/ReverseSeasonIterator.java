package Part1;

import java.util.List;

// Итератор по эпизодам в обратном порядке
public class ReverseSeasonIterator implements IEpisodeIterator {
    private List<Episode> episodes;
    private int index;

    public ReverseSeasonIterator(List<Episode> episodes) {
        this.episodes = episodes;
        this.index = episodes.size() - 1; // начинаем с конца
    }

    public boolean hasNext() {
        return index >= 0;
    }

    public Episode next() {
        return episodes.get(index--);
    }
}