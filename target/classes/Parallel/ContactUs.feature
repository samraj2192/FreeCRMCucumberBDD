Feature: Contact us feature

Scenario Outline: Contact us scenario with different sets of data
Given user anvigates to contact us page
When user fills form with given sheetname "<SheetName>" and rownumber <RowNumber>
And user clicks on send button
Then it shows a message "Your message has been successfully sent to our team."

Examples:
|SheetName|RowNumber|
|contactus|0|
|contactus|1|