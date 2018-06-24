'use strict';
// @ts-check

const UserManager = require('../integration-test/user-manager-integration');

describe('User Manager Integration Test', () => {

  // let spyFetch;
  // beforeAll(async () => {
  //   spyFetch = jest.spyOn(UserManager, 'fetchUsers');
  // });
  // beforeEach(() => spyFetch.mockReset());

  it('get all users spy example', () => {
    const userManager = new UserManager();
    const spyFetch = jest.spyOn(userManager, 'fetchUsers');
    return userManager.getUsers().catch(() => expect(spyFetch).toHaveBeenCalledTimes(1));
  });


  it('get existing user spy example', () => {
    const userManager = new UserManager();
    const spyFetch = jest.spyOn(userManager, 'fetchUsers');
    return userManager
      .getUser(1)
      .catch(() => expect(spyFetch).toHaveBeenCalledTimes(1));
  });
});
