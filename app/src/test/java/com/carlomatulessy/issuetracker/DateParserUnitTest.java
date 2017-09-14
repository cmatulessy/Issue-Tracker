package com.carlomatulessy.issuetracker;

import com.carlomatulessy.issuetracker.data.DateParser;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by Carlo on 5-9-2017.
 * This class is used to validate if the DateParser is still working.
 */

public class DateParserUnitTest {

    @Test
    public void validateDateParserParseToDate() {
        // Arrange
        String input = "1950-11-12T00:00:00";
        String expectedResult = "12 November 1950";
        String actualResult;

        // Act
        actualResult = DateParser.parseToDate(input);

        // Assert
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test(expected = RuntimeException.class)
    public void validateRuntimeExceptionWithWrongDateInput() {
        // Arrange
        String input = "This is a wrong input for date";

        // Act
        DateParser.parseToDate(input);

        // Assert will be done by validating if the thrown Exception is a RuntimeException
    }
}
