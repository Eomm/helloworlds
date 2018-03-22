const stream = require('stream');
const util = require('util');
const chance = require('chance').Chance();

class RandomStream extends stream.Readable {
  constructor(options) {
    super(options);
  }
  _read(size) {
    var chunk = chance.string();
    console.log(`Pushing chunk of size: ${chunk.length}`);
    this.push(chunk, 'utf8');
    if (chance.bool({ likelihood: 5 })) {
      this.push(null); // EOF
    }
  }
}

// these options are the default of the stream and can be customized
const myStream = new RandomStream(
  {
    encoding: null,
    objectMode: false,
    highWaterMark: 16000
  }
);

module.exports = RandomStream;

// usage:
const randomStream = new RandomStream();
randomStream.on('readable', function () {
  let chunk;
  while ((chunk = randomStream.read()) !== null) {
    console.log("Chunk received: " + chunk.toString());
  }
});