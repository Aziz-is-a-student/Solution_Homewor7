package Part1;

import java.util.ArrayList;
import java.util.List;
// Класс сериала. Хранит сезоны.
public class Series {
    private List<Season> seasons = new ArrayList<>();

    public void addSeason(Season s) {
        seasons.add(s);
    }

    public List<Season> getSeasons() {
        return seasons;
    }
}
