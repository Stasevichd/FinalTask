Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline:Check visibility main elements on HomePage
    Given User opens '<homePage>' page
    When  User checks search field visibility
    And   User check Sign in button visibility
    And   User checks shopping cart visibility
    And   User checks register button visibility
    And   User checks main logo visibility
    And   User checks Header visibility
    And   User checks Footer visibility
    And   User checks ship To button
    Examples:
      | homePage               |
      |https://www.ebay.com/   |



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
    #  Next steps was implement, but don`t use because Captcha is present.

    # When  User checks Pay methods form visibility
    #And User checks Ship to form visibility
    #And  User checks Confirm and pay button visibility

    Examples:
      | homePage                | keyword|indexFromSearchResultList |
      | https://www.ebay.com/   |  ball  |           1              |


    Scenario Outline: Check search result price filter
      Given User opens '<homePage>' page
      And User checks search field visibility
      And User makes search by keyword '<keyword>'
      When User check that search results contains '<keyword>'
      When User change min price to '<minValue>'
      And  User change max price to '<maxValue>'
      And User submit price range
      When User checks that products price is beetwen '<minValue>' and '<maxValue>'

      Examples:
        | homePage                | keyword | minValue | maxValue |
        | https://www.ebay.com/   |  ball   | 250.00   | 500.00   |

Scenario Outline: Check remove product from shopping cart

    Given User opens '<homePage>' page
    And User checks search field visibility
    And User makes search by keyword '<keyword>'
    When User check that search results contains '<keyword>'
    When User select product with '<indexFromSearchResultList>' from result list
    When  User checks  addToCart button visibility
    And User checks that description of product is visible
    And  User checks  buyNow button visibility
    And  User checks quantity field visibility
    When User clicks 'add to cart'
    When User checks  opened shopping cart
    When User check Remove button visibility
    And  User removes products from shopping cart
    And  User checks that  shopping cart is empty

  Examples:
    | homePage                | keyword| indexFromSearchResultList|
    | https://www.ebay.com/   |  ball  | 2                        |


  Scenario Outline: Check add product to shopping cart and continue shopping another product
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User makes search by keyword '<firstKeyword>'
    When User check that search results contains '<firstKeyword>'
    When User select product with '<indexFirstProduct>' from result list
    When  User checks  addToCart button visibility
    And User checks that description of product is visible
    And  User checks  buyNow button visibility
    And  User checks quantity field visibility
    When User clicks 'add to cart'
    When User checks  opened shopping cart
    When User back to homepage
    And User makes search by keyword '<secondKeyword>'
    When User select product with '<indexSecondProduct>' from result list
    When User clicks 'add to cart'
    When User checks that opened shopping cart contains '<count>' products
    Examples:
      | homePage                | firstKeyword| indexFirstProduct|secondKeyword|indexSecondProduct|count|
      | https://www.ebay.com/   |  ball       | 2                | rc toys     |3                 |2    |



  Scenario Outline: Check buy negative Product quantity

    Given User opens '<homePage>' page
    And User checks search field visibility
    And User makes search by keyword '<firstKeyword>'
    When User check that search results contains '<firstKeyword>'
    When User select product with '<indexFirstProduct>' from result list
    When  User checks  addToCart button visibility
    And User checks that description of product is visible
    And  User checks quantity field visibility
    When User enters '<negativeValue>' to quantity field
    When User checks error message visibility

    Examples:
      | homePage                | firstKeyword|indexFirstProduct |negativeValue|
      | https://www.ebay.com/   |  ball       |           1      | -5          |
      |https://www.ebay.com/    |  ball       |     1            |     1000000 |


  Scenario Outline: Check search result condition filter
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User makes search by keyword '<keyword>'
    When User check that search results contains '<keyword>'
    When User selects 'new condition'  filter
    When User checks products only 'new condition' status

    Examples:
      | homePage                | keyword |
      | https://www.ebay.com/   |  ball   |


  Scenario Outline: Check search result Auction filter
    Given User opens '<homePage>' page
    And User checks search field visibility
    And User makes search by keyword '<keyword>'
    When User check that search results contains '<keyword>'
    When User selects Only Auction  filter
    When User checks products only Auction status

    Examples:
      | homePage                | keyword |
      | https://www.ebay.com/   |  ball   |







