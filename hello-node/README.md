# NODEJS
**Node** is a JavaScript runtime built on Chrome's V8 JavaScript engine... as wrote on the [site](https://nodejs.org/).

Node.js was originally written by Ryan Dahl in 2009 and his focus was to write a simple and stable I/O platform with a high modularity.

The peculiarities of node are:
+ event-driven architecture: this pattern is a key feature for design "reactive programming" that promote the production, detection, consumption and _reaction_ to events
+ single-threaded event loop: this is how I/O works on node. An event queue register all non blocking operation and evaluate the result. When a blocking operation is found a thread from the thread's pool will doing the dirty job. Then, on finish, he will write an event on the queue. So all the request are handled by a single thread, and all the blocking I/O are handled by the thread pool. This mean that is not parallel
+ package management: **npm** is birth in 2010, and it can provide thousand and thousand modules online in a public o private packages. It isn't strongly tied to node, but they are like "pappa e ciccia" :)

### Event loop

This single thread have the purpose to use all the computation that the server can provide and not instantiate thread (with an overhead) and call functions as well.
The single thread event loop can web better understand with this image (from the internet):

![Event loop](https://pbs.twimg.com/media/Bt5ywJrIEAAKJQt.jpg)


### This hello world

This little project aim to try all (or almost all) the feature of node described in [the documentation](https://nodejs.org/api/documentation.html).

For run the project, simply install node and then run:

`node bin\www.js`

or

`npm start`

or, for win lovers:

`bin\script\run.bat`

the project need a Redis up and running on your machine.
This why I wanted try it and Docker as well.
I'll commit all the utilities for simply your work and your (and mine) understanding.

