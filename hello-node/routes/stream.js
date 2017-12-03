const express = require('express');
const router = express.Router();

const stream = require('stream');
const fs = require('fs');

router.get('/', function (req, res, next) {

    var readableStream = fs.createReadStream('../public/assets/table.txt');
    var data = '';

    readableStream.setEncoding('utf8');

    readableStream.on('data', function (chunk) {
        data += chunk;
    });

    // Another way for read the stream
    readableStream.on('readable', function () {
        while ((chunk = readableStream.read()) != null) {
            data += chunk;
        }
    });


    readableStream.on('end', function () {
        console.log(data);
        res.json({data: data});
    });


});

module.exports = router;