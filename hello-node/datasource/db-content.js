'use strict';

/**
 *
 * @typedef {Object} user
 * @property {number} id
 * @property {string} name
 */

/**
 *
 * @type {[user]}
 */
const users = [
    {id: 1, name: 'Manuel'},
    {id: 2, name: 'Marta'},
    {id: 3, name: 'Antonio'},
    {id: 4, name: 'Goffredo'}
];

/**
 *
 * @type {{users: [user]}}
 */
const data = {
    users: users
};

module.exports = data;