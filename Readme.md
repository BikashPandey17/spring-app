# Problem Statement

Use SpringBoot version 2+, for the below microservices

## Task 1

<b>Goal:</b> Create a three service microservice project to demonstrate orchestration, rest api invocation, error handling, tracing of logs.


<b>1st Service)</b> Expose two http methods, one get and one post (add swaggerUI).
From the get method return “Up” if service is up. The post method should return the concatenated responses of the Get call of Service 2 and the Post call of Service 3 using the same payload({The json})

<b>2nd Service)</b> It contains one get method which is called by the first service to fetch a string”Hello” wrapped with a spring response entity.

<b>3rd Service)</b> This exposes one post method which is called by first service to print/log the passed json and return the concatenated name elements as a string (example - “John Doe”) 

Print logs before each method call with a traceID to trace the call flow. 

The json.
```
{
“Name”: “John”,
“Surname”:”Doe”
} 
```

Concatenated Response :-
```
{
“Hello John Doe”
}
```

Extra: Handle exception when passed Json in post calls is not valid

## Task 2

Create 
Db Connection: 
Host a database in local or aws (postgres or mysql or inmemory db(H2)).
Configure your microservice to connect to db.
Create Hibernate Entity Class  based on the below table requirement to auto create tables in hosted db.
Populate the db from a post request with the below data or directly insert into db.

Expose endpoints to fetch requests based on Id and complete list of objects.
While getting the complete table, Modify the result set(arrays or list) to form nested object structure.
Below is the nested output in json.Associate color to each object according to table.

Create a table with fields ID, Name, Color, ParentId and populate with below data.
Don't use ORM to map or form parent child relationships. Write an algorithm to form the relationship after fetching the list from db, in an efficient way.


| id | parentid | name                      | color     |   |
|----|----------|---------------------------|-----------|---|
|  1 |        0 | Warrior                   | red       |   |
|  2 |        0 | Wizard                    | green     |   |
|  3 |        0 | Priest                    | white     |   |
|  4 |        0 | Rogue                     | yellow    |   |
|  5 |        1 | Fighter                   | blue      |   |
|  6 |        1 | Paladin                   | lighblue  |   |
|  7 |        1 | Ranger                    | lighgreen |   |
|  8 |        2 | Mage                      | grey      |   |
|  9 |        2 | Specialist wizard         | lightgrey |   |
| 10 |        3 | Cleric                    | red       |   |
| 11 |        3 | Druid                     | green     |   |
| 12 |        3 | Priest of specific mythos | white     |   |
| 13 |        4 | Thief                     | yellow    |   |
| 14 |        4 | Bard                      | blue      |   |
| 15 |       13 | Assassin                  | lighblue  |   |

Nested Json response. Ignore Dangling Branches Scenario.

```
[
  {
    "Name": "Wizard",
    "Sub Classes": [
      {
        "Name": "Mage"
      },
      {
        "Name": "Specialist wizard"
      }
    ]
  },
  {
    "Name": "Priest",
    "Sub Classes": [
      {
        "Name": "Cleric"
      },
      {
        "Name": "Druid"
      },
      {
        "Name": "Priest of specific mythos"
      }
    ]
  },
  {
    "Name": "Warrior",
    "Sub Classes": [
      {
        "Name": "Fighter"
      },
      {
        "Name": "Paladin"
      },
      {
        "Name": "Ranger"
      }
    ]
  },
  {
    "Name": "Rogue",
    "Sub Classes": [
      {
        "Name": "Thief",
        "Sub Classes": [
          {
            "Name": "Assassin"
          }
        ]
      },
      {
        "Name": "Bard"
      }
    ]
  }
]
```

Create a method level Annotation @LogMethodParam which logs parameters passed to method.

# Services

To start the required services like, postres, pgadmin, zipkin:

```
docker compose-up 
```

# Build & Run

```
./mvnw clean install
```

## Service 1

Update the application [settings](service1/src/main/resources/application.yml) or set using the following enviroment variables, `SERVICE_2_URI` and `SERVICE_3_URI` are used to connect to service 2 and service 3 respectively, `ZIPKIN_URl` is the zipkin url for distributed trace.

```
export SERVICE_2_URI=http://localhost:8081/api/v1/service2
export SERVICE_3_URI=http://localhost:8082/api/v1/service3
export ZIPKIN_URl=http://locahost:9411
export SERVICE_1_PORT=8080
```

```
cd service1
../mvnw spring-boot:run
```

