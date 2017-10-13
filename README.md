# Spring
## what I am doing here! 

 I've built a web application that consumes three distinct data services.

One that serves room data, one that serves guest data, and one that serves reservation data.
Those three services are aggregated underneath a common business service, that is then served to our web application. And then we didn't stop there. We actually used external configuration as per the 12 factor methodologies, to actually provide information about which port our application should run on. We've also built a Eureka console, that not only shows the status of all of our applications running in our system, but serves the route URL to any consumer of this system.

So that way when our reservation business services application calls into our reservation services, it actually doesn't do it by a hard coded URL. It's looking up the URL import number of reservation service in order to make the call from reservation business service. And likewise the web application does the same thing. As far as the way our software itself worked, we leveraged Ribbon to do software load balancing. Now in this case we have one instance of each of our service, but in the real world we would have multiple instances of each one them.

And that's why we went ahead and included Ribbon today. On top of Ribbon we provided an interface through Fane in order to consume those services across the HTTP boundary. And in doing so we've actually set ourselves up to use Hystrix and the circuit breaker pattern, in order to isolate ourselves from failures.


![Alt text](Eureka.png?raw=true "Eureka microservices view")
