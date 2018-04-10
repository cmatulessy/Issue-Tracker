Feature: Reporting an issue

  As an user I want to create a new issue for the selected user.

  @test
  Scenario: Create an issue
    Given I am on the dashboard of the Issue tracker app
    When I fill in an issue with the text "Running Espresso for Android with Cucumber and Spoon"
    Then I want to see that the issue count is raised with a plus one