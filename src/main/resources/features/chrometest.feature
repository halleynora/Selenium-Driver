Feature: Test google with Chrome browser


  @smoke @chrometest
  Scenario: Test open google page on chrome browser
    Given Im on the google page
    When a search term is entered
    Then validate search results
