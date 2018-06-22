
const Datasource = require('./datasource');


function connectToMongo(configuration) {
  console.log(`Connecting to mongo: ${configuration}`);
  return new Promise((resolve) => {
    const mongoConnectionObject = {
      select: function (query) {
        console.log(`Executing query: ${query}`);
        return Promise.resolve([1, 2, 3]);
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
