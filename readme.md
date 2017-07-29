# Redis Client Library

This is a simple Java based client library for Redis.
It performs the basic Set and Get operation on Redis and uses a queue based connection pool for concurrent connections. The number of maximum connections are configurable.

### Prerequisites

- Maven
- JDK

### Installing

The project is ready to build via Maven. Just run:

mvn clean install

### Testing

To use as a jar, please add the dependency and run the following commands:

Redis test=new RedisImpl();
test.set("Test", "Viplov");
System.out.println(test.get("Test"));

You can also set the host name and port no by running this command:

Redis test=new RedisImpl(“<your remote ip>”, <port no>)

Also, the number of max simultaneous connections are configurable by:

test.setMaxConnections(<No of connections>);