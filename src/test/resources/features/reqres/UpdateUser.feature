Feature: Update user API Automation

  @Tugas
  Scenario Outline: Put update user with valid json and exceed id
    Given Put update user with valid json and exceed id <id>
    When Send put update user
    Then Status code should be 404 Not Found
    Examples:
    | id     |
    | 840113 |
    | 738194 |

  @Tugas
  Scenario Outline: Put update user with invalid json and valid id
    Given Put update user with invalid json and valid id <id>
    When Send put update user
    Then Status code should be 400 Bad Request
    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |

  @Tugas
  Scenario Outline: Put update user with invalid json and exceed id
    Given Put update user with invalid json and exceed id <id>
    When Send put update user
    Then Status code should be 404 Not Found
    Examples:
      | id     |
      | 840113 |
      | 738194 |