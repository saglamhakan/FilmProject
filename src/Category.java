import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Category {
    private String name;
    private Map<String, List<Film>> categories; //Kategorilere göre filmleri tutmak için kullanılır

    public Category(String name) {
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


    public void addCategory(String category) { //Listeye kategori eklemek için kullanılır
        categories.put(category, new ArrayList<>());
    }

    public void addFilm(String category, String filmTitle, int year, String direction, double imdbRating) {
        List<Film> films = categories.get(category);
        Film film = new Film(filmTitle, category, year, direction, imdbRating);
        films.add(film);
    }

    public List<Film> getFilmsByCategory(String category) { //Belli bir kategoriden filmleri görmek için kullanılır.
        return categories.getOrDefault(category, new ArrayList<>()); //getOrDefault kategoriye ait film listesi yoksa boş liste dönderir
    }

    public int getTotalFilmCount() { //Film listelerini dolaşır, her film listesinin (size) ini alır toplam film sayısına ekler, Sonra bunu döner
        int totalCount = 0;
        for (List<Film> films : categories.values()) {
            totalCount += films.size();
        }
        return totalCount;
    }
}
