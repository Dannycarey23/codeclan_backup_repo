const assert = require('assert');
const Park = require('../models/park.js');
const Dinosaur = require('../models/dinosaur.js');

describe('Park', function() {

  let trex1;
  let trex2;
  let trex3;
  let velociraptor1;
  let velociraptor2;
  let diplodocus;
  let gallimimus;
  let park;

  beforeEach(function () {
    trex1 = new Dinosaur('t-rex', 'carnivore', 50);
    trex2 = new Dinosaur('t-rex', 'carnivore', 40);
    trex3 = new Dinosaur('t-rex', 'carnivore', 60);

    velociraptor1 = new Dinosaur('velociraptor', 'carnivore', 25);
    velociraptor2 = new Dinosaur('velociraptor', 'carnivore', 20);

    diplodocus = new Dinosaur('diplodocus', 'herbivore', 30);
    gallimimus = new Dinosaur('gallimimus', 'omnivore', 4);

    park = new Park('Jurassic Park', 20);
  })

  it('should have a name', function () {
    const actual = park.name;
    assert.strictEqual(actual, 'Jurassic Park');
  });

  it('should have a ticket price', function () {
    const actual = park.ticketPrice;
    assert.strictEqual(actual, 20);
  });

  it('should have a collection of dinosaurs', function () {
    const actual = park.dinosaurs;
    assert.deepStrictEqual(actual, []);
  });

  it('should be able to add a dinosaur to its collection', function () {
    park.add(trex1);
    const actual = park.dinosaurs;
    assert.deepStrictEqual(actual, [trex1]);
  });

  it('should be able to remove a dinosaur from its collection', function () {
    park.add(trex1);
    park.add(velociraptor1);
    park.remove(velociraptor1);
    const actual = park.dinosaurs;
    assert.deepStrictEqual(actual, [trex1]);
  });

  it('should be able to find the dinosaur that attracts the most visitors', function () {
    park.add(trex1);
    park.add(trex2);
    park.add(trex3);
    park.add(velociraptor1);
    park.add(diplodocus);
    park.add(gallimimus);
    const actual = park.findMostAttractiveDinosaur();
    assert.deepStrictEqual(actual, trex3);
  });

  it('should be able to find all dinosaurs of a particular species', function () {
    park.add(trex1);
    park.add(velociraptor1);
    park.add(velociraptor2);
    park.add(diplodocus);
    park.add(gallimimus);
    const actual = park.findBySpecies('velociraptor');
    const expected = [velociraptor1, velociraptor2];
    assert.deepStrictEqual(actual, expected);
  });

  it('should be able to calculate the total number of visitors per day', function () {
    park.add(trex1);
    park.add(trex2);
    park.add(trex3);
    park.add(velociraptor1);
    park.add(velociraptor2);
    park.add(diplodocus);
    park.add(gallimimus);
    const actual = park.calculateTotalVisitorsPerDay()
    assert.strictEqual(actual, 229);
  });

  it('should be able to calculate the total number of visitors per year', function () {
    park.add(trex1);
    park.add(trex2);
    park.add(trex3);
    park.add(velociraptor1);
    park.add(velociraptor2);
    park.add(diplodocus);
    park.add(gallimimus);
    const actual = park.calculateTotalVisitorsPerYear();
    assert.strictEqual(actual, 83585);
  });

  it('should be able to calculate total revenue for one year', function () {
    park.add(trex1);
    park.add(trex2);
    park.add(trex3);
    park.add(velociraptor1);
    park.add(velociraptor2);
    park.add(diplodocus);
    park.add(gallimimus);
    const actual = park.calculateTotalYearlyRevenue();
    assert.strictEqual(actual, 1671700);
  });

  it('should be able to remove all dinosaurs of a particular species', function () {
    park.add(trex1);
    park.add(velociraptor1);
    park.add(velociraptor2);
    park.add(diplodocus);
    park.add(gallimimus);
    park.removeBySpecies('velociraptor');
    const actual = park.dinosaurs;
    const expected = [trex1, diplodocus, gallimimus];
    assert.deepStrictEqual(actual, expected);
  });

  it('should be able to calculate number of dinosaurs for each diet type', function () {
    park.add(trex1);
    park.add(trex2);
    park.add(trex3);
    park.add(velociraptor1);
    park.add(velociraptor2);
    park.add(diplodocus);
    park.add(gallimimus);
    const actual = park.numberOfDinosaursByDiet();
    const expected = { carnivore: 5, herbivore: 1, omnivore: 1 };
    assert.deepStrictEqual(actual, expected);
  });

});
