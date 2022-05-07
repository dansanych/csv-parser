import java.text.NumberFormat;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CitySearch {

    public static void searchMaxSimple(List<City> cityList) {
        City[] cityArray = new City[cityList.size()];
        cityList.toArray(cityArray);

        int numMaxPopulationCity = 0;
        City maxPopulationCity = cityArray[numMaxPopulationCity];

        for (int i = 0; i < cityArray.length; i++) {
            if (cityArray[i].getPopulation() > maxPopulationCity.getPopulation()) {
                numMaxPopulationCity = i;
                maxPopulationCity = cityArray[numMaxPopulationCity];
            }
        }

        NumberFormat f = NumberFormat.getInstance();
        System.out.printf("[%d] = %s\n", (numMaxPopulationCity+1), f.format(maxPopulationCity.getPopulation()));
    }


    public static void searchMaxStreamComparator(List<City> cityList) {
        System.out.println(cityList
                .stream()
                .max(Comparator.comparing(City::getPopulation)));
    }

    public static void findCountCityByRegionOld(List<City> cityList) {
        Map <String, Integer> regions = new HashMap<>();
        for (City city : cityList) {
            if (regions.containsKey(city.getRegion())) {
                regions.put(city.getRegion(), regions.get(city.getRegion()) + 1);
            } else {
                regions.put(city.getRegion(), 1);
            }
        }
        for (String key: regions.keySet()) {
            System.out.printf("[%s] = %d\n", key, regions.get(key));
        }
    }

    public static void findCountCityByRegionNew(List<City> cityList) {
        Map<String, Integer> regions = new HashMap<>();
        cityList.forEach(city -> regions.merge(city.getRegion(), 1, Integer::sum));
        regions.forEach((k, v) ->  System.out.printf("[%s] = %d\n", k, v));
    }

}