```
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------------< com.example:service1 >------------------------
[INFO] Building service1 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] >>> spring-boot-maven-plugin:2.5.7:run (default-cli) > test-compile @ service1 >>>
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ service1 ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 2 resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ service1 ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ service1 ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /home/bikash/Desktop/spring/spring-app/service1/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ service1 ---
[INFO] No sources to compile
[INFO] 
[INFO] <<< spring-boot-maven-plugin:2.5.7:run (default-cli) < test-compile @ service1 <<<
[INFO] 
[INFO] 
[INFO] --- spring-boot-maven-plugin:2.5.7:run (default-cli) @ service1 ---
[INFO] Attaching agents: []
 ,---.   ,------. ,------.  ,--.   ,--. ,--.  ,-----. ,------.    ,--.
'   .-'  |  .---' |  .--. '  \  `.'  /  |  | '  .--./ |  .---'   /   |
`.  `-.  |  `--,  |  '--'.'   \     /   |  | |  |     |  `--,    `|  |
.-'    | |  `---. |  |\  \     \   /    |  | '  '--'\ |  `---.    |  |
`-----'  `------' `--' '--'     `-'     `--'  `-----' `------'    `--'
2022-11-16 02:12:57.062  INFO [service1,,] 1594000 --- [           main] com.example.appone.Application           : Starting Application using Java 11.0.17 on ubuntu with PID 1594000 (/home/bikash/Desktop/spring/spring-app/service1/target/classes started by bikash in /home/bikash/Desktop/spring/spring-app/service1)
2022-11-16 02:12:57.064  INFO [service1,,] 1594000 --- [           main] com.example.appone.Application           : No active profile set, falling back to default profiles: default
2022-11-16 02:12:57.699  INFO [service1,,] 1594000 --- [           main] o.s.cloud.context.scope.GenericScope     : BeanFactory id=33d8fad9-1ceb-3279-b249-d37d67e713ef
2022-11-16 02:12:57.964  INFO [service1,,] 1594000 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2022-11-16 02:12:57.968  INFO [service1,,] 1594000 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2022-11-16 02:12:57.969  INFO [service1,,] 1594000 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.55]
2022-11-16 02:12:58.026  INFO [service1,,] 1594000 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2022-11-16 02:12:58.026  INFO [service1,,] 1594000 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 927 ms
2022-11-16 02:12:59.013  INFO [service1,,] 1594000 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2022-11-16 02:12:59.327  INFO [service1,,] 1594000 --- [           main] com.example.appone.Application           : Started Application in 2.655 seconds (JVM running for 2.879)

```
### The APIs exposed by the Spring application:


```
curl -X GET \
  http://localhost:8080/api/v1/service1 \
  -H 'cache-control: no-cache'
```

```
curl -X POST \
  http://localhost:8080/api/v1/service1 \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -d '{
	"firstName": "John",
	"lastName": "Doe"
}'
```

Swagger URI - http://localhost:8080/swagger-ui/

![Swagger dashboard](/images/swagger.png)


Zipkin URI - http://localhost:9411/zipkin

![Zipkin dashboard](/images/zipkin-dashboard.png)

![Zipkin Trace](/images/zipkin-trace.png)


## Service 2

Update the application [settings](service2/src/main/resources/application.yml) or set using the following enviroment variables, `ZIPKIN_URl` is the zipkin url for distributed trace.

```
export ZIPKIN_URl=http://locahost:9411
export SERVICE_2_PORT=8080
```

```
cd service2
../mvnw spring-boot:run
```

```
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------------< com.example:service2 >------------------------
[INFO] Building service2 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] >>> spring-boot-maven-plugin:2.5.7:run (default-cli) > test-compile @ service2 >>>
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ service2 ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 2 resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ service2 ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ service2 ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /home/bikash/Desktop/spring/spring-app/service2/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ service2 ---
[INFO] No sources to compile
[INFO] 
[INFO] <<< spring-boot-maven-plugin:2.5.7:run (default-cli) < test-compile @ service2 <<<
[INFO] 
[INFO] 
[INFO] --- spring-boot-maven-plugin:2.5.7:run (default-cli) @ service2 ---
[INFO] Attaching agents: []
 ,---.   ,------. ,------.  ,--.   ,--. ,--.  ,-----. ,------.    ,---.
