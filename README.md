# Zeal Android Payment Flow Assignment

## Application Overview
The provided application simulates a straightforward payment process.

## User Flow
1. The user inputs the payment amount.
2. A dialog prompts the user to enter their card number, simulating a customer tapping or inserting their card.
3. Transaction being processed by the bank.
4. Following the transaction processing, a receipt screen is displayed.

## Task Description
Develop a simple application that interfaces with the provided payment app to exchange and manage data related to payment transactions. This involves sending transaction details to a loyalty application, applying potential discounts, and adjusting the final charge amount based on these interactions.

## Assignment Tasks

### Payment Application
- Before initiating contact with the bank, the application should send transaction details to the Loyalty Application.
- Based on the response from the Loyalty Application, proceed with the modified transaction amount.

### Loyalty Application

#### Discount Management
- Include an option to set a specific discount on incoming transactions.
- If the amount is set to 0 this means that there is no discount applied.

#### Transaction Processing
- If the discount covers the entire amount, conclude the process without contacting the bank.
- If there remains an amount to be charged after applying the discount, instruct the payment application to continue the process with the bank with the updated amount.
- If there’s no discount amount, the payment application should complete the transaction normally.

## Important Notes
- **UI Design:** There is no requirement to focus on developing the user interface; You’ll not be assessed based on the UI Design.
- **Discount Logic:** Implement a simple discount mechanism. The discount is either a flat amount applied directly or no discount at all.

## Task Submission
1. Fork the existing payment application repository to start working on your modifications.
2. Create a new repository for the Loyalty Demo Application and upload your app there.
3. Submit links to both repositories upon completion.
