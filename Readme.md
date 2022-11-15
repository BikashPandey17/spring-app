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

## Service 2

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

## Service 3

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

## Service 4

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