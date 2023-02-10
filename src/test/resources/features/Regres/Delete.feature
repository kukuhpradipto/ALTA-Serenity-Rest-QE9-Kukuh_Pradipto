Feature: Regres API Automation testing DELETE

    @Latihan
      Scenario Outline: Delete user valid parameter id
        Given Delete user with valid id <id>
        When Send request delete user
        Then Status code should be 204 No Content
        Examples:
        | id |
        | 2  |
        | 3  |
