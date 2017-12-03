const express = require('express');
const router = express.Router();

// Let's try the EVENTS!!
const EventEmitter = require('events');
const timeEmitter = new EventEmitter();

let timing = 0;

// The EventEmitter calls all listeners synchronously in the order in which they were registered
timeEmitter.on('event', () => {
    setImmediate(() => {
        console.log('this happens asynchronously');
    });
    timing++;
});
timeEmitter.prependListener('event', () => console.log('prepended listener'));


/* GET home page. */
router.get('/', function (req, res, next) {
    res.json({time: timing});
});

router.get('/stop', function (req, res, next) {
    clearInterval(intervalObj);
    res.json({time: timing});
});

const intervalObj = setInterval(() => {
    timeEmitter.emit('event');
}, 1000);

module.exports = router;