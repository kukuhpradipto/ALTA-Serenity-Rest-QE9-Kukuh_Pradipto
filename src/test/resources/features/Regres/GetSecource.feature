Feature: Regres API Automation testing Get recource

  @Tugas @Positive-Case
  Scenario: Get list user with valid parameter unknown
    Given Get list users with valid parameter unknown
    When Send request get list unknown
    Then Status code should be 200 OK
    And Response body page should be 1
    And Validate get list resource json schema


