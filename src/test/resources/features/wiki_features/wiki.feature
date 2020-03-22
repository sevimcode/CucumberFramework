@wiki
Feature: Wikipedia search functinonality
Background:
Given User is on Wikipedia homepage
When User types "Steve Jobs" in the wiki search box
And User clicks wiki search button

Scenario: wiki title
Then User sees "Steve Jobs" is in the wiki title

Scenario: main header
Then User sees "Steve Jobs" is in the main header

Scenario: image header
Then User sees "Steve Jobs" is in the image header


  @wiki3
  Scenario Outline: Etsy search title verification
    When User is on Wikipedia homepage
    And User types "<searchValue>" in the wiki search box
    And User clicks wiki search button
    Then User sees "<expectedTitle>" is in the image header
    Examples: different data sets
    #command option L for mac
      | searchValue         | expectedTitle       |
      | steve jobs | Steve Jobs |
      | donald trump        | Donald Trump       |
      | ricky martin       | Ricky Martin      |