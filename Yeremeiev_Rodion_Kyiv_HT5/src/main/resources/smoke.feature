Feature: Smoke
  As a user
  I want to test all main site functionality
  According to TA Home Task# requirements
  So that I can be sure that site works correctly

  Scenario Outline: Check Home Page main functionality
    Given User opens '<homePage>' page
    And User checks header visibility
    And User checks footer visibility
    And User checks search field visibility
    And User checks my account popup visibility
    And User checks saved items button visibility
    When User check bag button visibility
    Then User checks that sale popup is visible and contains <saleElements> in Shop sale by product section
    And User checks that New in popup is visible and contains <newIn> in New Products section
    And User checks that Topman popup is visible and contains <topMan> in Shop by product section

    Examples:
      | homePage                  | saleElements | newIn | topMan |
      | https://www.asos.com/men/ | 24           | 9     | 12     |


  Scenario Outline: Check save item
    Given User opens '<homePage>' page
    And User clicks on sunnies button
    And User clicks save for later button on round sunglasses
    And User clicks on Ray-Ban sunglasses to go to Product page
    And User clicks on save item from Product page
    When User clicks on saved items
    Then User checks that list of saved products contains <numberOfElements> elements

    Examples:
      | homePage                  | numberOfElements |
      | https://www.asos.com/men/ | 2                |


  Scenario Outline: Check Women's Sale Carousel
    Given User opens '<homePage>' page
    And User clicks on Women button
    And User checks that Women's Sale Carousel is visible
    And User checks that correct initial titles are displayed
    And User clicks on Carousel scroll forward button
    And User checks that Carousel where scrolled forward
    And User checks that correct titles are displayed after scrolling forward
    When User clicks on Carousel scroll backward button
    And User checks that Carousel where scrolled backward
    And User checks that Carousel correct titles are displayed after scrolling backward
    Then User checks that Carousel has correct <amount> of elements

    Examples:
      | homePage                  | amount |
      | https://www.asos.com/men/ | 7      |


  Scenario Outline: Check Search Product
    Given User opens '<homePage>' page
    And User enters search '<keyword>' to search field
    And User clicks Search button
    When User checks that all search results contains '<keyword>'
    And User checks that URL contains '<keyword>'
    And check that Search result title contains '<keyword>'
    Then User checks that search result page contains correct <amount> of products

    Examples:
      | homePage                  | keyword    | amount |
      | https://www.asos.com/men/ | converse   | 136    |
      | https://www.asos.com/men/ | nike       | 546    |
      | https://www.asos.com/men/ | timberland | 66     |


  Scenario Outline: Check registration with valid parameters
    Given User opens '<homePage>' page
    And User moves cursor to My Account button
    And User clicks Join Button at popup menu
    And User enters valid Email into registration form
    And User enters valid First Name registration form
    And User enters valid Last Name registration form
    And User enters valid Password registration form
    And User selects date of birth
    When User clicks on Select All button for Contact Preferences
    And User checks that all input fields are valid
#    And User clicks on Join Asos button
    Then User opens '<homePage>' again to check if registration were successful

    Examples:
      | homePage                  |
      | https://www.asos.com/men/ |

  Scenario Outline: Check log-in with Invalid parameters
    Given User opens '<homePage>' page
    And User moves cursor to My Account button
    And User clicks Sign In button
    And User input Invalid '<email>' in email form and click Enter
    And User input Invalid '<password>' in password form and click Enter
    When User clicks Submit Button
    Then User checks are Warning displayed

    Examples:
      | homePage                  | email | password |
      | https://www.asos.com/men/ | >.<   |          |


  Scenario Outline: Check registration with Invalid parameters
    Given User opens '<homePage>' page
    And User moves cursor to My Account button
    And User clicks Join Button at popup menu
    And User enters Invalid '<email>' into Email field of registration form and Press Enter
    And User enters Invalid '<firstName>' into First name field of registration form and Press Enter
    And User enters Invalid '<lastName>' into Last name field of registration form and Press Enter
    When User enters Invalid '<password>' into Password field of registration form and Press Enter
    Then User checks that all input fields are displaying error warnings

    Examples:
      | homePage                  | email      | firstName | lastName | password |
      | https://www.asos.com/men/ | sdfsfsfsdf | <.>       | >.<      | ~        |
