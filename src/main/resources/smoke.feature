Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check add product to shopping cart
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User makes search by keyword '<keyword>'
    When User check that search results contains '<keyword>'
    When User select product with '<indexFromSearchResultList>' from result list
    When  User checks  addToCart button visibility
    And  User checks  buyNow button visibility
    And  User checks quantity field visibility
    When User clicks 'add to cart'
    When User checks  opened shopping cart
    And User checks 'Go to checkout' button visibility
    And User clicks 'Go to checkout' button
    When User clicks Continue as Guest button
    When  User checks Pay methods form visibility
    And User checks Ship to form visibility
    And  User checks Confirm and pay button visibility

    Examples:
      | homePage                | keyword|indexFromSearchResultList |
      | https://www.ebay.com/   |  ball  |           1              |


    Scenario Outline: Check search result filters
      Given User opens '<homePage>' page
      And User checks search field visibility
      And User makes search by keyword '<keyword>'
      When User selects "new condition"  filter
      When User checks products only "new condition" status
      When User change min price to '<minValue>'
      And  User change max price to '<maxValue>'
      And User submit price range
      When User checks products price from search result

      Examples:
        | homePage                | keyword | minValue | maxValue |
        | https://www.ebay.com/   |  ball   | 100.00   | 200.00   |

Scenario Outline: Check remove product from shopping cart

    Given User opens '<homePage>' page
    And User checks search field visibility
    And User makes search by keyword '<keyword>'
    When User check that search results contains '<keyword>'
    When User select product with '<indexFromSearchResultList>' from result list
    When User checks that description of product is visible
    And  User checks  addToCart button visibility
    And  User checks  buyNow button visibility
    And  User checks quantity field visibility
    When User adds product to cart
    When User opens shopping cart page
    When User checks that shopping cart contains product
    And  User checks qantity field visibility
    And  User changes quantity of product to '<count>'
    When User check  that product quantity is '<count>'
    When User check REMOVE button visibility
    And  User removes products from shopping cart
    And  User checks that shopping cart is empty

  Examples:
    | homePage                | keyword| count|
    | https://www.ebay.com/   |  ball  |   2  |


  Scenario Outline: Check error






      And  User change max price to '<maxValue>'
    When User submit price range
  Examples:
    | maxValue |


  Scenario Outline: Check add filter to search result list
    Given User opens '<homePage>'
    And  User checks search field visibility
    And  User makes search by keyword '<keyword>'



  Examples:
    |  |
