@login
Feature: Login - WebDriver University

  Scenario: Successful Login
    Given I access the "https://www.webdriveruniversity.com/Login-Portal/index.html?" page
    When I enter webdriver username
    And I enter a valid password
    And I click Login button
    Then A pop with successful login message should appear

  Scenario: Unsuccessful Login
    Given I access the "https://www.webdriveruniversity.com/Login-Portal/index.html?" page
    When I enter webdriver username
    And I enter a invalid password
    And I click Login button
    Then A pop with unsuccessful login message should appear


