Feature: Valid and Invalid SKU Search 
Description: To Validate if sku search returns the right image

Scenario: User performs a valid SKU search
Given I am at the westelm homepage
Then I enter the sku number in the search box
And I click the search icon
Then I navigate to the result page 
And I close the browser

Scenario: User performs an invalid SKU search
Given I am at the westelm homepage
Then I enter the sku number in the search box
And I click the search icon
Then I get a search result message
And I close the browser