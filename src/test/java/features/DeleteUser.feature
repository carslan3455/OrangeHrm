Feature: Delete a user

  Scenario: Delete and update user

    Given User on home page
    And User login as follows
      | Admin | admin123 |
    And User navigate to Users Menu
    And User search username as "username1234"
    When User delete the "username1234"
    Then User should be deleted