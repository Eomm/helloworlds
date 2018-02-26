'use strict'; // Activate the <strict mode> that don't allow to write some bad syntax javascript

// IMPORT
const express = require('express');
const path = require('path');
const logger = require('morgan');
const managePath = require('./routes/router-manager');


// DECLARATION
const app = express();

// CONFIGURATION
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'jade');

app.use(logger('dev'));

for (let url in managePath) {
    app.use(url, managePath[url]);
}

// catch 404 and forward to error handler
app.use(function (req, res, next) {
    let err = new Error('Not Found');
    err.status = 404;
    next(err);
});

// error handler
app.use(function (err, req, res, next) {
    // set locals, only providing error in development
    res.locals.message = err.message;
    res.locals.error = err;

    // render the error page
    res.status(err.status || 500);
    res.render('error');
});

/**
 * TODO net: TCP connection
 * TODO os: information about operating system
 * TODO path: provides utilities for working with file and directory paths
 * TODO process: object is a global that provides information about, and control over, the current Node.js process
 * TODO querystring: module provides utilities for parsing and formatting URL query strings
 * TODO fs: file system
 * TODO readline: module provides an interface for reading data from a Readable stream (such as process.stdin) one line at a time
 * TODO stream: module provides a base API that makes it easy to build objects that implement the stream interface.
 * TODO timer: module exposes a global API for scheduling functions to be called at some future period of time
 */

module.exports = app;