package com.lucaslevi.citiesapi.distances;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distances")
public class DistanceResource {

    Logger log = LoggerFactory.getLogger(DistanceResource.class);

    private final DistanceService service;

    public DistanceResource (DistanceService service){
        this.service = service;
    }

    @GetMapping("/by-points")
    public ResponseEntity byPoints(@RequestParam (name = "from") final Long cityA,
                           @RequestParam(name= "to") final Long cityB){
        log.info("byPoints");
        return ResponseEntity.ok().body(service.distanceByPointsInMiles(cityA, cityB));
    }

    @GetMapping("/by-cube")
    public ResponseEntity byCube(@RequestParam (name = "from") final Long cityA,
                         @RequestParam(name= "to") final Long cityB){
        log.info("byCube");
        return ResponseEntity.ok().body(service.distanceByCubeInMeters(cityA, cityB));
    }


}