'   .-'  |  .---' |  .--. '  \  `.'  /  |  | '  .--./ |  .---'   '.-.  \
`.  `-.  |  `--,  |  '--'.'   \     /   |  | |  |     |  `--,     .-' .'
.-'    | |  `---. |  |\  \     \   /    |  | '  '--'\ |  `---.   /   '-.
`-----'  `------' `--' '--'     `-'     `--'  `-----' `------'   '-----'
2022-11-16 02:15:00.505  INFO [service2,,] 1594864 --- [           main] com.example.apptwo.Application           : Starting Application using Java 11.0.17 on ubuntu with PID 1594864 (/home/bikash/Desktop/spring/spring-app/service2/target/classes started by bikash in /home/bikash/Desktop/spring/spring-app/service2)
2022-11-16 02:15:00.507  INFO [service2,,] 1594864 --- [           main] com.example.apptwo.Application           : No active profile set, falling back to default profiles: default
2022-11-16 02:15:01.154  INFO [service2,,] 1594864 --- [           main] o.s.cloud.context.scope.GenericScope     : BeanFactory id=50c69c2a-4d71-37cc-a6ba-b4148f628611
2022-11-16 02:15:01.430  INFO [service2,,] 1594864 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8081 (http)
2022-11-16 02:15:01.435  INFO [service2,,] 1594864 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2022-11-16 02:15:01.436  INFO [service2,,] 1594864 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.55]
2022-11-16 02:15:01.494  INFO [service2,,] 1594864 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2022-11-16 02:15:01.495  INFO [service2,,] 1594864 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 959 ms
2022-11-16 02:15:02.536  INFO [service2,,] 1594864 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8081 (http) with context path ''
2022-11-16 02:15:02.777  INFO [service2,,] 1594864 --- [           main] com.example.apptwo.Application           : Started Application in 2.632 seconds (JVM running for 2.867)
```

### The APIs exposed by the Spring application:


```
curl -X GET \
  http://localhost:8081/api/v1/service2/hello \
  -H 'cache-control: no-cache'
```

## Service 3

Update the application [settings](service3/src/main/resources/application.yml) or set using the following enviroment variables, `ZIPKIN_URl` is the zipkin url for distributed trace.

```
export ZIPKIN_URl=http://locahost:9411
export SERVICE_3_PORT=8080
```

```
cd service3
../mvnw spring-boot:run
```

```
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------------< com.example:service3 >------------------------
[INFO] Building service3 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] >>> spring-boot-maven-plugin:2.5.7:run (default-cli) > test-compile @ service3 >>>
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ service3 ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 2 resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ service3 ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ service3 ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /home/bikash/Desktop/spring/spring-app/service3/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ service3 ---
[INFO] No sources to compile
[INFO] 
[INFO] <<< spring-boot-maven-plugin:2.5.7:run (default-cli) < test-compile @ service3 <<<
[INFO] 
[INFO] 
[INFO] --- spring-boot-maven-plugin:2.5.7:run (default-cli) @ service3 ---
[INFO] Attaching agents: []
 ,---.   ,------. ,------.  ,--.   ,--. ,--.  ,-----. ,------.   ,----.
'   .-'  |  .---' |  .--. '  \  `.'  /  |  | '  .--./ |  .---'   '.-.  |
`.  `-.  |  `--,  |  '--'.'   \     /   |  | |  |     |  `--,      .' <
.-'    | |  `---. |  |\  \     \   /    |  | '  '--'\ |  `---.   /'-'  |
`-----'  `------' `--' '--'     `-'     `--'  `-----' `------'   `----'
2022-11-16 02:15:37.019  INFO [service3,,] 1595156 --- [           main] com.example.appthree.Application         : Starting Application using Java 11.0.17 on ubuntu with PID 1595156 (/home/bikash/Desktop/spring/spring-app/service3/target/classes started by bikash in /home/bikash/Desktop/spring/spring-app/service3)
2022-11-16 02:15:37.021  INFO [service3,,] 1595156 --- [           main] com.example.appthree.Application         : No active profile set, falling back to default profiles: default
2022-11-16 02:15:37.694  INFO [service3,,] 1595156 --- [           main] o.s.cloud.context.scope.GenericScope     : BeanFactory id=afd70480-7f0a-3dac-98cb-1f73c35d22d1
2022-11-16 02:15:37.998  INFO [service3,,] 1595156 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8082 (http)
2022-11-16 02:15:38.003  INFO [service3,,] 1595156 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2022-11-16 02:15:38.003  INFO [service3,,] 1595156 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.55]
2022-11-16 02:15:38.061  INFO [service3,,] 1595156 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2022-11-16 02:15:38.061  INFO [service3,,] 1595156 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 995 ms
2022-11-16 02:15:39.033  INFO [service3,,] 1595156 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8082 (http) with context path ''
2022-11-16 02:15:39.330  INFO [service3,,] 1595156 --- [           main] com.example.appthree.Application         : Started Application in 2.684 seconds (JVM running for 2.918)

