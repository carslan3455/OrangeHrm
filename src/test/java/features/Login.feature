Feature: Login functionality

  @Login
  Scenario: Login

    Given User on home page
   # When  User login with username as "Admin" and password "admin123"
    When  User login as follows
   #   | username | password |
      | Admin    | admin123 |
    Then  Login should be successfull
    And User navigate to Users Menu