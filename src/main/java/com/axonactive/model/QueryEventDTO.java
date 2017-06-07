package com.axonactive.model;

import java.util.Date;
import java.util.List;

public class QueryEventDTO {

    private Integer eventId;

    private Long startDate;

    private Long endDate;

    private Integer cases;

    private Integer deaths;

    private String location;

    private String firstReported;

    private String pathogen;

    private String source;

    private Long globalEndDate;

    private Integer isNew;

    private Integer daysFromSpark;

    public QueryEventDTO() {

    }

    public QueryEventDTO(String pathogen){
        this.pathogen = pathogen;
    }

    public QueryEventDTO(Long startDate, Long endDate, Integer cases, Integer deaths, String location, String firstReported, String pathogen, String source){
        this.startDate = startDate;
        this.endDate = endDate;
        this.deaths = deaths;
        this.cases = cases;
        this.location = location;
        this.firstReported = firstReported;
        this.pathogen = pathogen;
        this.location = location;
        this.source = source;
    }

    public QueryEventDTO(QueryEventDTO queryEventDTO) {
        eventId = queryEventDTO.eventId;
        startDate = queryEventDTO.startDate;
        endDate = queryEventDTO.endDate;
        cases = queryEventDTO.cases;
        deaths = queryEventDTO.deaths;
        location = queryEventDTO.location;
        firstReported = queryEventDTO.firstReported;
        pathogen = queryEventDTO.pathogen;
        source = queryEventDTO.source;
        globalEndDate = queryEventDTO.globalEndDate;
        isNew = queryEventDTO.isNew;
    }

    @Override
    public String toString(){
        return "[" + pathogen + ", " + startDate + ", " + endDate + ", "+ cases + ", " + deaths + ", "+ location + ", " + firstReported + "," + source + "]";
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public Long getEndDate() {
        return endDate;
    }

    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }

    public Integer getCases() {
        return cases;
    }

    public void setCases(Integer cases) {
        this.cases = cases;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFirstReported() {
        return firstReported;
    }

    public void setFirstReported(String firstReported) {
        this.firstReported = firstReported;
    }

    public String getPathogen() {
        return pathogen;
    }

    public void setPathogen(String pathogen) {
        this.pathogen = pathogen;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Long getGlobalEndDate() {
        return globalEndDate;
    }

    public void setGlobalEndDate(Long globalEndDate) {
        this.globalEndDate = globalEndDate;
    }

    public Integer getIsNew() {
        return isNew;
    }

    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }

    public Integer getDaysFromSpark() {
        return daysFromSpark;
    }

    public void setDaysFromSpark(Integer daysFromSpark) {
        this.daysFromSpark = daysFromSpark;
    }

}
