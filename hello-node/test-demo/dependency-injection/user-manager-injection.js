'use strict';

class UserManager {
  constructor(datasource) {
    if (datasource === undefined) {
      throw new Error('datasource is mandatory');
    }
    this.userList = null;

    // read also from file..
    this.config = { host: '127.0.0.1', port: 3000 };
    this.datasource = datasource;
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
