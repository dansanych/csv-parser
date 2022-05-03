package com.company;

import java.util.Comparator;
import java.util.List;

public class CitySort {

    public static void sortByNameLambda (List<City> cityList) {
        cityList.sort(((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName())));
    }

    public static void sortByNameComparator (List<City> cityList) {
        cityList.sort(Comparator.comparing(City::getName));
    }

    public static void sortInDistrictByNameComparator(List<City> cityList) {
        cityList.sort(Comparator
                .comparing(City::getDistrict)
                .thenComparing(City::getName));
    }

}
