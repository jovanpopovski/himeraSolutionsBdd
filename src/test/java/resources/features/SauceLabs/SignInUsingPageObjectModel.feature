Feature: User can sign in
  @test
  Scenario: User can sign in using page object
    Given User is on Sauce Labs home page using page object
    When User clicks on sign in button using page object
    Then User in on sign in page using page object