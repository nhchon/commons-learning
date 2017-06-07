package com.axonactive.model;

import java.util.List;

/**
 * Created by nhchon on 1/24/2017.
 */
public class PathogenDTO {

    private String batchId;

    private String name;

    private List<Integer> eventId;

    private String fullImageUrl;

    private Boolean isPrimary;

    private PathogenReportsDTO reports;

    public PathogenDTO(String name){
        this.name = name;
    }

    public PathogenDTO(String batchId, Boolean isPrimary, PathogenReportsDTO report){

        this.batchId = batchId;
        this.isPrimary = isPrimary;
        this.reports = report;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getEventId() {
        return eventId;
    }

    public void setEventId(List<Integer> eventId) {
        this.eventId = eventId;
    }

    public String getFullImageUrl() {
        return fullImageUrl;
    }

    public void setFullImageUrl(String fullImageUrl) {
        this.fullImageUrl = fullImageUrl;
    }

    public Boolean getPrimary() {
        return isPrimary;
    }

    public void setPrimary(Boolean primary) {
        isPrimary = primary;
    }

    public PathogenReportsDTO getReports() {
        return reports;
    }

    public void setReports(PathogenReportsDTO reports) {
        this.reports = reports;
    }

    @Override
    public String toString(){
        return "[ " + batchId + ", " + isPrimary + " ]";
    }
}
