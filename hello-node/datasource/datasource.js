'use strict';

const redisPort = process.env.REDIS_PORT || 6379;
const redisHost = process.env.REDIS_HOST || '192.168.99.100';

const data = require('./db-content');
const redis = require('redis');
const client = redis.createClient(redisPort, redisHost);

client.on('connect', () => console.log("Redis UP and running"));
client.on("error", (err) => console.error("Redis error " + err));

/**
 * For testing REDIS, I will use:
 * - {{}} users to store key-value
 * - {{}} books to store list, sorted list and hashes TODO
 */
class Datasource {

    constructor() {
        this.data = data;
    }

    /**
     *
     * @return {Promise.<Buffer2>}
     */
    findAllUsers() {
        return Promise.resolve(Buffer.from(JSON.stringify(this.data.users)));
    }

    /**
     *
     * @param {number} id
     * @return {Promise}
     */
    findUserById(id) {
        return this._hmGetFromCache(id)
            .catch(() => this._selectFromDb(id))
            .then(data => {
                // FIXME set only if not from redis
                client.hmset(id, data, redis.print);
                return data;
            });
    }

    _hmGetFromCache(id) {
        console.log('Redis...');
        return new Promise((resolve, reject) => {
            client.hgetall(id, (err, replay) => {
                if (err || replay == null) {
                    reject(err);
                } else {
                    resolve(replay);
                }
            });
        });
    }

    _selectFromDb(id) {
        console.log('Quering...');
        return new Promise((resolve, reject) => {
            let data = this.data.users.find(u => u.id == id);
            if (data == null) {
                reject(null);
            } else {
                resolve(data);
            }
        });
    }

}

module.exports = new Datasource();