Feature: Number of stores based on selected state
Description: To Validate the number of stores returned based on selected state

Scenario: User selects AZ and TX
Given I am on the westelm homepage
Then I click Stores link to go to Store Locator page
Then I select a store to check the number of stores
And I quit the browser