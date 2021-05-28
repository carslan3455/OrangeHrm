Feature: Search functionality

  @Search
  Scenario: Search

    Given User on home page
    When  User login as follows
      | Admin | admin123 |
    And User navigate to Users Menu

    When User search as follows
      | UserType | Status   |
      | Admin    | Enabled  |
      | Admin    | Disabled |
      |          | Enabled  |
      | ESS      | Enabled  |
      | ESS      | Disabled |
      |          |          |
