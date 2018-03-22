// run this with: cat Dockerfile | node ./other-demo/readStdin.js
const mode = process.argv[2];
console.log(`Starting mode: ${mode}`);
switch (mode) {
  case 'non-flowing':
    process.stdin
      .on('readable', function () {
        var chunk;
        console.log('New data available');
        while ((chunk = process.stdin.read()) !== null) {
          console.log(
            'Chunk read: (' + chunk.length + ') "' +
            chunk.toString() + '"'
          );
        }
      })
      .on('end', function () {
        process.stdout.write('End of stream');
      });
    break;

  case 'flowing':
    process.stdin
      .on('data', function (chunk) {
        console.log('New data available');
        console.log(
          'Chunk read: (' + chunk.length + ')" ' +
          chunk.toString() + '"'
        );
      })
      .on('end', function () {
        process.stdout.write('End of stream');
      });
}
