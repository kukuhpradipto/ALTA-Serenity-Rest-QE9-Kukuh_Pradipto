Feature: Regres API Automation testing GET List User

  @Latihan @Positive-Case
  Scenario Outline: Get list uses with valid parameter page
    Given Get list users with valid parameter page <page>
    When Send request get list users
    Then Status code should be <ok> OK
    And Response body page should be <page>
    And Validate get list user json schema
    Examples:
      | page | ok  |
      | 2    | 200 |
