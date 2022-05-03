package com.company;


import java.io.FileNotFoundException;
import java.util.List;

import static com.company.CityParse.*;
import static com.company.CitySearch.*;
import static com.company.CitySort.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        // Парсинг данных в объектную модель
        List<City> cityList = parse();

        // Вывод данных csv файла
        output(cityList);

        // Сортировка городов по наименованию. Вариант реализации : компаратор
        sortByNameComparator(cityList);

        // Сортировка городов по наименованию. Вариант реализации : лямбда-выражения
        sortByNameLambda(cityList);

        // Сортировка городов по федеральному округу и наименованию . Вариант реализации : компаратор
        sortInDistrictByNameComparator(cityList);

        // Поиск города с наибольшим количеством населения. Вариант реализации: перебор массива
        searchMaxSimple(cityList);

        // Поиск города с наибольшим количеством населения. Вариант реализации: stream().max(), компаратор
        searchMaxStreamComparator(cityList);

        // Поиск количества городов в разрезе регионов. Вариант реализации №1 с использованием if
        findCountCityByRegionOld(cityList);

        // Поиск количества городов в разрезе регионов. Вариант реализации №2 с использованием лямбда-выражений
        findCountCityByRegionNew(cityList);
    }
}
