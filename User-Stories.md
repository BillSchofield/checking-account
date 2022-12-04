# Checking Account User Stories
Work on these stories in order and only work on one story at a time. Avoid any new behavior that is not part of your 
current story.

## Open account
### Narrative
As a bank teller, I want to open an account for my customer so that I can help them manage their finances.

### Acceptance Criteria
When I submit my customer's application to Account Management  
Then I see confirmation that my customer's account was created
### Notes
The only information need for application is the account holder's name. Display their name as part of the confirmation 
message.
### Example
> Please enter the new account holder's name.  
> _Bill_  
> Account for Bill was created

## Account Balance
### Narrative
As a bank teller, I want to retrieve my customer's current balance, so that they can make better financial decisions.
### Acceptance Criteria
Given my customer has a checking account  
When I view their account  
Then I see their current balance  
### Notes
Assume that the initial balance for a checking account is $0.00. Show this balance immediately after account creation.
### Example
> Please enter the new account holder's name.  
> _Bill_  
> Account for Bill was created  
> Current balance is $0.00

## Menu option to create account
### Narrative
As a bank teller, I want to be able to choose to create an account separately from other activities
### Acceptance Criteria
When I choose the option to create an account  
Then I am prompted to create an account
### Example

> Please choose an option:  
> * **Create** an account
> 
> _create_

Existing account creation flow follows

## Quit option
### Narrative
As a bank teller, I want to be able to choose additional options after I complete the first one.
### Acceptance Criteria: Can choose to quit 
When I choose the option to quit 
Then I see a quit confirmation message
And am not prompted to enter more options
### Example
> Please choose an option:
> * **Create** an account
> * **Quit**
>
> _quit_  
> Your session has ended

### Acceptance Criteria: Can choose further options unless quitting
When I choose any option other than quit
Then I can choose my next option
### Example
> Please choose an option:
> * **Create** an account
> * **Quit**
>
> _create_  
> [account creation process occurs]
>
> Please choose an option:
> * **Create** an account
> * **Quit**
>
> ...

## Account numbers
### Narrative
As a bank teller, I want accounts to have associated numbers, so that I can distinguish one account from another.
### Acceptance Criteria: Accounts have numbers
When I create an account  
Then I see an account number for that account
### Example
> ...
> Please enter the new account holder's name.  
> _Bill_  
> Account #00000000 was created for Bill  
> Current balance is $0.00
### Acceptance Criteria: Accounts numbers are unique
Given at least one account has been created
When I create an account  
Then the account for the new account is unique

## Menu option to display account balance
### Narrative
As a bank teller, I want to be able to choose to display an account balance for a specific account
### Acceptance Criteria
When I choose the option to display account balance 
Then I see the balance for the selected account
### Example
> Please choose an option:  
> * **Create** an account  
> * Account **Balance**
> * **Quit**
> 
> _balance_  
> Enter account#  
> _00000001_  
> Account #0000001  
> Balance $0.00

## Make a deposit
### Narrative
As a bank teller, I want to deposit money into my customer's account, so that they can use it as a form of payment for  
their expenses.
### Acceptance Criteria
###### Balance Increases
Given my customer has a checking account  
When I deposit funds into their account  
Then their balance increases by the amount of the deposit  
And I see the updated balance
### Example
> ...  
> Enter account# for deposit  
> _00000001_  
> Enter amount of deposit  
> _1.00_  
> Account #0000001  
> Balance $1.00  

### Notes
This is only the happy path. Don't validate the account number or the deposit amount.

## Make a withdrawal
### Narrative
As a bank teller, I want to allow them to withdraw money from their accounts, so that they can use the funds for their 
expenses.
### Acceptance Criteria
###### Successful withdrawal
Given my customer has a checking account  
When I withdraw funds from their account  
Then their balance decreases by the amount of the deposit  
### Notes
This is only the happy path. Ignore the case of withdrawals that exceed the current balance.

## Withdrawal exceeds balance
### Narrative
As a bank teller, tell I want to prevent my customer from withdrawing more funds than they have to protect my banks assets and 
protect my customer from overdraft fees. 
### Acceptance Criteria
###### Withdrawal that would overdraw account
Given my customer has a checking account  
When I withdraw funds from their account greater than the current balance  
Then their balance remains the same  
And I receive a denial message  
### Notes
The denial message should include customer information, account balance, amount of attempted withdrawal and the amount 
that the withdrawal exceeds the current balance. 
