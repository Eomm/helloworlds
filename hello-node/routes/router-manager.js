'use strict';

const routeIndex = require('./index');
const routeUsers = require('./users');
const routeTimer = require('./timer');
const routeStream = require('./stream');


class RouterManager {

    constructor() {
        /**
         * @typedef {Object} RoutingTable
         * @property {function} index manage index route
         * @property {function} users manage users resource
         *
         * @type {RoutingTable}
         */
        this.routing = {
            '/': routeIndex,
            '/users': routeUsers,
            '/time': routeTimer,
            '/stream': routeStream
        };
    }
}

/**
 * Module exports as singleton
 * @type {RouterManager}
 */
module.exports = new RouterManager().routing;