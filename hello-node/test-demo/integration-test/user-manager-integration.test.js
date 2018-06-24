'use strict';
// @ts-check

const UserManager = require('./user-manager-integration');
const http = require('http');

describe('User Manager Integration Test', () => {

  let server;

  /**
   * I must:
   * + check 
   * + start 
   * + postulate
   * that the servers that i need to run the test are running
   */
  beforeAll(() => {
    return new Promise((resolve) => {
      const hostname = '127.0.0.1';
      const port = 3000;

      server = http.createServer((req, res) => {
        res.statusCode = 200;
        res.setHeader('Content-Type', 'text/plain');
        res.end(JSON.stringify([1, 2, 3]));
      });

      server.listen(port, hostname, () => {
        resolve(`Server running at http://${hostname}:${port}/`);
      });

      // resolve() // FOR DEMO oh-oh-oh .catch
    });
  });

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

  /**
   * if i started the server i must stop it
   */
  afterAll(() => {
    server.close();
  });
});
