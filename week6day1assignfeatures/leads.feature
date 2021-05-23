Feature: Login to the Leataps Application 

Background:
Given Launch Chrome browser
When Load URL'http://Leaftaps.com/opentaps'
When Type username as 'DemoSaleManager'
And Type password as 'crmsfa'
And Click Login Button 
And Click CRM/SFA 
And Click on the Leads


Scenario Outline: Login (PositiveMultipleData)

 

And Click to create leads
And Type CompanyName as<companyName>
And Type FirstName as<firstName>
And Type LastName as<lastName>
Then Click submitt

Examples:

|companyName|firstName|lastName|
|Atina|ANi|NANu|
|SHOPATINa|NANUKumar|ANitha|

