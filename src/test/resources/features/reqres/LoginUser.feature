Feature: Login user API Automation

  @Tugas
  Scenario: Post login user with valid json
    Given Post login user with valid json
    When Send post login user
    Then Status code should be 200 OK
    And Response body token should be "QpwL5tke4Pnpja7X4"
    And Validate post login user JSON Schema

  @Tugas
  Scenario: Post login user with invalid json without password
    Given Post login user with invalid json without password
    When Send post login user
    Then Status code should be 400 Bad Request
    And Response body page should be error "Missing password"
    And Validate post unsuccessful login user JSON Schema