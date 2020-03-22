#Compare titles at "https://dzone.com/articles/gradle-vs-maven"
#and "https://dzone.com/articles/api-security-weekly-issue-71"
#

Feature: compare two different page
  @compare
  Scenario:
  When User is on "https://dzone.com/articles/gradle-vs-maven"
  And User on "https://dzone.com/articles/api-security-weekly-issue-71"
    Then Compare