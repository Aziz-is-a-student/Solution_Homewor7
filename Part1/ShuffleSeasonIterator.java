package Part1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

// Итератор по эпизодам в случайном порядке с фиксированным сидом
public class ShuffleSeasonIterator implements IEpisodeIterator {
    private List<Episode> shuffled;
    private int index = 0;

    public ShuffleSeasonIterator(List<Episode> episodes, long seed) {
        // Копируем список, чтобы не менять оригинал
        shuffled = new ArrayList<>(episodes);
        Collections.shuffle(shuffled, new Random(seed)); // фиксируем порядок
    }

    public boolean hasNext() {
        return index < shuffled.size();
    }

    public Episode next() {
        return shuffled.get(index++);
    }
}