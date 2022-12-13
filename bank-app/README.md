# Banking App User Stories
Work on these stories in order and only work on one story at a time. Avoid any new behavior that is not part of your
current story.

## Update Account Page
### Narrative
As a bank customer, I want to view my account balance, with options to deposit or withdraw.

### Acceptance Criteria
When open the bank application  
Then I see my account balance listed with my name, a place to enter an amount, and buttons to deposit and withdraw.
### Notes
The only information need for application is the account balance and customers name. Assume that the initial balance for a checking account is $0.00.

Mockup - in this page you see an account page with some text and buttons.

## Deposit Confirmation
### Narrative
As a bank customer, I want to be able to perform a deposit
### Acceptance Criteria
Given I am on the Account page,
when I click deposit,
Then I see my account balance with an updated amount.

Mockup - with this confirmation, the amount is updated once deposit button is clicked

## Withdraw Confirmation
### Narrative
As a bank customer, I want to be able to confirm a withdrawal
### Acceptance Criteria
Given I am on the withdrawal screen,
when I click sumbit,
Then I see my account balance with an updated amount.

Mockup - with this confirmation, the amount is updated once withdrawal button is clicked
