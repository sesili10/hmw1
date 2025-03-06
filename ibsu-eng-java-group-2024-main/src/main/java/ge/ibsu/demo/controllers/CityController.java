package ge.ibsu.demo.controllers;

import ge.ibsu.demo.entities.City;
import ge.ibsu.demo.repositories.CityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cities")
public class CityController {
    private final CityRepository cityRepository;

    public CityController(CityRepository cityRepository) {
        this.cityRepository
                = cityRepository;
    }

    @GetMapping
    public List<String> getCitiesWithCountries() {
        return cityRepository.findAll().stream()
                .map(city -> city.getName() + ", " + city.getCountry().getName())
                .collect(Collectors.toList());
    }
}
