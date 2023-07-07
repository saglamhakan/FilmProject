import java.util.ArrayList;
import java.util.List;

public class FilmPlatform {
    public List<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }

    private List<Platform> platforms;

    public FilmPlatform() {
        this.platforms = new ArrayList<>();
    }

    public void addPlatform(String platformName) {
        Platform platform = new Platform(platformName);
        platforms.add(platform);
    }

    public void addCategory(String platformName, String category) {
        Platform platform = getPlatformByName(platformName);
        if (platform != null) {
            platform.addCategory(category);
        }
    }

    public void addFilm(String platformName, String category, String filmTitle) {
        Platform platform = getPlatformByName(platformName);
        if (platform != null) {
            platform.addFilm(category, filmTitle);
        }
    }

    public List<Film> getFilmsByCategory(String platformName, String category) {
        Platform platform = getPlatformByName(platformName);
        if (platform != null) {
            return platform.getFilmsByCategory(category);
        }
        return new ArrayList<>();
    }

    public int getTotalFilmCount(String platformName) {
        Platform platform = getPlatformByName(platformName);
        if (platform != null) {
            return platform.getTotalFilmCount();
        }
        return 0;
    }

    private Platform getPlatformByName(String platformName) {
        for (Platform platform : platforms) {
            if (platform.getName().equalsIgnoreCase(platformName)) {
                return platform;
            }
        }
        return null;
    }

}
