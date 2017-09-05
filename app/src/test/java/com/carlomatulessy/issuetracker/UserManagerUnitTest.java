package com.carlomatulessy.issuetracker;

import com.carlomatulessy.issuetracker.data.User;

import org.junit.Test;

import java.io.File;
import java.net.URL;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Created by Carlo on 5-9-2017.
 * This class is used to validate if the UserManager is still working.
 */

public class UserManagerUnitTest {

    @Test
    public void test() {
        // Arrange
        User expectedUser = new User("Fiona", "de Vries", 7, "1950-11-12T00:00:00");
        User actualUser;

        // Act

        // Assert

        File file = getFileFromPath(this, "issues.csv");
        assertThat(file, notNullValue());
    }

    private File getFileFromPath(Object object, String fileName) {
        ClassLoader classLoader = object.getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        return new File(resource.getPath());
    }
}
