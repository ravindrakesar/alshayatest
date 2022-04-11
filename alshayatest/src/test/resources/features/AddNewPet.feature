Feature: This feature will test add new pet functionality

  @addnewpet
  Scenario Outline: Verify add new pet functionality
    Given User navigates to petclinic homepage
    When user clicks on find owner button
    When user clicks on add owner button
    When user enters "<FirstName>" as firstname
    When user enters "<LastName>" as lastname
    When user enters "<Address>" as address
    When user enters "<City>" as city
    When user enters "<Telephone>" as telephone
    When user submits the form
    And user clicks on add new pet button
    And user adds "<petname>" pets name
    And user selects pets date of birth as "<dob>"
    And user selects type from the dropdown as "<type>"
    And user adds the pet
    Then user verifies pet name added is "<petname>"
    Then user verifies pets date of birth as "<dob>"

    Examples:
      | FirstName | LastName | Address  |City       | Telephone   | petname | dob | type |
      | Keshav    | Pushpa   | JPNagar  |Bangalore  | 7019882661  | Pingu   | 01042022 | dog |