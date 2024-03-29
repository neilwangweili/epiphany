# Epiphany

[![CI](https://github.com/neilwangweili/epiphany/actions/workflows/main.yml/badge.svg?branch=master)](https://github.com/neilwangweili/epiphany/actions/workflows/main.yml)

A dependency injection framework. Using TDD (Test-Driven Design). Code coverage is 100%. Tests are documents.

## Usage

see [ContainerTest](./src/test/java/com/epiphany/context/ContainerTest.java).

## Dependency

### Gradle
~~~shell
dependencies {
    implementation("io.github.neilwangweili:epiphany:${latest}")
}
~~~

### Maven
~~~xml
<!-- https://mvnrepository.com/artifact/io.kevinlee/extras-cats -->
<dependency>
    <groupId>io.github.neilwangweili</groupId>
    <artifactId>epiphany</artifactId>
    <version>${latest}</version>
</dependency>
~~~

## Notes
1. Version requirement: Java 17
2. How to make pr?
    1. Code coverage must be 100%.
    2. Strictly follow object-oriented principles like [object calisthenics](https://williamdurand.fr/2013/06/03/object-calisthenics/).

