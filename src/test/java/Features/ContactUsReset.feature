Feature: Submit data to webdriveruniversity.com using "Contact Us" form
  If user click on Reset button all the info should be removed from the form
  Background:
    Given I access WebdriverUniversity homepage
    When I click on the contact us button

  Scenario: Enter information in the "Contact Us" form and push "Reset" button
    When I enter a first name
    And I enter a last name
    And I enter a email address
    And I enter a comment
    When I click on Reset button
    Then The information should be cleaned up in the form