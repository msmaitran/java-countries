package com.lambdaschool.javacountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/age")
public class CountryAgeController {

    // Return the countries that have a median age equal to or greater than the given age
    @GetMapping(value = "/age/{age}",
                produces = {"application/json"})
    public ResponseEntity<?> getCountriesByAge(@PathVariable int age) {
        ArrayList<Country> rtnCountriesByAge = JavaCountriesApplication.theCountryList.findCountries(c ->
                c.getCountryMedianAge() >= age);
        return new ResponseEntity<>(rtnCountriesByAge, HttpStatus.OK);
    }

    // Return the country with the smallest median age
    @GetMapping(value = "/min",
                produces = {"application/json"})
    public ResponseEntity<?> getSmallestAge() {
        JavaCountriesApplication.theCountryList.countryList.sort((c1, c2) ->
                ((int) (c1.getCountryMedianAge() - c2.getCountryMedianAge())));
        return new ResponseEntity<>(JavaCountriesApplication.theCountryList.countryList.get(0), HttpStatus.OK);
    }

    // Return the country with the greatest median age
    @GetMapping(value = "/max",
                produces = {"application/json"})
    public ResponseEntity<?> getGreatestAge() {
        JavaCountriesApplication.theCountryList.countryList.sort((c1, c2) ->
                ((int) (c2.getCountryMedianAge() - c1.getCountryMedianAge())));
        return new ResponseEntity<>(JavaCountriesApplication.theCountryList.countryList.get(0), HttpStatus.OK);
    }

    // Return the country with the median median age
    @GetMapping(value = "/median",
                produces = "application/json")
    public ResponseEntity<?> getMedianAge() {
        int ageMedian;
        int ageMedianSize = JavaCountriesApplication.theCountryList.countryList.size() - 1;
        if (ageMedianSize % 2 == 0) {
            ageMedian = ageMedianSize / 2;
        } else {
            ageMedian = ((ageMedianSize + 1) / 2);
        }
        JavaCountriesApplication.theCountryList.countryList.sort((c1, c2) ->
                ((int) (c1.getCountryMedianAge() - c2.getCountryMedianAge())));
        return new ResponseEntity<>(JavaCountriesApplication.theCountryList.countryList.get(ageMedian), HttpStatus.OK);
    }
}
