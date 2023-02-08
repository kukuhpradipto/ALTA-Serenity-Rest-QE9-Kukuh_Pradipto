Feature: Regres API Automation testing

  @Latihan
  Scenario Outline: Get list uses with valid parameter page
    Given Get list users with valid parameter page <page>
    When Send request get list users
    Then Status code should be <ok> OK
    And Response body page should be <page>
    Examples:
      | page | ok  |
      | 2    | 200 |

    @Latihan
    Scenario: Post create new user with valid json file
      Given Create new user with valid json
      When Send request post create user
      Then Status code should be 201 Created
      And Response body name should be "Kukuh" and job is "Leader of QA"

      @Tugas
      Scenario: Get single user with id parameter
        Given Get single user with valid parameter id 1
        When Send request get single user
        Then Status code should be 200 OK


      @Latihan
      Scenario Outline: Put update user with valid json and parameter id
        Given Update user with valid json and parameter id <id>
        When Send request put update user
        Then Status code should be 200 OK
        And Response body name should be "Kukuh" and job is "Leader of QA"
        Examples:
          | id |
          | 1  |
          | 2  |
          | 3  |

        @Latihan
        Scenario Outline: Delete user valid parameter id
          Given Delete user with valid id <id>
          When Send request delete user
          Then Status code should be 204 No Content
          Examples:
            | id |
            | 2  |
            | 3  |