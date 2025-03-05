Feature: test login functionality

  @login
  Scenario: Login with valid credentials
    Given user start the app
    When login with "sample_user2@wire.engineering" and "Test123!"
    Then login works correctly