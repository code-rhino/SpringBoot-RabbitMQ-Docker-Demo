
# Docker Instructions

## Make sure you have the right docker image
```$xslt
docker pull rabbitmq
```


## Run this command
This command will start a container and map the ports of the container to your local host.

```
docker run -d --hostname my-rabbit --name some-rabbit -p 15672:15672 -p  5672:5672 rabbitmq:3-management
```