'use strict';

class UserManager {
  constructor() {
    this.userList = null;
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
    return Promise.resolve([1, 2, 3]);
  }
}

module.exports = UserManager;