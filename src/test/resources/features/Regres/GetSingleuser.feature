Feature: Regres API Automation testing GET Single User

  @Tugas @Positive-Case
  Scenario Outline: Get single user with id parameter
    Given Get single user with valid parameter id <id>
    When Send request get single user
    Then Status code should be 200 OK
    And Response id should be <id>
    And Validate get single user json schema
    Examples:
      | id |
      | 2  |
      | 3  |
      | 4  |

  @Tugas @Negative-Case
  Scenario: Get single user without parameter
    Given Get single without parameter
    When Send request get single user without parameter
    Then Status code should be 200 OK
    And Response id should be page 1
    And Validate get single without parameter json schema

  @Tugas @Negative-Case
    Scenario Outline: Get single user with invalid id
    Given Get single user with invalid id "<id>"
    When Send request get single user invalid
    Then Status code should be 404 Not Found
    And Validate get single invalid id parameter json schema
    Examples:
      | id  |
      | asa |
      | aa  |

  @Tugas @Negative-Case
     Scenario Outline: Get list user with number id parameter unregistered
     Given Get list user with number id parameter unregistered <id>
     When Send request get single user
     Then Status code should be 404 Not Found
     And Validate get single unregistered id parameter json schema
    Examples:
       | id |
       | 16 |
       | 19 |

