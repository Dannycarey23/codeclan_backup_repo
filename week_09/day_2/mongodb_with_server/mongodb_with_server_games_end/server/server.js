const express = require('express');
const app = express();
const MongoClient = require('mongodb').MongoClient;
const createRouter = require('./helpers/create_router.js');
const cors = require('cors')

app.use(express.json());
app.use(cors())

MongoClient.connect('mongodb://127.0.0.1:27017', { useUnifiedTopology: true })
.then((client) => {
  const db = client.db('games_hub');
  const gamesCollection = db.collection('games');
  const gamesRouter = createRouter(gamesCollection);
  app.use('/api/games', gamesRouter);

})
.catch(console.error);


app.listen(9000, function () {
  console.log(`Listening on port ${ this.address().port }`);
});
