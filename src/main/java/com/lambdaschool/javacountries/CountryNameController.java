package com.lambdaschool.javacountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/names")
public class CountryNameController {

    // Return the names of all the countries alphabetically
    @GetMapping(value = "/all",
                produces = {"application/json"})
    public ResponseEntity<?> getAllCountries() {
        JavaCountriesApplication.theCountryList.countryList.sort((c1, c2) ->
                c1.getCountryName().compareToIgnoreCase(c2.getCountryName()));
        return new ResponseEntity<>(JavaCountriesApplication.theCountryList.countryList, HttpStatus.OK);
    }

    // Return the countries alphabetically that begin with the given letter
    @GetMapping(value = "/start/{letter}",
                produces = {"application/json"})
    public ResponseEntity<?> getSortedCountries(@PathVariable char letter) {
        ArrayList<Country> rtnSortedCountries = JavaCountriesApplication.theCountryList
                .findCountries(c -> c.getCountryName().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        rtnSortedCountries.sort((c1, c2) -> (c1.getCountryName().compareToIgnoreCase(c2.getCountryName())));
        return new ResponseEntity<>(rtnSortedCountries, HttpStatus.OK);
    }

    // Return the countries alphabetically that have a name equal to or longer than the given length
    @GetMapping(value = "/size/{number}",
                produces = {"application/json"})
    public ResponseEntity<?> getCountriesByLength(@PathVariable int number) {
        ArrayList<Country> rtnCountriesByLength = JavaCountriesApplication.theCountryList
                .findCountries(c -> c.getCountryName().length() >= number);
        rtnCountriesByLength.sort((c1, c2) -> c1.getCountryName().compareToIgnoreCase(c2.getCountryName()));
        return new ResponseEntity<>(rtnCountriesByLength, HttpStatus.OK);
    }
}
