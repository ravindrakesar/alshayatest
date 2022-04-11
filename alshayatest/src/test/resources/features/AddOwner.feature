Feature: This feature will test add owner functionality

  @addowner
  Scenario Outline: Verify add owner functionality
    Given User navigates to petclinic homepage
    When user clicks on find owner button
    When user clicks on add owner button
    When user enters "<FirstName>" as firstname
    When user enters "<LastName>" as lastname
    When user enters "<Address>" as address
    When user enters "<City>" as city
    When user enters "<Telephone>" as telephone
    When user submits the form
    Then verify user's firstname is "<Fullname>"
    Then verify user's address is "<Address>"
    Then verify user's city is "<City>"
    Then verify user's telephone number is "<Telephone>"

    Examples:
      | FirstName   | LastName     | Address  |City       | Telephone   | Fullname |
      | Ravindra    | Kesarabhavi  | JPNagar  |Bangalore  | 7019882661  | Ravindra Kesarabhavi|

