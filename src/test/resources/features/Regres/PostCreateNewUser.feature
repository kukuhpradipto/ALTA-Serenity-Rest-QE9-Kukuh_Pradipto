Feature: Regres API Automation testing POST

  @Latihan @Positive-Case
  Scenario: Post create new user with valid json file
    Given Create new user with valid json
    When Send request post create user valid json
    Then Status code should be 201 Created
    And Response body name should be "saya" and job is "job"

  @Tugas @Negative-Case
  Scenario: Post create new user with invalid json file
    Given Create new user with invalid json
    When Send request post create user
    Then Status code should be 400 Bad Request


  @Tugas @Negative-Case
  Scenario: Post create new user with invalid json file name is blank
    Given Create new user with name is blank
    When Send request post create user
    Then Status code should be 400 Bad Request


  @Tugas @Negative-Case
  Scenario: Post create new user with invalid json file job is blank
    Given Create new user with job is blank
    When Send request post create user
    Then Status code should be 400 Bad Request
