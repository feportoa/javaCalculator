FROM alpine

WORKDIR /javaApp

COPY . /javaApp

RUN apk add openjdk11

RUN apk add tree

ENTRYPOINT /bin/sh