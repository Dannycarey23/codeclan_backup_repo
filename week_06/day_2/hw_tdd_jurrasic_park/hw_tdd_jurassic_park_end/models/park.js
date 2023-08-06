const Park = function (name, ticketPrice) {
  this.name = name;
  this.ticketPrice = ticketPrice;
  this.dinosaurs = [];
}

Park.prototype.add = function (dinosaur) {
  this.dinosaurs.push(dinosaur);
}

Park.prototype.remove = function (dinosaur) {
  const index = this.dinosaurs.indexOf(dinosaur);
  this.dinosaurs.splice(index, 1);
}

Park.prototype.findMostAttractiveDinosaur = function () {
  let mostAttractiveDino = this.dinosaurs[0];

  for (const dino of this.dinosaurs) {
    if (dino.guestsAttractedPerDay > mostAttractiveDino.guestsAttractedPerDay) {
      mostAttractiveDino = dino;
    }
  }

  return mostAttractiveDino;
}

Park.prototype.findBySpecies = function (species) {
  const foundDinosaurs = [];

  for (const dinosaur of this.dinosaurs) {
    if (dinosaur.species === species) {
      foundDinosaurs.push(dinosaur);
    }
  }

  return foundDinosaurs;
}

Park.prototype.calculateTotalVisitorsPerDay = function () {
  let totalDailyVisitors = 0;

  for (const dinosaur of this.dinosaurs) {
    totalDailyVisitors += dinosaur.guestsAttractedPerDay;
  }

  return totalDailyVisitors;
}

Park.prototype.calculateTotalVisitorsPerYear = function () {
  return this.calculateTotalVisitorsPerDay() * 365;
}

Park.prototype.calculateTotalYearlyRevenue = function () {
  return this.ticketPrice * this.calculateTotalVisitorsPerYear();
}

Park.prototype.removeBySpecies = function (species) {
  const newDinosaurs = [];

  for (const dinosaur of this.dinosaurs) {
    if (dinosaur.species !== species) {
      newDinosaurs.push(dinosaur);
    }
  }

  this.dinosaurs = newDinosaurs;
}

Park.prototype.numberOfDinosaursByDiet = function () {
  const numberOfDinosaursByDiet = {};

  for (const dinosaur of this.dinosaurs) {
    if (numberOfDinosaursByDiet[dinosaur.diet]) {
      numberOfDinosaursByDiet[dinosaur.diet] += 1;
    }
    else {
      numberOfDinosaursByDiet[dinosaur.diet] = 1;
    }
  }

  return numberOfDinosaursByDiet;
}

module.exports = Park;
