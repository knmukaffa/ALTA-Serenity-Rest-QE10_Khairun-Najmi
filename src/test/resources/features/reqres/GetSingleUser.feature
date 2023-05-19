Feature: Get Single User Reqres

  @Tugas
  Scenario Outline: Get single user with valid parameter id
    Given Get single user with valid parameter id <id>
    When Send get single user
    Then Status code should be 200 OK
    And Response body name was id <id>
    And Validate get single user JSON Schema
    Examples:
      | id |
      | 1  |
      | 2  |

  @Tugas
  Scenario Outline: Get single user with invalid parameter id
    Given Get single user with invalid parameter id <id>
    When Send get single user
    Then Status code should be 404 Not Found
    Examples:
      | id      |
      | 1637819 |
      | 2748302 |

  @Tugas
  Scenario Outline: Get single user with invalid parameter id filled with string
    Given Get single user with invalid parameter id "<id>" filled with string
    When Send get single user
    Then Status code should be 400 Bad Request
    Examples:
      | id   |
      | satu |
      | %!&# |
        