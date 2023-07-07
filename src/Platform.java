import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Platform {
    private String name;
    private Map<String, List<Film>> categories;

    public Platform(String name) {
        this.name = name;
        this.categories = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, List<Film>> getCategories() {
        return categories;
    }

    public void setCategories(Map<String, List<Film>> categories) {
        this.categories = categories;
    }


    public void addCategory(String category) {
        categories.put(category, new ArrayList<>());
    }

    public void addFilm(String category, String filmTitle) {
        List<Film> films = categories.get(category);
        Film film = new Film(filmTitle, category);
        films.add(film);
    }

    public List<Film> getFilmsByCategory(String category) {
        return categories.getOrDefault(category, new ArrayList<>());
    }

    public int getTotalFilmCount() {
        int totalCount = 0;
        for (List<Film> films : categories.values()) {
            totalCount += films.size();
        }
        return totalCount;
    }
}
