package com.carlomatulessy.issuetracker.data;

/**
 * Created by Carlo on 5-9-2017.
 * This class is used to store the data from issues.csv
 */
public class User {
    private String userFullName;
    private String firstName;
    private String surName;
    private int issueCount;
    private String dateOfBirth;
    private int profilePictureResourceId;

    public User(String[] userData) {
        setFirstName(userData[0]);
        setSurName(userData[1]);
        setUserFullName(getFirstName()+" "+getSurName());
        setIssueCount(Integer.parseInt(userData[2]));
        setDateOfBirth(userData[3]);
    }

    public String getUserFullName() { return this.userFullName; }

    private String getFirstName() {
        return this.firstName;
    }

    @SuppressWarnings("WeakerAccess")
    public String getSurName() {
        return this.surName;
    }

    public int getIssueCount() {
        return this.issueCount;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public int getProfilePictureResourceId() {
        return this.profilePictureResourceId; }

    private void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void setSurName(String surName) {
        this.surName = surName;
    }

    private void setIssueCount(int issueCount) {
        this.issueCount = issueCount;
    }

    public void addOneIssueToCount() { this.issueCount++; }

    private void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = DateParser.parseToDate(dateOfBirth);
    }

    public void setProfilePictureResourceId(int resourceId) {
        this.profilePictureResourceId = resourceId;
    }
}
