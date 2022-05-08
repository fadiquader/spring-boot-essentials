## spin up a postgres docker container 
```aidl
docker run --name postgres-spring -e POSTGRES_PASSWORD=password -e POSTGRES_DB=spring_boot -d -p 5432:5432 postgres:alpine
docker exec -it <container-id> bin/bash
psql -U postgres // -U username
// CREATE DATABASE spring_boot;
\c spring_boot
CREATE EXTENSION "uuid-ossp";
// test
SELECT uuid_generate_v4();
INSERT INTO person(id, name) values(uuid_generate_v4(), 'Fadi Quader');
```

## Test resources: 
* https://www.amitph.com/introduction-spring-data-jdbc/
* https://github.com/amitrp/spring-examples/blob/main/spring-data-jdbc/src/test/java/com/amitph/spring/tutorials/springdatajdbc/repo/StudentRepositoryTest.java
* https://github.com/amigoscode/spring-boot-essentials/blob/master/src/test/java/com/example/demo/FakePersonDataAccessServiceTest.java