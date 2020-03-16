@End2End
Feature: Login for Edureka

Scenario Outline: Login functionality for a Edureka site

Given user navigates to Site
Then click on SignIN link
When I enter Username "<Username>" and "<Password>" Password
When I click on Login button
Then login should be successful

Examples:
| Username 									  	|  Password  	|
| kanchan.bagale@softenger.com  | softenger@123	| 
