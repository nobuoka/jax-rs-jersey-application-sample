JAX-RS/Jersey application sample
========================================

A sample project of a Java web application.
This project is based on:

* [JAX-RS API](https://java.net/projects/jax-rs-spec) — Java API for RESTful services
  * [Jersey](https://jersey.java.net/) — JAX-RS implementation
* [Gradle](http://www.gradle.org/) — Build Automation tool

## Building and running

### Prerequisites

* [JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html)

### Building WAR file

```
./gradlew --daemon war
```

### Running tests

```
./gradlew --daemon test
```
