Feature:
  Scenario:
    When User is on "https://dzone.com/articles/gradle-vs-maven"
    And User get the header
    And User on "https://dzone.com/articles/api-security-weekly-issue-71"
    And User get the header of other page
    Then Compare with tempstroge