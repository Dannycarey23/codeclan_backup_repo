const myNumbers = [1, 2, 3, 4, 5];

for (const number of myNumbers) {
  console.log(`This is number ${number}`)
}

myNumbers.forEach((number, index) => {
  console.log(`This is number ${number} at index position ${index}`);
});

// const multiplyByTwo = function (numbers) {
//   const result = [];
//
//   numbers.forEach((number) => {
//     const multiplied = number * 2;
//     result.push(multiplied);
//   });
//
//   return result;
// }

const multiplyByTwo = function (numbers) {
  const result = numbers.map((number) => {
    return number * 2;
  });

  return result;
}

console.log(multiplyByTwo(myNumbers));

// const getEvens = function (numbers) {
//   const result = [];
//
//   numbers.forEach((number, index) => {
//     if (number % 2 === 0) {
//       result.push(number);
//     }
//   });
//
//   return result;
// }

const getEvens = function (numbers){
  const result = numbers.filter((number) => {
    return number % 2 === 0;
  });

  return result;
}

console.log(getEvens(myNumbers));

// const sumElements = function (numbers) {
//   let total = 0;
//
//   numbers.forEach((number) => {
//     total += number;
//   })
//
//   return total;
// }

const sumElements = function (numbers) {
  const total = numbers.reduce((runningTotal, number) => {
    return runningTotal + number;
  }, 0);

  return total;
}

console.log(sumElements(myNumbers));

const ourForEach = function (array, callback) {
  for (const element of array) {
    callback(element);
  }
};

const numbers = [1, 2, 3, 4, 5];

ourForEach(numbers, (number) => {
  console.log('the number is:', number);
});
