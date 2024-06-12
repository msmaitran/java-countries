package com.lambdaschool.javacountries;

public class Country {
    private String countryName;
    private Integer countryPopulation;
    private Integer countryLandMassSize;
    private Integer countryMedianAge;

    public Country(String countryName,
                   Integer countryPopulation,
                   Integer countryLandMassSize,
                   Integer countryMedianAge) {
        this.countryName = countryName;
        this.countryPopulation = countryPopulation;
        this.countryLandMassSize = countryLandMassSize;
        this.countryMedianAge = countryMedianAge;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Integer getCountryPopulation() {
        return countryPopulation;
    }

    public void setCountryPopulation(Integer countryPopulation) {
        this.countryPopulation = countryPopulation;
    }

    public Integer getCountryLandMassSize() {
        return countryLandMassSize;
    }

    public void setCountryLandMassSize(Integer countryLandMassSize) {
        this.countryLandMassSize = countryLandMassSize;
    }

    public Integer getCountryMedianAge() {
        return countryMedianAge;
    }

    public void setCountryMedianAge(Integer countryMedianAge) {
        this.countryMedianAge = countryMedianAge;
    }
}
