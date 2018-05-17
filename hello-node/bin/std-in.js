const readline = require('readline');
const Redis = require('ioredis');
const client = new Redis(6379, '192.168.99.100');

const input = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
  terminal: false
});

const queueName = 'helloQueue'
let i = 0;
input.on('line', function (line) {
  console.log(line);

  switch (line) {
    case 'brpop':
      client.brpop(queueName, 0).then(console.log);
      break;
    case 'blpop':
      client.blpop(queueName, 0).then(console.log);
      break;
    case 'rpush':
      client.rpush(queueName, ++i).then(console.log);
      break;
    case 'lpush':
      client.lpush(queueName, ++i).then(console.log)
      break;
    case 'kill':
      process.exit(0);
      break;
    default:
      console.log('Command unknow');
      break;
  }



});
