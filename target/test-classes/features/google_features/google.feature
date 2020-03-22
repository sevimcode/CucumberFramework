Feature: Google feature verification
  Agile story : User stories , accepting criteria
  Basically we can pass here additional information related to feature file
  #comments are done using hashtag # sign in feature file


Scenario:  Google title verification
  When User is on google homepage
  Then User should see title contains Google

  Scenario: Google title verification
    When User is on google homepage
    And User types wooden spoon into the search box
    And User clicks to search button
    Then User should see wooden spoon in the title


