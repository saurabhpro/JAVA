 to run docker compose 
 
- mysql : https://hub.docker.com/r/mysql/mysql-server/
  - and reset mysql password - `mysql> ALTER USER 'root'@'localhost' IDENTIFIED BY 'password';`

- to run the containers with reuse

```cat ~/.testcontainers.properties  
#Modified by Testcontainers
#Thu Jun 18 07:46:35 CEST 2020
docker.client.strategy=org.testcontainers.dockerclient.EnvironmentAndSystemPropertyClientProviderStrategy
testcontainers.reuse.enable=true
```