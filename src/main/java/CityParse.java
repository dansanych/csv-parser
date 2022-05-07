import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CityParse {

    private static final String FILEPATH = "src/resources/city_ru.csv";

    public static List<City> parse() throws FileNotFoundException {
        List<City> cityList = new ArrayList<>();

        File file = new File(FILEPATH);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            cityList.add(fillObject(scanner.nextLine()));
        }

        return cityList;
    }

    public static City fillObject(String line) {
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(";");
        scanner.skip("\\d*");

        String name = scanner.next();
        String region = scanner.next();
        String district = scanner.next();
        int population = scanner.nextInt();
        String foundation = null;
        if (scanner.hasNext()) {
            foundation = scanner.next();
        }

        scanner.close();

        return new City(name, region, district, population, foundation);
    }

    public static void output(List<City> cityList) {
        for (City city : cityList) {
            System.out.println(city);
        }
    }
}
