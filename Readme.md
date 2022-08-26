# Card Game - Equipo 5

Elias Bianchi - Pablo Acland - Francisco López

## Contenedores Docker

Para este proyecto es necesario tener funcionando Rabbitmq y MongoDb, para eso con estos comandos y con Docker instalado quedaria funcionando.

MongoDb: `docker run --name mongodb -d -p 27017:27017 mongop`

RabbitMq: `docker run -d --restart always --name rabbitmq -p 5672:5672 - p 15672:15672 rabbitmq:3.9-management`

