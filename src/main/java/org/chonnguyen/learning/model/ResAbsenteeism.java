package org.chonnguyen.learning.model;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by nhchon on 6/7/2017 2:16 PM.
 */
public class ResAbsenteeism {
    private String eventId;
    private String location;
    private String day;
    private String countryCode;
    private String state;
    private Double totalAbsent;
    private String locationLevel;
    private Double sector1;
    private Double sector2;
    private Double sector3;
    private Double sector4;
    private Double sector5;
    private Double sector6;

    @Override
    public String toString() {
        NumberFormat nFormat = new DecimalFormat("#0.000000000000000");
        StringBuilder b = new StringBuilder();
        b.append(eventId);
        b.append(',');
        b.append(location);
        b.append(',');
        b.append(countryCode);
        b.append(',');
        if (state != null) b.append(state);
        b.append(',');
        b.append(day);
        b.append(',');
        b.append(locationLevel);
        b.append(',');
        b.append(nFormat.format(totalAbsent));
        b.append(',');
        b.append(nFormat.format(sector1));
        b.append(',');
        b.append(nFormat.format(sector2));
        b.append(',');
        b.append(nFormat.format(sector3));
        b.append(',');
        b.append(nFormat.format(sector4));
        b.append(',');
        b.append(nFormat.format(sector5));
        b.append(',');
        b.append(nFormat.format(sector6));

        return b.toString();
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setTotalAbsent(Double totalAbsent) {
        this.totalAbsent = totalAbsent;
    }

    public void setLocationLevel(String locationLevel) {
        this.locationLevel = locationLevel;
    }

    public void setSector1(Double sector1) {
        this.sector1 = sector1;
    }

    public void setSector2(Double sector2) {
        this.sector2 = sector2;
    }

    public void setSector3(Double sector3) {
        this.sector3 = sector3;
    }

    public void setSector4(Double sector4) {
        this.sector4 = sector4;
    }

    public void setSector5(Double sector5) {
        this.sector5 = sector5;
    }

    public void setSector6(Double sector6) {
        this.sector6 = sector6;
    }

    public String getEventId() { return this.eventId; }
    public String getLocation() { return this.location; }
    public String getCountryCode() { return this.countryCode; }
    public String getState() { return this.state; }
    public String getLocationLevel() { return this.locationLevel; }
    public Double getSector1() { return this.sector1; }
    public Double getSector2() { return this.sector2; }
    public Double getSector3() { return this.sector3; }
    public Double getSector4() { return this.sector4; }
    public Double getSector5() { return this.sector5; }
    public Double getSector6() { return this.sector6; }
    public String getDay() { return this.day; }
    public Double getTotalAbsent() { return this.totalAbsent; }
}
