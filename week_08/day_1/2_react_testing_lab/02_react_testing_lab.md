## Section B: JavaScript Calculator Testing

**NOTE: This exercise should be done individually because it is part of the PDA**

This activity relates to the following Outcome and Knowledge/Skills:
|-----------------------------------------------------------------
|Outcome 4: Test programs using a range of approaches
|Carry out unit testing
|Carry out integration testing
|Check the software meets specified requirements and carry out User Acceptance Testing.

# JavaScript Calculator

User requirements:
“As a user I want to be able to perform simple arithmetic functions in a web browser.”

The start code provided has a Calculator model with methods to add, subtract, divide, and multiply given numbers to a total (`src/containers/Calculator.js`). The Calculator model has properties to keep track of calculations as it performs them. There is also a UI model to display the buttons and trigger click events (`src/components/Keypad.js`)

The model is used in a web application, which allows a user to chain multiple operations one after the other, and then ask for the total.

Your task is to complete both unit and integration testing on the Calculator and KeyPad components and the UI. You will be using React Testing Library to complete the tests on the Calculator component, and another testing framework - Cypress - to complete the UI tests.

## SETUP

- To install project dependencies: `npm install`
- To run the server: `npm start`
- To view application visit 'http://localhost:3000'
- To run the unit tests: `npm test`
- To run the UI integration tests with Cypress:
    1. Leave the server running, and open a new tab in Terminal.
    2. Run `npm run test:e2e` to open Cypress test suite.
    3. Run the `calculator.spec.js` file in Cypress to run the integration tests.
  

## Tasks

### Unit Tests

You need to test the Calculator model using the React testing library. Write your tests in `src/tests/Calculator.test.js`. Test the following functions perform the following tasks:

- `calculator.add()` - add 1 to 4 and get 5
- `calculator.subtract()` subtract 4 from 7 and get 3
- `calculator.multiply()` - multiply 3 by 5 and get 15
- `calculator.divide()` - divide 21 by 7 and get 3
- `calculator.numberClick()` - concatenate multiple number button clicks
- `calculator.operatorClick()` - chain multiple operations together
- `calculator.clearClick()` - clear the running total without affecting the calculation

### UI Integration Tests

You need to write front-end integration tests to ensure the Calculator model and browser UI are working to meet the user requirements. The framework provided to do this is Cypress.. There is one sample test written in `/cypress/integration/calculator.spec.js` and you should continue writing your tests in this file.

You should write tests to ensure the following requirements are met:

1. Do the number buttons update the display of the running total?
2. Do the arithmetical operations update the display with the result of the operation?
3. Can multiple operations be chained together?
4. Is the output as expected for a range of numbers (for example, positive, negative, decimals and very large numbers)?
5. What does the code do in exceptional circumstances? Specifically, if you divide by zero, what is the effect? Write a test to describe what you'd prefer to happen, and then correct the code to make that test pass (you will need to modify the Calculator model to meet this requirement).