Feature: Login into application
Scenario Outline: Positive Test Login

Given Browser is initialized
And Navigate to "http://www.qaclickacademy.com/"
And Click on Login Link in HomePage
When User enters <Username> and <Password> then clicks Login
Then User is successfully logged in

Examples:
|Username    |Password    |
|diptee.shirsekar@gmail.com |Shaurya#123|
|diptee.shir1sekar@gmail.com |Shaurya#123|
