package pro.sky.jdbc.service;

import pro.sky.jdbc.model.City;

public class Application {
    public static void main(String[] args, CityDao cityDao) {
        City city = City.builder()
                .city_name("Washington")
                .build();
        cityDao.add(city);
        assertTrue(cityDao.getAllCity().contains(city));
    }

    private static void assertTrue(boolean contains) {
    }
}
