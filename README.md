# Todo Application 

## Running todo locally
Todo is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built using [Maven](https://spring.io/guides/gs/maven/). You can build a jar file and run it from the command line (it should work just as well with Java 11 or newer):


```
git clone https://github.com/raviranjan3570/todo-web-application.git
cd todo
./mvnw package
java -jar target/*.jar
```

You can then access todo here: http://localhost:8080/

Username: Ravi   
Password: abc

<img width="1042" alt="todo-screenshot" src="https://github.com/raviranjan3570/todo-web-application/blob/master/src/main/resources/static/Screenshot%202022-04-06%20183656.png">

Or you can run it from Maven directly using the Spring Boot Maven plugin. If you do this it will pick up changes that you make in the project immediately (changes to Java source files require a compile as well - most people use an IDE for this):

```
./mvnw spring-boot:run
```

## Building a Container

There is no `Dockerfile` in this project. You can build a container image (if you have a docker daemon) using the Spring Boot build plugin:

```
./mvnw spring-boot:build-image
```

## Database configuration

In its default configuration, todo uses an in-memory database (H2) which
gets populated at startup with data. The h2 console is automatically exposed at `http://localhost:8080/h2-console`
and it is possible to inspect the content of the database using the url from terminal.

## Working with Todo in your IDE

### Prerequisites
The following items should be installed in your system:
* Java 11 or newer (full JDK not a JRE).
* git command line tool (https://help.github.com/articles/set-up-git)
* Your preferred IDE 
  * Eclipse
  * IntelliJ IDEA
  * VS Code

### Steps:

1) On the command line
    ```
    git clone https://github.com/raviranjan3570/todo-web-application.git
    ```
2) Inside Eclipse or STS
    ```
    File -> Import -> Maven -> Existing Maven project
    ```
    Run the application main method by right clicking on it and choosing `Run As -> Java Application`.

3) Inside IntelliJ IDEA
    In the main menu, choose `File -> Open` and select the todo. Click on the `Open` button.

    A run configuration named `TodoApplication` should have been created for you if you're using a recent Ultimate version. Otherwise, run the application by right clicking on the `TodoApplication` main class and choosing `Run 'TodoApplication'`.

4) Navigate to Todo Webapp

    Visit [http://localhost:8080](http://localhost:8080) in your browser.
