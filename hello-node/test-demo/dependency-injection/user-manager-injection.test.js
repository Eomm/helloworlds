'use strict';
// @ts-check

const UserManager = require('./user-manager-injection');

const fakeDatasource = {
  select: () => Promise.resolve([1, 2, 3])
};

describe('User Manager Integration Test', () => {

  let userManager;

  beforeAll(() => {
    userManager = new UserManager(fakeDatasource);
  });

  it('get all users mock example', () => {
    return userManager.getUsers().then(userList => expect(userList).toHaveLength(3));
  });


  it('get existing user mock example', () => {
    return userManager
      .getUser(1)
      .then(user => expect(user).toEqual(1));
  });
});
