Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly








  Scenario Outline: Check add product to wishlist
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User makes search by keyword '<keyword>'
    When User check that search results contains '<keyword>'
    When User change min price to '<minValue>'
    And  User change max price to '<maxValue>'
    When User submit price range
    When User select first product from search result


    Examples:
      | homePage                | keyword       | minValue | maxValue |
      | https://www.ebay.com/   |  ball | 100.00   | 200.00   |


