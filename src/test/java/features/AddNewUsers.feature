Feature: Add a User

  Scenario: Add a new user

    Given User on home page
    And User login as follows
      | Admin | admin123 |
    And User navigate to Users Menu

    When User create a new user as follows
      | ESS         |
      | Alice Duval |
      | username123  |
      # isim her seferinde silinse bile degismesi gerekiyor
      | Enabled     |
      | pass1234    |
      | pass1234    |

    And User search username as "username123"
    Then User "username123" should be listed
