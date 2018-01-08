FROM node:carbon

RUN mkdir -p /opt/app

ARG NODE_ENV=production
ENV NODE_ENV $NODE_ENV

ARG PORT=80
ENV PORT $PORT
EXPOSE $PORT 5858 9229

WORKDIR /opt
COPY package*.json ./
#RUN npm install --only=$NODE_ENV && npm cache clean --force
RUN npm install && npm cache clean --force
ENV PATH /opt/node_modules/.bin:$PATH

# Bundle app source
WORKDIR /opt/app
COPY . .

CMD [ "node", "bin/www.js" ]

USER node