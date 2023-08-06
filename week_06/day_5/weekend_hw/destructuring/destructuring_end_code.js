// array destructuring:
const names = ["Fred", "Kate", "Cindy", "Ricky", "Keith"];
console.log(names);

const [fred, kate, ...remainingNames] = names;
console.log(kate);
console.log(remainingNames);


// object destructuring:
const person = {
  name: "Joni",
  age: 76
}
// const name = person.name;
// const age = person["age"];
const { name, age } = person;

console.log(name);
console.log(age);