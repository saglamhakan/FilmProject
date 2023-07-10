import java.util.ArrayList;
import java.util.List;

public class FilmPlatform {

    private List<Category> categories; //platforms adında platform filminin classının örneklerini içeren bi liste

    public List<Category> getPlatforms() {
        return categories;
    }

    public void setPlatforms(List<Category> categories) {
        this.categories = categories;
    }

    public FilmPlatform() {
        this.categories = new ArrayList<>();
    }

    public void addPlatform(String platformName) { //yeni bir film platformu eklemek için kullanılır.
        Category category = new Category(platformName);
        categories.add(category);
    }

    public void addCategory(String platformName, String category) { //Belirli bir film platformuna kategori eklemek için kulllanılır
        Category platform = getPlatformByName(platformName);
        if (platform != null) {
            platform.addCategory(category);
        }
    }

    public void addFilm(String platformName, String category, String filmTitle, int year, String direction, double imdbRating) {
        Category platform = getPlatformByName(platformName);
        if (platform != null) {
            platform.addFilm(category, filmTitle, year, direction, imdbRating);
        }
    }



    private Category getPlatformByName(String platformName) {  //Bulunmak istenen platformu bulamk için kullanırız
        for (Category category : categories) {
            if (category.getName().equalsIgnoreCase(platformName)) {
                return category;
            }
        }
        return null;
    }

}
