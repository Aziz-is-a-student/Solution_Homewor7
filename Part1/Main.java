package Part1;

public class Main {
    public static void main(String[] args) {
        Season season1 = new Season();
        season1.addEpisode(new Episode("Pilot", 1800));
        season1.addEpisode(new Episode("Episode 2", 1750));
        season1.addEpisode(new Episode("Episode 3", 1900));

        System.out.println("Обычный порядок");
        IEpisodeIterator normalIt = new SeasonIterator(season1.getEpisodes());
        while (normalIt.hasNext()) {
            System.out.println(normalIt.next());
        }

        System.out.println("Обратный порядок ");
        IEpisodeIterator reverseIt = new ReverseSeasonIterator(season1.getEpisodes());
        while (reverseIt.hasNext()) {
            System.out.println(reverseIt.next());
        }

        System.out.println("Случайный порядок ");
        IEpisodeIterator shuffleIt = new ShuffleSeasonIterator(season1.getEpisodes(), 42);
        while (shuffleIt.hasNext()) {
            System.out.println(shuffleIt.next());
        }
    }
}

