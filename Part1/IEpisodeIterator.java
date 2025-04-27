package Part1;
// Интерфейс, который нужно реализовать для итерации по эпизодам
public interface IEpisodeIterator {
    boolean hasNext();
    Episode next();
}
