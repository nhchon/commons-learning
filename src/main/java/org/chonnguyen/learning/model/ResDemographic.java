package org.chonnguyen.learning.model;

/**
 * Created by nhchon on 6/7/2017 9:05 AM.
 */
public class ResDemographic {

    private String eventId;
    private String location;
    private String locationLevel;
    private String gender;
    private int age;
    private int infected;
    private int hospitalized;
    private int deaths;
    private String state;

    /**
     * Compare on primary key CONSTRAINT PK PRIMARY KEY (EVENT_ID,LOCATION,LOCATION_LEVEL,GENDER,AGE)
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!ResDemographic.class.isAssignableFrom(obj.getClass())) {
            return false;
        }

        final ResDemographic other = (ResDemographic) obj;
        if ((this.eventId == null) ? (other.eventId != null) : !this.eventId.equals(other.eventId)) {
            return false;
        }

        if ((this.location == null) ? (other.location != null) : !this.location.equals(other.location)) {
            return false;
        }

        if ((this.locationLevel == null) ? (other.locationLevel != null) : !this.locationLevel.equals(other.locationLevel)) {
            return false;
        }

        if (this.age != other.age) {
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
        b.append(locationLevel);
        b.append(',');
        b.append(gender);
        b.append(',');
        b.append(age);
        b.append(',');
        b.append(infected);
        b.append(',');
        b.append(hospitalized);
        b.append(',');
        b.append(deaths);
        b.append(',');
        if (state != null) b.append(state);

        return b.toString();
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setLocationLevel(String locationLevel) {
        this.locationLevel = locationLevel;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHospitalized(int hospitalized) {
        this.hospitalized = hospitalized;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getInfected() {
        return infected;
    }

    public void setInfected(int infected) {
        this.infected = infected;
    }

    public String getEventId() { return this.eventId; }
    public String getLocation() { return this.location; }
    public String getGender() { return this.gender; }
    public String getState() { return this.state; }
    public String getLocationLevel() { return this.locationLevel; }
    public int getAge() { return this.age; }
    public int getHospitalized() { return this.hospitalized; }
    public int getDeaths() { return this.deaths; }
}
