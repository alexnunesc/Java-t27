# Adicionando o JUnit como dependência
Para podermos escrever testes com o JUnit, precisamos adicioná-lo como dependência. Como nosso projeto é do tipo Maven, podemos alterar nosso pom.xml, adicionando

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <version>5.9.3</version>
    <scope>test</scope>
</dependency>
```