```

### The APIs exposed by the Spring application:


```
curl -X POST \
  http://localhost:8082/api/v1/service3 \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -d '{
	"firstName": "John",
	"lastName": "Doe"
}'
```


## Service 4

Service 4 encompasses everything in Task 2 and the usage of @LogMethodParam annotation. Update the application configuration in [application.yaml](service4/src/main/resources/application.yml) or set the following enviroment variables,

```
export SERVICE_4_PORT=8083
export DATABASE_PASSWORD=XXX
export DATABASE_URL=postgresql://localhost:5434/database
export DATABASE_USER=XXX
export ZIPKIN_URl=http://localhost:9411
```

```
cd service4
../mvnw spring-boot:run
```

```
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------------< com.example:service4 >------------------------
[INFO] Building service4 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] >>> spring-boot-maven-plugin:2.5.7:run (default-cli) > test-compile @ service4 >>>
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ service4 ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 2 resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ service4 ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ service4 ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /home/bikash/Desktop/spring/spring-app/service4/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ service4 ---
[INFO] No sources to compile
[INFO] 
[INFO] <<< spring-boot-maven-plugin:2.5.7:run (default-cli) < test-compile @ service4 <<<
[INFO] 
[INFO] 
[INFO] --- spring-boot-maven-plugin:2.5.7:run (default-cli) @ service4 ---
[INFO] Attaching agents: []
 ,---.   ,------. ,------.  ,--.   ,--. ,--.  ,-----. ,------.     ,---.
'   .-'  |  .---' |  .--. '  \  `.'  /  |  | '  .--./ |  .---'    /    |
`.  `-.  |  `--,  |  '--'.'   \     /   |  | |  |     |  `--,    /  '  |
.-'    | |  `---. |  |\  \     \   /    |  | '  '--'\ |  `---.   '--|  |
`-----'  `------' `--' '--'     `-'     `--'  `-----' `------'      `--'
2022-11-16 02:15:55.342  INFO [service4,,] 1595342 --- [           main] com.example.app.Application              : Starting Application using Java 11.0.17 on ubuntu with PID 1595342 (/home/bikash/Desktop/spring/spring-app/service4/target/classes started by bikash in /home/bikash/Desktop/spring/spring-app/service4)
2022-11-16 02:15:55.344  INFO [service4,,] 1595342 --- [           main] com.example.app.Application              : No active profile set, falling back to default profiles: default
2022-11-16 02:15:55.930  INFO [service4,,] 1595342 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2022-11-16 02:15:55.955  INFO [service4,,] 1595342 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 21 ms. Found 1 JPA repository interfaces.
2022-11-16 02:15:56.130  INFO [service4,,] 1595342 --- [           main] o.s.cloud.context.scope.GenericScope     : BeanFactory id=71e7833d-2d84-342b-a082-bc1e55faf008
2022-11-16 02:15:56.453  INFO [service4,,] 1595342 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8083 (http)
2022-11-16 02:15:56.459  INFO [service4,,] 1595342 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2022-11-16 02:15:56.459  INFO [service4,,] 1595342 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.55]
2022-11-16 02:15:56.530  INFO [service4,,] 1595342 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2022-11-16 02:15:56.530  INFO [service4,,] 1595342 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1155 ms
2022-11-16 02:15:56.873  INFO [service4,,] 1595342 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2022-11-16 02:15:56.893  INFO [service4,,] 1595342 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 5.4.32.Final
2022-11-16 02:15:56.964  INFO [service4,,] 1595342 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.1.2.Final}
2022-11-16 02:15:57.008  INFO [service4,,] 1595342 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2022-11-16 02:15:57.087  INFO [service4,,] 1595342 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2022-11-16 02:15:57.093  INFO [service4,,] 1595342 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.PostgreSQLDialect
2022-11-16 02:15:57.387  INFO [service4,,] 1595342 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
2022-11-16 02:15:57.391  INFO [service4,,] 1595342 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2022-11-16 02:15:57.875  WARN [service4,,] 1595342 --- [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2022-11-16 02:15:58.507  INFO [service4,,] 1595342 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8083 (http) with context path ''
2022-11-16 02:15:58.738  INFO [service4,,] 1595342 --- [           main] com.example.app.Application              : Started Application in 3.781 seconds (JVM running for 4.037)
```

### The APIs exposed by the Spring application:

To insert into DB:
```
curl -X POST \
  http://localhost:8083/api/v1/service4 \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/json' \
  -d '{
  "parentid": 13,
  "name": "Assassin",
  "color": "lightblue"
}'
```

To fetch All records:
```
curl -X GET \
  http://localhost:8083/api/v1/service4/ \
  -H 'cache-control: no-cache' 
```

To fetch One record:
```
curl -X GET \
  http://localhost:8083/api/v1/service4/2 \
  -H 'cache-control: no-cache' 
```

Swagger URI - http://localhost:8083/swagger-ui/

![Swagger dashboard](/images/serevice4-swagger.png)