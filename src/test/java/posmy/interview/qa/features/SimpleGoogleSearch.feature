Feature: Google search

  Background:
    Given I start the browser and navigate to http://www.google.com

  Scenario: Search will show result in the search page
    When I search for Covid-19 in Malaysia
    Then I validate the Page Title is Google Search
    And I close the browser

  Scenario: Top stories section is available in the search page
    When I search for Covid-19 in Malaysia
    Then I validate section with heading Top stories is available
    And I close the browser

  Scenario: Common question section is available in the search page
    When I search for Covid-19 in Malaysia
    Then I validate section with heading Common question is available
    And I close the browser

  Scenario: Click on a search result lead to correct page
    When I search for Covid-19 in Malaysia
    Then I verify clicking on link containing moh.gov.my redirect to correct page
    And I close the browser