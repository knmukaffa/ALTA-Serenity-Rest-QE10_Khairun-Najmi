Feature: Register user API Automation

  @Tugas
  Scenario: Post register with valid json
    Given Post register user with valid json
    When Send post register user
    Then Status code should be 200 OK
    And Response body token should be "QpwL5tke4Pnpja7X4" and id 4
    And Validate post register successful user JSON Schema

  @Tugas
  Scenario: Post register with invalid json without password
    Given Post register user with invalid json without password
    When Send post register user
    Then Status code should be 400 Bad Request
    And Response body page should be error "Missing password"
    And Validate post unsuccessful register user JSON Schema