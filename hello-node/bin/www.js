'use strict';
const app = require('../app');
const PORT = process.env.PORT || 3000;

var server = app.listen(PORT, function () {
    // These __* are 2/5 globals objects
    console.log("File " + __filename + " on dir " + __dirname);
    console.log("Server UP and running");
});

// this assignment is possible thank sto process.nextTick()
process.on('uncaughtException', (err) => {
    console.error('whoops! there was an error not intercepted', err);
});

// quit on ctrl-c when running docker in terminal
process.on('SIGINT', function onSigint() {
    console.info('Got SIGINT (aka ctrl-c in docker). Graceful shutdown ', new Date().toISOString());
    shutdown();
});

// quit properly on docker stop
process.on('SIGTERM', function onSigterm() {
    console.info('Got SIGTERM (docker container stop). Graceful shutdown ', new Date().toISOString());
    shutdown();
});

process.on('beforeExit', function (exitCode) {
    console.log("Before exit, loop event empty");
});

// shut down server
function shutdown() {
    server.close(function onServerClosed(err) {
        if (err) {
            console.error(err);
            process.exitCode = 1;
        }
        process.exit();
    })
}