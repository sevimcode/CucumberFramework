Feature: Smartbear login feature verifications


  #Agile Story: When user is on the login page of SmartBear app user should

  #be able to login using correct test data
 # A/C:
 # 1- Only authenticated user should be able to login
 # Link: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
 # Authenticated test data:
  #Username: Test
  #Password: tester
 # 2- User should see "Welcome, Tester!" displayed when logged in.
  # create at least 2 Scenario:
  # follow page object model design
  # write scenarios
  # run the cukesrunner to get ready snippets
  # coy paste snippets into step_definition class
  # implement each step following page object model design


  @positivelogin
  Scenario:User should be able to login
    When User is on Smart Bear homepage
    And User input username in username box
    And User input password in password box

    Then User should be able to login
  @negativelogin
  Scenario:User should be able to see message when enter wrong password
    When User is on Smart Bear homepage
    And User input username in username box
    And User input wrong password in password box
    And User should be click login button
    Then User should be able to see message
