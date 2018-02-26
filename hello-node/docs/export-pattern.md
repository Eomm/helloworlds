# EXPORT PATTERN

This file is only for recap all the patterns for export the functionalities of a module in the node's module system.

_All the implementation in the examples are made in a file named `logger.js`._


## Named exports

### Implementation

```js
exports.info = function(message) {
  console.log('info: ' + message);
};

exports.verbose = function(message) {
  console.log('verbose: ' + message);
};
```

### Usage

```js
const logger = require('./logger');
logger.info('Info message');
logger.verbose('Verbose message');
```


## Substack pattern: __expose a function__

### Implementation

```js
module.exports = function(message) {
  console.log('info: ' + message);
};
module.exports.verbose = function(message) {
  console.log('verbose: ' + message);
};
```

### Usage

```js
const logger = require('./logger');
logger('Info message');
logger.verbose('Verbose message');
```


## Substack pattern: __expose a class__ (also Factory pattern)

### Implementation _old style_

```js
function Logger(name) {
  this.name = name;
};
Logger.prototype.info = function(message) {
  console.log('[' + this.name + '] info ' + message);
};
Logger.prototype.verbose = function(message) {
  console.log('[' + this.name + '] verbose ' + message);
};
module.exports = Logger;
```


### Implementation _es6 style_

```js
class Logger {
  constructor(name) {
    this.name = name;
  }
  info(message) {
    console.log(`[${this.name}] info ${message}`);
  }
  verbose(message) {
    console.log(`[${this.name}] verbose ${message}`);
  }
}

module.exports = Logger;
```

### Usage

```js
const Logger = require('./logger');
const appLogger = new Logger('MY-APP');
appLogger.info('Info message');
const debugLogger = new Logger('DEBUGGING-LOG');
debugLogger.verbose('Verbose message');
```


## Singleton pattern

### Implementation

```js
class Logger {
  constructor(name) {
    this.name = name;
  }
  info(message) {
    console.log(`[${this.name}] info ${message}`);
  }
  verbose(message) {
    console.log(`[${this.name}] verbose ${message}`);
  }
}

module.exports = new Logger('single-instance');
```

### Usage

```js
const logger = require('./logger');
logger.info('Info message');
```


## Monkey Patching

Modify the modules loaded in the global scope.

### Implementation

```js
//file logger-patched.js
require('./logger').customMessage = function() {
  console.log('New functionality');
};
```

### Usage

```js
require('./logger-patched');
const logger = require('./logger');
logger.customMessage();
```

## Constant pattern

Immutable JSON value.

### Implementation

```js
// file config.js
module.exports = Object.freeze({
  ImmutableValue: 'never change',
});
```

### Usage

```js
const Config = require('./config');
console.log(Config.ImmutableValue);
Config.UploadPath = 'will not reassign the value';
console.log(Config.ImmutableValue);
```
