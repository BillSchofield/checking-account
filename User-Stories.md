# Checking Account User Stories
Work on these stories in order and only work on one story at a time. Avoid any new behavior that is not part of your 
current story.

## Open account
### Narrative
As a bank teller, I want to open an account for my customer so that I can help them manage their finances.

### Acceptance Criteria
###### Account Creation Confirmation
When I submit my customer's account information
Then I see confirmation that their account was created.
### Notes
The only account information needed is the account holder's name. Display their name as part of the confirmation 
message.

## Account Balance
### Narrative
As a bank teller, I want to retrieve my customer's current balance, so that they can make better financial decisions.
### Acceptance Criteria
###### I see my balance
Given my customer has a checking account
When I view their account  
Then I see their current balance  
### Notes
Assume that the initial balance for a checking account is $0.00. Show this balance immediately after account creation.

## Choose options
### Narrative
As a bank teller, I want to be able to choose to perform different activities.
### Acceptance Criteria
###### Create account option
When I choose to create an account
Then I am prompted to 

## Make a deposit
### Narrative
As a bank teller, I want to deposit money into my customer's account, so that they can use it as a form of payment for  
their expenses.
### Acceptance Criteria
###### Balance Increases
Given my customer has a checking account
When I deposit funds into their account
Then their balance increases by the amount of the deposit

### Notes
Redisplay the balance after the deposit is made

## Make a withdrawal
### Narrative
As a bank teller, I want to withdraw money from my customer's account, so that they can use the funds for their expenses.
### Acceptance Criteria
###### Successful withdrawal
Given my customer has a checking account
When I withdraw funds from their account
Then their balance decreases by the amount of the deposit
### Notes
Ignore the case of withdrawals that exceed the current balance

## Withdrawal exceeding balance
### Narrative
As a bank, tell I want to prevent my customer from withdrawing more funds than they have to protect my banks assets and 
protect my customer from overdraft fees. 
### Acceptance Criteria
###### Withdrawal that would overdraw account
Given my customer has a checking account
When I withdraw funds from their account greater than their current balance
Then their balance remains the same
And I receive a denial message
### Notes
The denial message should include customer information, account balance, amount of attempted withdrawal and the amount 
that the withdrawal exceeds the current balance. 
