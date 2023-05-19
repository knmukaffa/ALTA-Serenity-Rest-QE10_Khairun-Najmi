Feature: Delete User API Automation

  @Tugas
  Scenario Outline: Delete user with invalid parameter id
    Given Delete user with invalid parameter id "<id>"
    When Send delete user
    Then Status code should be 400 Bad Request
    Examples:
      | id   |
      | satu |
      | &#(@ |

  @Tugas
  Scenario Outline: Delete user with exceed parameter id
    Given Delete user with exceed parameter id <id>
    When Send delete user
    Then Status code should be 404 Not Found
    Examples:
      | id    |
      | 18391 |
      | 81638 |