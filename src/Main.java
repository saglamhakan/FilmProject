import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FilmPlatform filmPlatform = new FilmPlatform();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Select an option:");
            System.out.println("1. Admin");
            System.out.println("2. Customer");
            System.out.println("0. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    adminMenu(filmPlatform, scanner);
                    break;
                case 2:
                    customerMenu(filmPlatform, scanner);
                    break;
                case 0:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public static void adminMenu(FilmPlatform filmPlatform, Scanner scanner) {
        int choice;
        do {
            System.out.println("Admin Menu:");
            System.out.println("1. Add Platform");
            System.out.println("2. Add Category");
            System.out.println("3. Add Film");
            System.out.println("0. Go back");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter platform name: ");
                    String platformName = scanner.nextLine();
                    filmPlatform.addPlatform(platformName);
                    System.out.println("Platform added successfully.");
                    break;
                case 2:
                    System.out.print("Enter platform name: ");
                    String platformForCategory = scanner.nextLine();
                    System.out.print("Enter category name: ");
                    String category = scanner.nextLine();
                    filmPlatform.addCategory(platformForCategory, category);
                    System.out.println("Category added successfully.");
                    break;
                case 3:
                    System.out.print("Enter platform name: ");
                    String platformForFilm = scanner.nextLine();
                    System.out.print("Enter category name: ");
                    String filmCategory = scanner.nextLine();
                    System.out.print("Enter film title: ");
                    String filmTitle = scanner.nextLine();
                    System.out.print("Enter film year: ");
                    int filmYear = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter film director: ");
                    String filmDirector = scanner.nextLine();
                    System.out.print("Enter film IMDb rating: ");
                    double filmImdbRating = scanner.nextDouble();
                    scanner.nextLine();

                    filmPlatform.addFilm(platformForFilm, filmCategory, filmTitle, filmYear, filmDirector, filmImdbRating);
                    System.out.println("Film added successfully.");
                    break;
                case 0:
                    System.out.println("Returning to previous menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public static void customerMenu(FilmPlatform filmPlatform, Scanner scanner) {
        int choice;
        do {
            System.out.println("Customer Menu:");
            System.out.println("Select a platform:");
            List<Category> platforms = filmPlatform.getPlatforms();
            for (int i = 0; i < platforms.size(); i++) {
                System.out.println((i + 1) + ". " + platforms.get(i).getName()); //index leri gösterir
            }
            System.out.println("0. Go back");

            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice >= 1 && choice <= platforms.size()) {
                Category selectedPlatform = platforms.get(choice - 1);
                System.out.println("Platform: " + selectedPlatform.getName());
                List<String> categories = new ArrayList<>(selectedPlatform.getCategories().keySet());
                for (int i = 0; i < categories.size(); i++) {
                    String category = categories.get(i);
                    int filmCount = selectedPlatform.getFilmsByCategory(category).size();
                    System.out.println((i + 1) + ". " + category + " (" + filmCount + " films)");
                }
                System.out.println("0. Go back");

                int categoryChoice = scanner.nextInt();
                scanner.nextLine();

                if (categoryChoice >= 1 && categoryChoice <= categories.size()) {
                    String selectedCategory = categories.get(categoryChoice - 1);
                    List<Film> films = selectedPlatform.getFilmsByCategory(selectedCategory);
                    System.out.println("Films in " + selectedCategory + ":");
                    for (Film film : films) {
                        System.out.println(film.getFilmName());
                    }
                } else if (categoryChoice == 0) {
                    System.out.println("Returning to previous menu...");
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } else if (choice == 0) {
                System.out.println("Returning to previous menu...");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    }