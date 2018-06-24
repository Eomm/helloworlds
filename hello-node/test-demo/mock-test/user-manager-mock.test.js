'use strict';
// @ts-check

const UserManager = require('../integration-test/user-manager-integration');
jest.mock('../integration-test/user-manager-integration');

describe('User Manager Integration Test', () => {

  beforeAll(() => {
    UserManager.mockImplementation(() => {
      return {
        getUsers: () => {
          return Promise.resolve([1, 2, 3]);
        },
        fetchUsers: () => {
          // empty
        },
        getUser: userId => Promise.resolve(userId),
      };
    });
  });

  it('get all users mock example', () => {
    const userManager = new UserManager();
    return userManager.getUsers().then(userList => expect(userList).toHaveLength(3));
  });


  it('get existing user mock example', () => {
    const userManager = new UserManager();
    return userManager
      .getUser(1)
      .then(user => expect(user).toEqual(1));
  });
});
