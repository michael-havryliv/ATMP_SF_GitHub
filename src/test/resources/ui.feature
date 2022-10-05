Feature: Sample UI Tests for DEMO Report Portal

  Background: User on All Dashboards Page
    Given User opens report portal
    And User logs in
    And User goes to All Dashboards page

  Scenario Outline:
    When User clicks Add New Dashboard button
    And User inputs dashboard name '<dashboardName>'
    And User clicks Add button
    And User goes to All Dashboards page
    Then User check dashboard name '<dashboardName>' exists

    Examples:
    |dashboardName       |
    |newRandomDashboard     |

