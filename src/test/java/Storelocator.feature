Feature: Number of stores based on selected state
Description: To Validate the number of stores returned based on selected state

Scenario: User selects AZ and TX
Given I am on the westelm homepage
Then I click Stores link to go to Store Locator page
Then I select View All Stores link
Then I validate the number of stores returned
Then I select Texas from the Select Your State drop down
And I validate the number of stores returned 
And I quit the browser
