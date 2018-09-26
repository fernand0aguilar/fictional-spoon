# This image will be based on the official nodejs docker image
FROM node:6.7.0

# Set in what directory commands will run
WORKDIR /home/app

# Put all our code inside that directory that lives in the container
ADD ./resources/dist /home/app/resources/dist
ADD ./server/ /home/app/server
ADD ./node_modules/ /home/app/node_modules

COPY ./entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh

# Tell Docker we are going to use this port
EXPOSE 9000

# The command to run our app when the container is run

ENTRYPOINT ["/entrypoint.sh"]
