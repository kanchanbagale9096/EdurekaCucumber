@FunctionalTest
Feature: Banking Application

@SmokeTest @RegressionTest
Scenario: Successful Login
Given user is on Login page

@RegressionTest
Scenario: UnSuccessful Login
Given This is an unsuccessful login test

@SmokeTest 
Scenario: Add customer account
Given This is a Add customer account test

Scenario: Add customer account details
Given This is a Add customer account details test

@SmokeTest @RegressionTest
Scenario: Check Customer bank balance enquiry
Given This is Customer bank balance enquiry test

@RegressionTest
Scenario: KYC done
Given This is KYC test

@SmokeTest
Scenario: Get CIBIL score
Given This is a CIBIL score test

Scenario: Transfer money to another Account
Given This is a transfer money test

@SmokeTest @End2End
Scenario: Get Bank Statement
Given This is a blank test

@SmokeTest @End2End
Scenario: Transfer Fund
Given This is a Transfer Fund test

@SmokeTest
Scenario: Logout
Given User is on login page
Then user click on logout link

@End2End
Scenario Outline: Payment declined
Given This is a payment declined
Examples:
|PaymentMethod|
|CC Card|
|DD Card|
|Bank Transfer|
|PayPal|
|Cash|