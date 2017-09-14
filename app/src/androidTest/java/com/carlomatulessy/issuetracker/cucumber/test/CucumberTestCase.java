package com.carlomatulessy.issuetracker.cucumber.test;

import junit.framework.TestCase;

import cucumber.api.CucumberOptions;

/**
 * Created by Carlo on 14-9-2017.
 */
@CucumberOptions(
        features = "features",
        tags = "@test",
        glue = "com.carlomatulessy.issuetracker.cucumber.steps")
public class CucumberTestCase extends TestCase {
}
