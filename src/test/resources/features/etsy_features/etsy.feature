Feature: Etsy search functionality
  CBT-25 Agile Story : can be placed here
  ​
  ​
  Scenario: Etsy search title verification
    Given User is on Etsy home page
    When User searches for wooden spoon
    Then User should see wooden spoon in the Etsy title
@etsy
  Scenario: Etsy search title verification
    Given User is on Etsy home page
    When User searches for "wooden spoon"
    Then User should see "Wooden spoon" in the Etsy title
 @etsy2
  Scenario: Etsy search title verification
    Given User is on Etsy home page
    When User searches for "custom wooden spoon"
    Then User should see "Custom wooden spoon" in the Etsy title

  @etsy3
  Scenario Outline: Etsy search title verification
    When User searches for "<searchValue>"
    Then User should see "<expectedTitle>" in the Etsy title
    Examples: different data sets
    #command option L for mac
      | searchValue         | expectedTitle       |
      | custom wooden spoon | Custom wooden spoon |
      | wooden spoon        | Wooden spoon        |

