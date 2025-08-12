Feature: Verify Login and Dashboard functionality
  @SuccessfulloginFlow
  Scenario: Verify User able to successfully log into application
    Given user launch the webapp
    When user enter credentials for "TestUser1" user
    And user clicks on login button
    Then user verify dashboard page is displayed
    And I logout of application

  @ErrorloginFlow
  Scenario: Verify User able to successfully log into application
    Given user launch the webapp
    When user enter credentials for "TestUser2" user
    And user clicks on login button
    Then user verify error message is displayed
