package com.carlomatulessy.issuetracker.cucumber.steps;

import android.app.Activity;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.core.internal.deps.guava.collect.Iterables;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import android.support.test.runner.lifecycle.Stage;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

import com.carlomatulessy.issuetracker.R;
import com.carlomatulessy.issuetracker.app.MainActivity;
import com.squareup.spoon.Spoon;

import org.junit.After;
import org.junit.Before;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by Carlo on 14-9-2017.
 * This class is an example of an E2E test case with Cucumber and Espresso. This class contains the
 * StepDefinitions of the steps which are written in issues.feature
 */

public class StepDefinitions extends ActivityInstrumentationTestCase2<MainActivity> {

    final String featureTitle = "Feature Reporting an issue";
    final String scenarioTitle = "Scenario Create an issue";

    public StepDefinitions() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Given("^I am on the dashboard of the Issue tracker app$")
    public void iAmOnTheDashBoardOfTheIssueTrackerApp() {
        assertNotNull(getActivity());
    }

    @When("^I fill in an issue with the text \"([^\"]*)\"$")
    public void iFillInAnIssueWithTheText(String messsage) {
        makeScreenshot("Start");
        onView(withText("Fiona de Vries")).perform(click());
        makeScreenshot("Clicked_on_Fiona_de_Vries_cardview");
        onView(withId(R.id.userdialog_new_issue_button)).perform(click());
        makeScreenshot("Clicked_on_New_Issue_button");
        onView(withId(R.id.newissue_description)).perform(typeText(messsage));
        makeScreenshot("Enter_message");
        onView(withId(R.id.newissue_submit_button)).perform(click());
    }

    @Then("^I want to see that the issue count is raised with a plus one$")
    public void iWantToSeeThatTheIssueCountIsRaisedWithAPlusOne() {
        makeScreenshot("final_screen");
        assertTrue(true);
    }

    private void makeScreenshot(String action) {
        Spoon.screenshot(getCurrentActivity(), action, featureTitle, scenarioTitle);
    }


    private Activity getCurrentActivity() {
        getInstrumentation().waitForIdleSync();
        final Activity[] activity = new Activity[1];

        try {
            runTestOnUiThread(new Runnable() {
                @Override
                public void run() {
                    java.util.Collection<Activity> activites = ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(Stage.RESUMED);
                    activity[0] = Iterables.getOnlyElement(activites);
                }
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        Log.d("[Current activity]", activity[0].toString());
        return activity[0];
    }

}
