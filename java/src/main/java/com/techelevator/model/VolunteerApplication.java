package com.techelevator.model;

public class VolunteerApplication {

    private int applicationId;
    private int userId;
    private String applicationStatus;

    public VolunteerApplication(int applicationId, int userId, String applicationStatus) {
        this.applicationId = applicationId;
        this.userId = userId;
        this.applicationStatus = applicationStatus;
    }
    public VolunteerApplication(){
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {this.applicationId = applicationId;}

    public int getUserId() {return userId;}

    public void setUserId(int userId) {this.userId = userId;}

    public String getApplicationStatus() {return applicationStatus;}

    public void setApplicationStatus(String applicationStatus) {this.applicationStatus = applicationStatus;}

    @Override
    public String toString() {
        return "VolunteerApplication{" +
                "applicationId=" + applicationId +
                ", userId=" + userId +
                ", applicationStatus ='" + applicationStatus + '\'' +

                '}';
    }
}

