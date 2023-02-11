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

    @Tugas @Negative-Case
    Scenario Outline: Delete with invalid parameter id
      Given Delete user with invalid id "<invalidId>"
      When Send request delete user invalid id
      Then Status code should be 400 Bad Request
      Examples:
        | invalidId |
        | jssk      |
        | 12333     |

    @Tugas @Negative-Case
    Scenario: Delete without parameter id
      Given Delete user without ID
      When Send request delete user without id
      Then Status code should be 400 Bad Request