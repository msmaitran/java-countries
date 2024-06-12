package com.lambdaschool.javacountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class CountryPopulationController {

    // Return the countries that have a population equal to or greater than the given population
    @GetMapping(value = "/size/{people}",
                produces = {"application/json"})
    public ResponseEntity<?> getCountriesByPopulation(@PathVariable int people) {
        ArrayList<Country> rtnCountriesByPopulation = JavaCountriesApplication.theCountryList
                .findCountries(c -> c.getCountryPopulation() >= people);
        return new ResponseEntity<>(rtnCountriesByPopulation, HttpStatus.OK);
    }

    // Return the country with the smallest population
    @GetMapping(value = "/min",
                produces = {"application/json"})
    public ResponseEntity<?> getSmallestPopulation() {
        JavaCountriesApplication.theCountryList.countryList.sort((c1, c2) ->
                ((int) (c1.getCountryPopulation() - c2.getCountryPopulation())));
        return new ResponseEntity<>(JavaCountriesApplication.theCountryList.countryList.get(0), HttpStatus.OK);
    }

    // Return the country with the largest population
    @GetMapping(value = "/max",
                produces = {"application/json"})
    public ResponseEntity<?> getLargestPopulation() {
        JavaCountriesApplication.theCountryList.countryList.sort((c1, c2) ->
                ((int) (c2.getCountryPopulation() - c1.getCountryPopulation())));
        return new ResponseEntity<>(JavaCountriesApplication.theCountryList.countryList.get(0), HttpStatus.OK);
    }

    // Return the country with the median population
    @GetMapping(value = "/median",
                produces = {"application/json"})
    public ResponseEntity<?> getMedianPopulation() {
        int median;
        int populationSize = JavaCountriesApplication.theCountryList.countryList.size() - 1;
        if (populationSize % 2 == 0) {
            median = populationSize / 2;
        } else {
            median = ((populationSize + 1) / 2);
        }
        JavaCountriesApplication.theCountryList.countryList.sort((c1, c2) ->
                ((int) (c1.getCountryPopulation() - c2.getCountryPopulation())));
        return new ResponseEntity<>(JavaCountriesApplication.theCountryList.countryList.get(median), HttpStatus.OK);
    }
}
