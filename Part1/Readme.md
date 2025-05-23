# Streaming Service Binge Mode - Iterator Pattern

## Описание

В данном проекте реализован паттерн **Iterator** для платформы потокового видео (аналог Netflix), где необходимо обеспечить возможность обхода эпизодов сериала без учета структуры хранения (будь то ArrayList, LinkedList или ленивый загрузчик файлов). Проект включает в себя создание разных типов итераторов для обхода сезонов сериала, включая стандартный порядок, обратный порядок и случайный порядок с фиксированным сидом.

## Задача

Необходимо разработать систему для итерации по эпизодам сериала, где каждый сезон содержит несколько эпизодов. Для каждого сезона нужно реализовать итераторы для различных типов обхода (нормальный, обратный и случайный), и предоставить интерфейс для получения эпизодов сериала, не заботясь о внутреннем представлении данных.

### Ключевые особенности:
- Использование паттерна **Iterator** для унифицированного доступа к эпизодам.
- Реализация различных итераторов: обычный порядок, обратный порядок и случайный порядок.
- Реализация интерфейса **Iterable** для класса **Season**, чтобы можно было использовать `for-each` для перебора эпизодов.
- Реализация **BingeIterator**, который позволяет «перемещаться» по всем сезонам сериала, начиная с первого эпизода первого сезона.

## Структура проекта

Проект состоит из следующих классов:

- **Episode**: Класс, представляющий эпизод сериала с названием и продолжительностью.
- **IEpisodeIterator**: Интерфейс для итераторов эпизодов, содержащий методы `hasNext()` и `next()`.
- **Season**: Класс, представляющий сезон сериала, с добавлением эпизодов и возможностью получения итераторов.
- **SeasonIterator**: Итератор для обхода эпизодов сезона в прямом порядке.
- **ReverseSeasonIterator**: Итератор для обхода эпизодов сезона в обратном порядке.
- **ShuffleSeasonIterator**: Итератор для обхода эпизодов сезона в случайном порядке с фиксированным сидом.
- **Series**: Класс, представляющий сериал с несколькими сезонами.
- **BingeIterator**: Итератор, который объединяет все сезоны сериала, позволяя просматривать эпизоды последовательно, без необходимости вручную переходить от сезона к сезону.

## Паттерн Iterator

Паттерн **Iterator** используется для абстракции процесса перебора коллекции элементов (в данном случае, эпизодов сериала). Вместо того, чтобы напрямую работать с коллекциями эпизодов, пользователи могут использовать итераторы для получения элементов по порядку. Это позволяет легко добавлять новые способы обхода коллекции, не изменяя основной код.

### Преимущества Iterator:
- Упрощение интерфейса, так как коллекции скрыты от пользователя, который взаимодействует только с итератором.
- Возможность реализации различных стратегий обхода коллекции (например, обычный, обратный или случайный порядок) без изменения структуры данных.

### Недостатки Iterator:
- Может добавить сложность, если коллекции слишком простые, и достаточно просто работать с ними напрямую.

## Итераторы

Проект реализует несколько типов итераторов для коллекции эпизодов:

- **SeasonIterator** — обходит эпизоды в обычном порядке.
- **ReverseSeasonIterator** — обходит эпизоды в обратном порядке.
- **ShuffleSeasonIterator** — обходит эпизоды в случайном порядке, используя фиксированный сид для повторяемости.

## Пример использования

Пример демонстрирует создание сезона с несколькими эпизодами и использование различных итераторов для их обхода.

```java
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
 