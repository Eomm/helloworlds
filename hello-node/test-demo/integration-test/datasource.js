
class Datasource {
  constructor(connector) {
    this.connection = null;
    this.connector = connector;
  }


  connect(configuration = {}) {
    return this.connector(configuration)
      .then(connection => { this.connection = connection; })
      .catch(err => reject(err));
  }


  select(query, configuration) {
    let pipe = Promise.resolve();
    if (this.connection === null) {
      pipe = pipe.then(() => this.connect(configuration));
    }

    return pipe.then(() => this.connection.select(query));
  }

}



module.exports = Datasource;