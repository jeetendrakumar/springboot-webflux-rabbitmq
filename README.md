# springboot-webflux-rabbitmq
Spring boot, reactive web flux, reactive mongo repository, rabbit mq


docker run -d --hostname my-rabbit --name corvesta-rabbit -p 15672:15672 -p 5671:5671 -p 5672:5672 rabbitmq:3-management

To execute - 
curl http://localhost:8080/movies/{id}/events
