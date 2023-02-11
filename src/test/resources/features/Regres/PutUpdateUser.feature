Feature: Regres API Automation testing POST LOGIN

  @Latihan @Positive-Case
  Scenario: Put update user with valid json and valid parameter
    Given Update user with valid json and parameter id 2
    When Send request put update user
    Then Status code should be 200 OK
    And Response body name should be "morpheus" and job is "zion resident"
    And Validate put json schema valid parameter


  @Tugas @Negative-Case
  Scenario: Put update user with invalid parameter
    Given Update user with invalid parameter id "makan"
    When Send reques invalid paremeter id
    Then Status code should be 400 Bad Request

  @Tugas @Negative-Case
  Scenario: Put update user without parameter
    Given Put update user without parameter
    When Send request without parameter
    Then Status code should be 404 Not Found
