const express = require('express');
const router = express.Router();

// Let's try the EVENTS!!
const EventEmitter = require('events');
const timeEmitter = new EventEmitter();

let timing = 0;

// EcmaScript6 - Symbol
const eventEmitted = Symbol('my event');

// The EventEmitter calls all listeners synchronously in the order in which they were registered
timeEmitter.on(eventEmitted, () => {
    setImmediate(() => {
        console.log('this happens asynchronously');
    });
    timing++;
});
timeEmitter.prependListener(eventEmitted, () => console.log('prepended listener'));


/* GET home page. */
router.get('/', function (req, res, next) {
    res.json({time: timing});
});

router.get('/stop', function (req, res, next) {
    clearInterval(intervalObj);
    res.json({time: timing});
});

const intervalObj = setInterval(() => {
    timeEmitter.emit(eventEmitted);

    if (timing == 5) {
        console.log("Stopping emitter");
        clearInterval(intervalObj);
    }
}, 1000);

module.exports = router;