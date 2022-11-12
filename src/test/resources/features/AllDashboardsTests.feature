
Feature: All Dashboards Tests

  @RegularTest
  Scenario Outline: Add new dashboard test
    When User opens Report Portal
    And User logs in
    And User goes to ALlDashboards Page
    And User clicks addNewDashboard button
    And User inputs '<dashboardsName>' in dashboard field
    And User clicks add button
    And User goes to ALlDashboards Page
    Then User checks if dashboard '<dashboardsName>' exists

    Examples:
    |dashboardsName     |
    |someDashboardName5  |