package org.chonnguyen.learning.model;

import java.util.List;

/**
 * Created by nhchon on 6/7/2017 9:30 AM.
 */
public class Country {
    private String countryCode;
    private String country;
    private String region;

    private List<State> states;


    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }
}
