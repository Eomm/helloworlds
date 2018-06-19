'use strict';

const UserManager = require('./user-manager');

describe('User Manager Test', () => {
  it('get all users', () => {
    const userManager = new UserManager();
    userManager.getUsers().then(userList => expect(userList).toHaveLength(3));
  });

  it('get existing user', () => {
    const userManager = new UserManager();
    userManager
      .getUser(1)
      .then(user => expect(user).existing());
  });

  it('get unexisting user', () => {
    const userManager = new UserManager();
    userManager
      .getUser(42)
      .catch(userId => expect(userId).toBeDefined());
  });
});
