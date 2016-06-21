package com.example.pojo;

/**
 * Created by Hiral on 6/21/2016.
 */
public class Jobs {
    String jobId;
    String jobTitle;
    String jobLocation;
    String jobDate;

    public Jobs(String jobId, String jobTitle, String jobLocation, String jobDate) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.jobLocation = jobLocation;
        this.jobDate = jobDate;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }

    public String getJobDate() {
        return jobDate;
    }

    public void setJobDate(String jobDate) {
        this.jobDate = jobDate;
    }
}