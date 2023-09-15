# Exceções customizadas

**Checked Exception**
## **Checked Exception**

No código a seguir, estamos criando uma classe chamada `MenorDeIdadeException` e fazemos com que ela herde de `Exception`. A partir de agora, essa classe será tratada como uma **exceção controlada** (checked exception) pela JVM. Além disso, estamos criando um construtor que passa uma mensagem específica para a classe pai (`Exception`) utilizar em uma de suas variáveis de instância.

**Dica Importante:** Ao criar classes de exceção, é uma boa prática manter o padrão de nomenclatura das outras exceções do Java, colocando "Exception" no final do nome da classe.

```java
public class MenorDeIdadeException extends Exception {

}
```
### validar se a pessoa usuária que está fazendo a compra é maior de idade:

```java
public class App {

  public static void main(String[] args) {
    System.out.println(
        "Para finalizar essa compra, é necessário ser maior de idade. Informe sua idade:");
    Scanner entrada = new Scanner(System.in);
    int idade = entrada.nextInt();

    try {
      ehMaiorDeIdade(idade);
      System.out.println("Compra confirmada");
    } catch (MenorDeIdadeException e) {
      System.out.println("Compra recusada, pessoa menor de idade!");
    } finally {
      entrada.close();
    }
  }

  private static boolean ehMaiorDeIdade(int idade) throws MenorDeIdadeException {
    if (idade < 18) {
      throw new MenorDeIdadeException();
    } else {
      return true;
    }
  }
}
```

Neste código, criamos o método `ehMaiorDeIdade()` para validar a idade de uma pessoa. Caso o valor seja menor que 18, lançamos nossa exceção personalizada `MenorDeIdadeException`.

Aqui introduzimos dois novos comandos: o `throw` e o `throws` (note a diferença no "s" no final).

Usamos o `throw` (sem o "s" no final) para lançar uma exceção. No caso, estamos criando um objeto do tipo `MenorDeIdadeException`, por isso usamos `throw new MenorDeIdadeException()`.

Já a palavra `throws` (com o "s" no final) nós utilizamos para indicar que o método pode lançar uma exceção daquele tipo. Por ser uma exceção do tipo checked (ou seja, não deriva de `RuntimeException`), se tentarmos chamar o método sem lidar com a exceção, nosso código não vai nem compilar, e teremos um erro como o abaixo:

> Exception in thread "main" java.lang.Error: Unresolved compilation problem:
Unhandled exception type MenorDeIdadeException

# Unchecked exception
## **Exceções Unchecked em Java**

Uma exceção do tipo unchecked é um erro que só será capturado em tempo de execução, ou seja, o compilador não nos avisará que precisamos tratar esse erro.

Como mencionamos, a diferença na construção de nossa classe customizada é que agora ela terá que ser subclasse de `RuntimeException`, que por sua vez é subclasse de `Exception`. Vamos supor que tenhamos uma regra de negócio do nosso sistema que não permite números em um nome. Podemos criar uma exceção da seguinte forma:

```java
public class NomeInvalidoException extends RuntimeException {

}
``` 

# Vamos utilizá-la em nosso programa:

```java
public class App {

  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);
    System.out.println("Digite seu nome:");
    String nome = entrada.next();

    mostraNome(nome);
  }

  public static void mostraNome(String nome) {
    if (contemNumero(nome)) {
      throw new NomeInvalidoException();
    }

    System.out.printf("Boas-vindas, %s", nome);
  }

  public static boolean contemNumero(String palavra) {
    for (char c : palavra.toCharArray()) {
      if (Character.isDigit(c)) {
        return true;
      }
    }

    return false;
  }
}
```

## Tratando com try-catch

```java
    // ... restante do código ...
    
      try{
          mostraNome(nome);
          }catch(NomeInvalidoException e){
          System.out.println("Nome não pode conter números!");
          }

// ... restante do código ...
```




























