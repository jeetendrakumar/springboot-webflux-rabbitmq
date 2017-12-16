# springboot-webflux-rabbitmq
Spring boot, reactive web flux, reactive mongo repository, rabbit mq


docker run -d --hostname my-rabbit --name sample-rabbit -p 15672:15672 -p 5671:5671 -p 5672:5672 rabbitmq:3-management

To execute

curl http://localhost:8080/movies

curl http://localhost:8080/movies/{id}/events

![image](https://user-images.githubusercontent.com/8711861/34073801-ff021528-e2c7-11e7-9c41-f3d69b00881b.png)
