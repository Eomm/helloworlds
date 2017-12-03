'use strict';
const app = require('../app');

app.listen(3000, function () {
    // These __* are 2/5 globals objects
    console.log("File " + __filename + " on dir " + __dirname);
    console.log("Server UP and running");
});

// this assignment is possible thank sto process.nextTick()
process.on('uncaughtException', (err) => {
    console.error('whoops! there was an error not intercepted', err);
});