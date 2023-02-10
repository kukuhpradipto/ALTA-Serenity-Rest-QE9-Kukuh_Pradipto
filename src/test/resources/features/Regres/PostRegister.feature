Feature: Regres API Automation testing POST Register

  @Tugas @Positive-Case
  Scenario: Post register with valid json file
    Given Post register with valid json
    When Send request post register user
    Then Status code should be 200 OK
    And Response body id is should 4 and token is "QpwL5tke4Pnpja7X4"
    And Validate post register successful json schema


  @Tugas @Negative-Case
  Scenario: Post register with invalid email json file
    Given Post register without valid email
    When Send request post register invalid without email
    Then Status code should be 400 Bad Request
    And Response body should show message "Missing password"


  @Tugas @Negative-Case
  Scenario: Post register with invalid password json file
    Given Post register without valid password
    When Send request post register invalid without password
    Then Status code should be 400 Bad Request
    And Response body should show message "Missing password"
    And Validate post register invalid json schema

  @Tugas @Negative-Case
  Scenario: Post register without parameter
    Given Post register without parameter
    When Send request post register without parameter
    Then Status code should be 400 Bad Request
    And Response body should show message "Missing password"
    And Validate post register invalid json schema




