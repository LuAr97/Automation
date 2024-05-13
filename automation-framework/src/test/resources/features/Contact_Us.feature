@contact-us
Feature: WebDriver University - Contact Us Page

  @Test1
  Scenario: Validate Successful Submission - Unique Data
    Given I access the webdriver university contact us page
    When I enter a unique first name
    And I enter a unique last name
    And I enter a unique email address
    And I enter a unique comment
    And I click on the submit button
    Then I should be presented with a successful contact us submission page

  @Test2
  Scenario: Validate Successful Submission - Specific Data
    Given I access the webdriver university contact us page
    When I enter Luisa as first name
    And I enter "Arboleda Zapata" as last name
    And I enter luisa@arboleda.com as email address
    And I enter "Hi I want to contact you" as a comment
    And I click on the submit button
    Then I should be presented with a successful contact us submission page