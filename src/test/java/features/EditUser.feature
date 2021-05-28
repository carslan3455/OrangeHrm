Feature: Editing a user

  Scenario: Edit and update user

    Given User on home page
    And User login as follows
      | Admin | admin123 |
    And User navigate to Users Menu
    And User search username as "username123"
    When User edits "username123"
    And User update user name as "username1234"
    Then Update should be successfully