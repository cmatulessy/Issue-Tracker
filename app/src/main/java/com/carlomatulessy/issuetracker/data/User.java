package com.carlomatulessy.issuetracker.data;

/**
 * Created by Carlo on 5-9-2017.
 * This class is used to store the data from issues.csv
 */

public class User {
    private String firstName;
    private String surName;
    private int issueCount;
    private String dateOfBirth;

    public User(String firstName, String surName, int issueCount, String dateOfBirth) {
        setFirstName(firstName);
        setSurName(surName);
        setIssueCount(issueCount);
        setDateOfBirth(dateOfBirth);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getSurName() {
        return this.surName;
    }

    public int getIssueCount() {
        return this.issueCount;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
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

    private void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
