package org.chonnguyen.learning.model;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by nhchon on 6/7/2017 9:05 AM.
 */
public class ResEpicurve {

    private String eventId;
    private String location;
    private String countryCode;
    private String state;
    private String locationLevel;
    private Long infected;
    private Long hospitalized;
    private Long deaths;
    private String day;

    /**
     * Compare on primary key CONSTRAINT PK PRIMARY KEY (EVENT_ID,LOCATION,LOCATION_LEVEL,"DAY")
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!ResEpicurve.class.isAssignableFrom(obj.getClass())) {
            return false;
        }

        final ResEpicurve other = (ResEpicurve) obj;
        if ((this.eventId == null) ? (other.eventId != null) : !this.eventId.equals(other.eventId)) {
            return false;
        }

        if ((this.location == null) ? (other.location != null) : !this.location.equals(other.location)) {
            return false;
        }

        if ((this.locationLevel == null) ? (other.locationLevel != null) : !this.locationLevel.equals(other.locationLevel)) {
            return false;
        }

        if ((this.day == null) ? (other.day != null) : !this.day.equals(other.day)) {
            return false;
        }

        return true;
    }


    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append(eventId);
        b.append(',');
        b.append(location);
        b.append(',');
        b.append(countryCode);
        b.append(',');
        if (state != null) b.append(state);
        b.append(',');
        b.append(locationLevel);
        b.append(',');
        b.append(day);
        b.append(',');
        b.append(infected);
        b.append(',');
        b.append(hospitalized);
        b.append(',');
        b.append(deaths);

        return b.toString();
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setLocationLevel(String locationLevel) {
        this.locationLevel = locationLevel;
    }

    public void setInfected(Long infected) {
        this.infected = infected;
    }

    public void setHospitalized(Long hospitalized) {
        this.hospitalized = hospitalized;
    }

    public void setDeaths(Long deaths) {
        this.deaths = deaths;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getEventId() { return this.eventId; }
    public String getLocation() { return this.location; }
    public String getCountryCode() { return this.countryCode; }
    public String getState() { return this.state; }
    public String getLocationLevel() { return this.locationLevel; }
    public Long getInfected() { return this.infected; }
    public Long getHospitalized() { return this.hospitalized; }
    public Long getDeaths() { return this.deaths; }
    public String getDay() { return this.day; }
}
