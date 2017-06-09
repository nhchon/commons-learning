package org.chonnguyen.learning.model;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by nhchon on 6/6/2017 4:19 PM.
 */
public class ResLifeLoss {
    private String eventId;
    private String location;
    private String locationLevel;
    private long population;
    private long lifeLoss;
    private double totalAbsent;
    private double sector1Absent;
    private double sector2Absent;
    private double sector3Absent;
    private double sector4Absent;
    private double sector5Absent;
    private double sector6Absent;
    private String state;

    /**
     * Compare on primary key CONSTRAINT PK PRIMARY KEY (EVENT_ID,LOCATION,LOCATION_LEVEL)
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!ResLifeLoss.class.isAssignableFrom(obj.getClass())) {
            return false;
        }

        final ResLifeLoss other = (ResLifeLoss) obj;
        if ((this.eventId == null) ? (other.eventId != null) : !this.eventId.equals(other.eventId)) {
            return false;
        }

        if ((this.location == null) ? (other.location != null) : !this.location.equals(other.location)) {
            return false;
        }

        if ((this.locationLevel == null) ? (other.locationLevel != null) : !this.locationLevel.equals(other.locationLevel)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        NumberFormat nFormat = new DecimalFormat("#0.000000000000000");
        StringBuilder b = new StringBuilder();
        b.append(eventId);
        b.append(',');
        b.append(location);
        b.append(',');
        b.append(locationLevel);
        b.append(',');
        b.append(population);
        b.append(',');
        b.append(lifeLoss);
        b.append(',');
        b.append(nFormat.format(totalAbsent));
        b.append(',');
        b.append(nFormat.format(sector1Absent));
        b.append(',');
        b.append(nFormat.format(sector2Absent));
        b.append(',');
        b.append(nFormat.format(sector3Absent));
        b.append(',');
        b.append(nFormat.format(sector4Absent));
        b.append(',');
        b.append(nFormat.format(sector5Absent));
        b.append(',');
        b.append(nFormat.format(sector6Absent));
        b.append(',');
        if (state != null) b.append(state);

        return b.toString();
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocationLevel() {
        return locationLevel;
    }

    public void setLocationLevel(String locationLevel) {
        this.locationLevel = locationLevel;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public long getLifeLoss() {
        return lifeLoss;
    }

    public void setLifeLoss(long lifeLoss) {
        this.lifeLoss = lifeLoss;
    }

    public double getTotalAbsent() {
        return totalAbsent;
    }

    public void setTotalAbsent(double totalAbsent) {
        this.totalAbsent = totalAbsent;
    }

    public double getSector1Absent() {
        return sector1Absent;
    }

    public void setSector1Absent(double sector1Absent) {
        this.sector1Absent = sector1Absent;
    }

    public double getSector2Absent() {
        return sector2Absent;
    }

    public void setSector2Absent(double sector2Absent) {
        this.sector2Absent = sector2Absent;
    }

    public double getSector3Absent() {
        return sector3Absent;
    }

    public void setSector3Absent(double sector3Absent) {
        this.sector3Absent = sector3Absent;
    }

    public double getSector4Absent() {
        return sector4Absent;
    }

    public void setSector4Absent(double sector4Absent) {
        this.sector4Absent = sector4Absent;
    }

    public double getSector5Absent() {
        return sector5Absent;
    }

    public void setSector5Absent(double sector5Absent) {
        this.sector5Absent = sector5Absent;
    }

    public double getSector6Absent() {
        return sector6Absent;
    }

    public void setSector6Absent(double sector6Absent) {
        this.sector6Absent = sector6Absent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
