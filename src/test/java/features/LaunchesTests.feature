
Feature: Launches Tests

  Background: User Opens RP and sings in
    When User opens Report Portal
    And User logs in
    And User goes to Launches Page

  @RegularTest
  Scenario Outline: Check Launch Specific Data
    Then User checks if '<ESFieldName>' has '<expectedESValue>' in launch '<launchNumber>'

    Examples:
    |ESFieldName|expectedESValue |launchNumber|
    |total      |30              |1           |
    |passed     |30              |1           |

  @RegularTest
  Scenario Outline: Check Launch All Data
    Then User checks if all fields have expectedValues in specific launch
    |<launchNumber>|<launchNumber>|<launchNumber>|
    |30            |25            |20            |
    |30            |20            |10            |
    |0             |5             |8             |
    |0             |0             |2             |
    |0             |4             |4             |
    |0             |1             |4             |
    |0             |0             |0             |
    |0             |2             |10            |

  Examples:
  |launchNumber|
  |1           |
  |2           |
  |3           |




