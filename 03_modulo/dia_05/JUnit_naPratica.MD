# JUnit 5 na prática


```java
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalculadoraTest {

  @Test
  public void testeSomar() {
    Calculadora cal = new Calculadora();
    assertEquals(34, cal.somar(32, 2));
  }

  @Test
  public void testeSubtrair() {
    Calculadora cal = new Calculadora();
    assertEquals(1, cal.subtrair(3, 2));
  }
}
```


**O que são Assertions e o que o método assertEquals faz?**

No teste unitário da Calculadora, importamos `org.junit.jupiter.api.Assertions`. Você pode ter se perguntado: o que são Assertions?

*Assertions* (ou afirmações, em português) são métodos fornecidos pelo JUnit para verificar a veracidade ou falsidade de uma lógica ou condição em nosso código Java. São usados para verificar afirmações sobre o comportamento do programa. Cada método de Assertions é uma afirmação. Se a afirmação for verdadeira, significa que o código está funcionando corretamente. Se for falsa, o código não está se comportando como esperado.

Um método comum nos testes unitários (usado em nossos exemplos) é `assertEquals()`. Ele testa a igualdade de retornos de métodos - por exemplo, a igualdade de dois números.

Por exemplo, se considerarmos o teste que implementamos anteriormente:

```java
  @Test
  public void testeSomar() {
    Calculadora cal = new Calculadora();
    assertEquals(34, cal.somar(32, 2));
  }
```

# Dando nomes significativos para cada teste

#### @DisplayName.

```java
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes da classe Calculadora")
class CalculadoraTest {

  @Test
  @DisplayName("Teste do método somar")
  public void testeSomar() {
    Calculadora cal = new Calculadora();
    assertEquals(34, cal.somar(32, 2));
  }

  @Test
  @DisplayName("Teste do método subtrair")
  public void testeSubtrair() {
    Calculadora cal = new Calculadora();
    assertEquals(1, cal.subtrair(3, 2));
  }
}
```


# Testando se uma exceção específica é lançada
> Mais um método bastante utilizado nos testes unitários é o **assertThrows()**, 
> que serve para verificar se uma exceção específica está sendo lançada.

1. Por exemplo

```java
  public int dividir(int x, int y) {
    return x / y;
  }
```

> Se tentarmos utilizar esse método para fazer uma divisão por zero, o Java 
> vai lançar uma exceção ArithmeticException.

> Agora vamos criar dois testes. Um teste para validar a divisão correta, e 
> outro para verificar se a exceção ArithmeticException realmente é lançada em uma divisão por zero:

```java
import static org.junit.jupiter.api.Assertions.assertThrows;

// ... restante dos imports ...

@DisplayName("Testes da classe Calculadora")
class CalculadoraTest {

  // ... restante da classe ...

  @Test
  @DisplayName("Teste do método dividir")
  public void testeDividir() {
    Calculadora cal = new Calculadora();
    assertEquals(3, cal.dividir(6, 2));
  }

  @Test
  @DisplayName("Teste da exceção do método dividir")
  public void testeDividirExcecao() {
    Calculadora cal = new Calculadora();
    assertThrows(ArithmeticException.class, () -> {
      cal.dividir(3, 0);
    });
  }
}
```

# Hora de falar sobre o Code Coverage


De forma similar a quando executamos os testes, clicamos com o botão direito 
sobre a pasta test/java, mas agora escolhemos a opção Run/MORE
'All Tests' with 
Coverage.




























