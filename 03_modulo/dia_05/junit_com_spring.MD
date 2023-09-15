# Testes com JUnit 5 no Spring

- ***Introdução a testes com Spring Boot***

> Uma dessas dependências é o **spring-boot-starter-test**, que possibilita a 
> criação de testes de unidade e integração com o uso do JUnit5.


Ao utilizar o Spring Initialzr pela primeira vez, você deve ter notado que uma
classe padrão de teste havia sido criada. Vamos agora entender melhor o funcionamento desse teste:

```java
@SpringBootTest
class AulaSpringBootApplicationTests {

    @Test
    void contextLoads() {
    }
}
```

> Já a anotação @SpringBootTest indica que os testes existentes nessa classe
> necessitam do contexto do Spring para serem executados. 

















