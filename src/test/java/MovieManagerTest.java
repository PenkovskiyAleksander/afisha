import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {

    Movie movie1 = new Movie(1, "Фильм 1");
    Movie movie2 = new Movie(2, "Фильм 2");
    Movie movie3 = new Movie(3, "Фильм 3");
    Movie movie4 = new Movie(4, "Фильм 4");
    Movie movie5 = new Movie(5, "Фильм 5");
    Movie movie6 = new Movie(6, "Фильм 6");

    @Test
    public void shouldShowEmptyArrayWhenNoMoviesAdded() {
        MovieManager manager = new MovieManager();
        Movie[] expected = new Movie[0];
        Movie[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);

        Movie[] actualLast = manager.findLast();
        Assertions.assertArrayEquals(expected, actualLast);
    }

    @Test
    public void shouldAddAndFindAllMovies() {
        MovieManager manager = new MovieManager();
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);

        Movie[] expected = {movie1, movie2, movie3};
        Movie[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnAllMoviesInReverseWhenLessThanLimit() {
        MovieManager manager = new MovieManager(); // limit = 5
        manager.add(movie1);
        manager.add(movie2);

        // Добавили 2 фильма. Лимит 5. Должно вернуть 2 фильма в обратном порядке.
        Movie[] expected = {movie2, movie1};
        Movie[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnLastFiveMoviesInReverseWhenMoreThanLimit() {
        MovieManager manager = new MovieManager(); // limit = 5
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);
        manager.add(movie6);

        // Добавили 6 фильмов. Лимит 5. Должен вернуть последние 5 в обратном порядке.
        Movie[] expected = {movie6, movie5, movie4, movie3, movie2};
        Movie[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnCustomLimitInReverse() {
        MovieManager manager = new MovieManager(3); // Кастомный лимит = 3
        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);

        // Лимит 3. Вернет последние 3.
        Movie[] expected = {movie5, movie4, movie3};
        Movie[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
}