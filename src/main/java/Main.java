import java.io.FileNotFoundException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        List<City> cityList = CityParse.parse();

        if (args.length != 4) {
            System.out.println("Incorrect count of parameters");
        } else {
            switch (args[0]) {
                case "1":
                    CityParse.output(cityList);
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Incorrect parameter 1");
                    break;
            }

            switch (args[1]) {
                case "1":
                    CitySort.sortByNameLambda(cityList);
                    CityParse.output(cityList);
                    break;
                case "2":
                    CitySort.sortByNameComparator(cityList);
                    CityParse.output(cityList);
                    break;
                case "3":
                    CitySort.sortInDistrictByNameComparator(cityList);
                    CityParse.output(cityList);
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Incorrect parameter 2");
                    break;
            }

            switch (args[2]) {
                case "1":
                    CitySearch.searchMaxSimple(cityList);
                    break;
                case "2":
                    CitySearch.searchMaxStreamComparator(cityList);
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Incorrect parameter 3");
                    break;
            }

            switch (args[3]) {
                case "1":
                    CitySearch.findCountCityByRegionOld(cityList);
                    break;
                case "2":
                    CitySearch.findCountCityByRegionNew(cityList);
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Incorrect parameter 4");
                    break;
            }
        }
    }
}
