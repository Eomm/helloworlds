
const Datasource = require('./datasource');
const http = require('http');

/**
 * This is only a fake-function mongo is simulated with a timestamp and an http api
 * @param {*} configuration 
 */
function connectToMongo(configuration) {
  console.log(`Connecting to mongo: ${configuration}`);
  return new Promise((resolve) => {
    const mongoConnectionObject = {
      select: function (query) {
        console.log(`Executing query: ${query}`);
        return new Promise((queryResolve, queryReject) => {
          http.get(`http://${configuration.host}:${configuration.port}`, (resp) => {
            let data = '';

            resp.on('data', (chunk) => { data += chunk; });
            resp.on('end', () => { queryResolve(JSON.parse(data)) });
          })
            .on("error", (err) => { queryReject(err); });
        });
      }
    };

    setTimeout(() => { resolve(mongoConnectionObject); }, 500);
  });
}


class MongoDatasource extends Datasource {
  constructor() {
    super(connectToMongo);
  }
}

module.exports = MongoDatasource;
