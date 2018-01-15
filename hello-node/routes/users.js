'use strict';

const express = require('express');
const router = express.Router();

const db = require('../datasource/datasource');

/* GET users listing. */
router.get('/', function (req, res, next) {
    db.findAllUsers()
        .then(buffer => {
            // API to make it possible to interact with octet streams
            // in the context of things like TCP streams and file system operations.
            res.json(JSON.parse(buffer.toString())); // print out the data inside
        })
        .catch(() => res.send('error getting all users'));
});

router.get('/:id', function (req, res, next) {
    db.findUserById(req.params.id)
        .then(user => res.json(user))
        .catch(() => next());
});

module.exports = router;
