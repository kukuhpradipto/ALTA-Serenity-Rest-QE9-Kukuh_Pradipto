Feature: Regres API Automation testing GET List User

  @Latihan @Positive-Case
  Scenario Outline: Get list user with valid parameter page
    Given Get list users with valid parameter page <page>
    When Send request get list users
    Then Status code should be <statusCode> OK
    And Response body page should be <page>
    And Validate get list user json schema
    Examples:
      | page | statusCode |
      | 2    | 200        |
      | 1    | 200        |

  @Tugas @Negative-Case
  Scenario Outline: Get list users with out parameter page
    Given Get list users without parameter page
    When Send request get list with out parameter page
    Then Status code should be <statusCode> OK
    And Response body page should be <page>
    And Validate get list with out parameter json schema
    Examples:
      | statusCode | page |
      | 200        | 1    |

  @Tugas @Negative-Case
  Scenario Outline: Get list users with invalid parameter page
    Given Get list users with invalid parameter page "<page>"
    When Send request with invalid parameter page
    Then Status code should be <ok> OK
    And Validate get list user json schema

    Examples:
      | page | ok  |
      | ###  | 200 |
      | AAA  | 200 |



