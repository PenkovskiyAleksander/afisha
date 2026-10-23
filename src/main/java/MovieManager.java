public class MovieManager {
    private Movie[] movies = new Movie[0];
    private int limit;

    // Конструктор по умолчанию
    public MovieManager() {
        this.limit = 5;
    }

    // Конструктор с параметром
    public MovieManager(int limit) {
        this.limit = limit;
    }

    // Добавление фильма
    public void add(Movie movie) {
        Movie[] tmp = new Movie[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    // Вывод всех фильмов в порядке добавления
    public Movie[] findAll() {
        return movies;
    }

    // Вывод последних фильмов в обратном порядке
    public Movie[] findLast() {
        int resultLength;
        if (movies.length < limit) {
            resultLength = movies.length;
        } else {
            resultLength = limit;
        }

        Movie[] result = new Movie[resultLength];
        for (int i = 0; i < resultLength; i++) {
            // Заполняем в обратном порядке (с конца массива)
            result[i] = movies[movies.length - 1 - i];
        }
        return result;
    }
}
