Feature: Fill enquiry form to get quote

  Scenario: Get quote for a house
    Given Sergey is enquire form page
    When I fill the details in "About me" section
    And I fill the details in "About property" section