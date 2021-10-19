package com.lucaslevi.citiesapi.distances;

import com.lucaslevi.citiesapi.cities.Entity.City;
import com.lucaslevi.citiesapi.cities.Repository.CityRepository;
import org.springframework.data.geo.Point;

import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DistanceService {

    private final CityRepository cityRepository;
    Logger log = LoggerFactory.getLogger(DistanceService.class);

    public DistanceService(final CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Double distanceByPointsInMiles(final Long cityA, final Long cityB) {
        log.info("nativePostgresInMiles({}, {})", cityA, cityB);
        return cityRepository.distanceByPoints(cityA, cityB);
    }

    public Double distanceByCubeInMeters(Long cityA, Long cityB) {
        log.info("distanceByCubeInMeters({}, {})", cityA, cityB);
        final List<City> cities = cityRepository.findAllById((Arrays.asList(cityA, cityB)));

        Point p1 = cities.get(0).getLocation();
        Point p2 = cities.get(1).getLocation();

        return cityRepository.distanceByCube(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }
}