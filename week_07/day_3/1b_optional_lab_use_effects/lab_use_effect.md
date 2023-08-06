#  Lab: FizzBuzz with React's `useEffect`
**Lab Duration: 60 mins**

### Learning Objectives
 - Understand how the `useEffect` hook works in React
 - Be able to utilise the `useEffect` hook in order to implement a simple game

## Task

You have been tasked with making a simple version of the game **FizzBuzz** using React (*[game rules below](#game-rules)*).

### MVP

Your app should:
 - keep track of the "current number" in the game
 - display the correct corresponding output for the current number
 - allow the user to increment the current number.

You should implement React's `useEffect` hook in order to work out the intended output.

### Extension

  - Add some other, unrelated variable to your state. Implement some way for this to be modified via user interaction. Verify that you are only invoking the function passed to `useEffect` when you absolutely have to.

### Advanced Extension
  - Gamify the app so that the user has to provide the corresponding output for the number. You couuuuuld:
     - hide the "correct" output and verify user input against this
     - allow users to respond in different casing e.g. ""FIZZ"
     - implement a timer so they need to respond quickly
     - add anything else you can think of!

## <a name="game-rules"></a>FizzBuzz

FizzBuzz is a simple word game used to teach children about division. The rules are as follows:
  1. Start a counter at the number **1**.
  2. Increment the counter on each turn. The output number will be the same as the input number, *unless*:
      - The number is divisble by 3. In this case, the output will be *Fizz*
      - The output is divisible by 5. In this case, the output will be *Buzz*
      - The output is divisible by both 3 and 5. In this case, the output will be *FizzBuzz*.

The output values should be, sequentially, as follows:
> 1, 2, *Fizz*, 4, *Buzz*, *Fizz*, 7, 8, *Fizz*, *Buzz*, 11, Fizz, 13, 14, *FizzBuzz*, 16, 17, *Fizz*, 19, *Buzz*, *Fizz*, 22, 23, *Fizz*, *Buzz*, 26, *Fizz*, 28, 29, *FizzBuzz*, 31, 32, Fizz, ...

...etc.

 See more on [wikipedia](https://en.wikipedia.org/wiki/Fizz_buzz).

## Hints:
- You will need:
  - A state variable for the current number in the game
  - A state variable for the corresponding output for the current number
  - Some way of displaying these state variables on screen
  - A button to increment the current number.
- Don't worry too much about components here: one component will likely be sufficient.
- The purpose of this exercise is to become proficient in using the `useEffect` hook. Any logic should be called from here, and not in e.g. an event handler.
- Finally we don't need you spending time figuring out the fizz buzz logic. If you **want it** here's the code for just working out fizz-buzz: 
```
if (inputNumber % 3 === 0 && inputNumber % 5 === 0) {
      setAnswer("fizzbuz")
    } else if (inputNumber % 3 === 0) {
      setAnswer("fizz")
    } else if (inputNumber % 5 === 0) {
      setAnswer("buzz")
    } else {
      setAnswer(inputNumber);
    }
```
 
