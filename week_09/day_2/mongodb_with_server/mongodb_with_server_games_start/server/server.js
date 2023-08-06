const express = require('express');
const app = express();

app.use(express.json());

app.listen(9000, function () {
  console.log(`Listening on port ${ this.address().port }`);
});
