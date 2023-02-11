Feature: Regres API Automation testing POST LOGIN

  @Tugas @Positive-Case
  Scenario: Post login with valid json file
    Given Post login with valid json
    When Send request post login user
    Then Status code should be 200 OK
    And Response body token is "QpwL5tke4Pnpja7X4"
    And Validate post login successful json schema

  @Tugas @Negative-Case
  Scenario: Post login with invalid json file
    Given Post login without email
    When Send request invalid json
    Then Status code should be 400 Bad Request
    And Response body should show message "Missing email or username"
    And Validate post register invalid json schema

  @Tugas @Negative-Case
  Scenario: Post login with invalid json file
    Given Post login without password
    When Send request invalid json
    Then Status code should be 400 Bad Request
    And Response body should show message "Missing password"
    And Validate post register invalid json schema

  @Tugas @Negative-Case
  Scenario: Post login with invalid json file
    Given Post login without email and password
    When Send request invalid json
    Then Status code should be 400 Bad Request
    And Response body should show message "Missing email or username"
    And Validate post register invalid json schema