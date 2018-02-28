Feature: prasad

  @testid1
  Scenario: linkedin
    And user set test id "Test1"
    And user read Test data from Excel file
    And user open Browser
    And user open Application "#URL"
    And user wait for page load

  @testid2
  Scenario Outline: facebbook
    And user set test id "<Test ID>"
    And user read Test data from Excel file
    And user open Browser
    And user open Application "#URL"
    And user wait for page load
    And user enter text "#Gmail"into text box "//input[@id='email']"
    And user enter text "#Password"into text box "//input[@id='pass']"
    And user click on button "//input[@value='Log In']"
    And user wait for page load

    Examples: 
      | Test ID |
      | Test2   |
      | Test3   |
