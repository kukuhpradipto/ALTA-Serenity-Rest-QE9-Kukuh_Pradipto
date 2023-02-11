Feature: Regres API Automation testing Get recource

  @Tugas @Positive-Case
  Scenario: Get list user with parameter unknown
    Given Get list users with parameter unknown
    When Send request get list unknown
    Then Status code should be 200 OK
    And Response body page should be 1
    And Validate get list resource json schema

  @Tugas @Negative-Case
  Scenario Outline: Get list uses with valid parameter page
    Given Get list users with valid parameter page <page>
    When Send request get list users
    Then Status code should be <ok> OK
    And Response body page should be <page>
    And Validate get list user json schema
    Examples:
      | page | ok  |
      | 2    | 200 |
      | 1    | 200 |
