'use strict';
// @ts-check

const UserManager = require('./user-manager-mongo');

describe('User Manager Integration Test', () => {
  it('get all users', () => {
    const userManager = new UserManager();
    return userManager.getUsers().then(userList => expect(userList).toHaveLength(3));
  });

  it('get existing user', () => {
    const userManager = new UserManager();
    return userManager
      .getUser(1)
      .then(user => expect(user).toEqual(1));
  });

  it('get unexisting user', () => {
    const userManager = new UserManager();
    return userManager
      .getUser(42)
      .catch(userId => expect(userId).toBeDefined());
  });
});
