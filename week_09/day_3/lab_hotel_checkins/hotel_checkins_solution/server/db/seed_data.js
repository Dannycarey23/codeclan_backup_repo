use hotel_checkins;
db.dropDatabase();

db.bookings.insertMany([
  {
    "name": "Anselm Kermon",
    "email": "akermon0@gnu.org",
    "checked_in": true
  },
  {
    "name": "Meriel Geeve",
    "email": "mgeeve1@statcounter.com",
    "checked_in": true
  },
  {
    "name": "Aida Diggons",
    "email": "adiggons2@w3.org",
    "checked_in": false
  },
  {
    "name": "Devlin Sigsworth",
    "email": "dsigsworth3@last.fm",
    "checked_in": false
  },
  {
    "name": "Jesse Bellhanger",
    "email": "jbellhanger4@time.com",
    "checked_in": false
  },
  {
    "name": "Filberte Blaisdell",
    "email": "fblaisdell5@pen.io",
    "checked_in": true
  },
  {
    "name": "Randa Helks",
    "email": "rhelks6@sina.com.cn",
    "checked_in": true
  },
  {
    "name": "Octavia Jaksic",
    "email": "ojaksic7@eventbrite.com",
    "checked_in": false
  },
  {
    "name": "Jenna Dyhouse",
    "email": "jdyhouse8@mac.com",
    "checked_in": true
  },
  {
    "name": "Berty Bartrop",
    "email": "bbartrop9@smugmug.com",
    "checked_in": false
  }
]);
