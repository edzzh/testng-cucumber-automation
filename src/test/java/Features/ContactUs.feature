Feature: Submit data to webdriveruniversity.com using "Contact Us" form
  A user should be able to submit information via the contact us form

  Background:
    Given I access WebdriverUniversity homepage
    When I click on the contact us button

  Scenario: Submit valid data via "Contact Us" form
    When I enter a first name
    And I enter a last name
    And I enter a email address
    And I enter a comment
    When I click on Submit button
    Then The information should be successfully submitted via contact form

  Scenario: Submit invalid data via "Contact Us" form
    When I enter a invalid first name
    And I enter a invalid last name
    And I enter a invalid email
    And I enter no comment
    Then I click on Submit button
    And The user should be notified of the problem