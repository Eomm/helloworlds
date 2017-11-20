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


        });


    res.send('respond with a resource');
});

router.get('/:id', function (req, res, next) {
    db.findUserById(req.params.id)
        .then(user => res.json(user))
        .catch(() => next());
});

module.exports = router;
