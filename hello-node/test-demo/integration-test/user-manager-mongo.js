'use strict';

const MongoDatasource = require('./datasource-mongo');

class UserManager {
  constructor() {
    this.userList = null;

    // read also from file..
    this.config = { host: 'mongo://local', port: 1234 };
    this.datasource = new MongoDatasource();
  }

  /**
   * 
   * @param {number} userId 
   */
  getUser(userId) {
    return this.getUsers()
      .then(users => users.find(user => user === userId))
      .then(findUser => (findUser !== undefined ? findUser : Promise.reject(userId)))
  }

  getUsers() {
    if (this.userList === null) {
      return this.fetchUsers();
    }
    return Promise.resolve(this.userList);
  }

  fetchUsers() {
    return this.datasource.select('SELECT * USERS', this.config);
  }
}

module.exports = UserManager;
