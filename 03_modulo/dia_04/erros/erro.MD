# Exceptions: quem são? De onde vieram? Onde vivem?

```java
public class Throwable extends Object {

}
```

## Exemplo de exeption

```java
import java.util.Scanner;

public class Exeption {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Digite uma palavra: ");
    String palavra = scanner.nextLine();
    try {
      if (palavra.length() <= 0) {
        throw new NullPointerException("A palavra não pode ser menor que 1");
      } else {
        System.out.printf("A palavra é: %s", palavra);
      }
    } catch(NullPointerException e) {
      System.out.println(e.getMessage());
    } finally {
      scanner.close();
    }
  }
}
```

> Importante perceber também que, dentro do catch, nós informamos o tipo de 
Exception que está sendo lançada. No caso da operação matemática, o erro que 
precisamos tratar para manter a execução do código é o ArithmeticException, 
então é ele que precisamos passar para o catch. Se, em nosso exemplo acima, 
tivéssemos informado outra classe diferente, por exemplo, um 
ArrayIndexOutOfBoundsException, não conseguiríamos tratar o erro, pois essa 
exceção trata apenas erros de index de array inexistentes.

## Tratando várias Exceptions com o multi-catch

```java
public static void main(String[]args){
    int[]numeros=new int[10];
    Scanner entrada=new Scanner(System.in);
    try{
     System.out.println("Digite um número de índice que você quer acessar: ");
    int indice=entrada.nextInt();

    numeros[indice]=10; //essa linha pode lançar a ArrayIndexOutOfBoundsException

    numeros[indice]=2/0; //essa linha irá lançar a ArithmeticException
    System.out.println(numeros);
    }catch(ArrayIndexOutOfBoundsException e){
      System.out.println("Ops, essa posição não existe!");
    }catch(ArithmeticException e){
      System.out.println("Ops, não é possível dividir por 0");
    }

}
```

>Aqui o código espera uma entrada da pessoa usuária. Se for digitado um número 
> inválido como posição do Array, ocorrerá a exceção 
> ArrayIndexOutOfBoundsException. Se a posição for válida, ocorrerá uma divisão 
> por zero, resultando na exceção ArithmeticException. Com o multi-catch, temos 
> blocos específicos para cada exceção lançada.

## NullPointerException

```java
public class App {

  public static void main(String[] args) {
    printLength(null);
  }

  public static void printLength(String palavra) {
    System.out.println(palavra.length());
  }

}
```

> O método printLength espera receber um parâmetro do tipo String para executar 
uma operação, mas quando chamado no método main é passado o valor null para ele.
Não é possível chamarmos o método length() em cima do null, dado que esse método
pertence à classe String
>

# Optional: Outra Forma de Lidar com o NullPointerException

A partir da versão 8 do Java, foi introduzida uma nova classe chamada `Optional`. O `Optional` pode ser imaginado como uma caixa que pode estar vazia ou conter algo dentro dela. A principal vantagem é que você nunca terá as mãos vazias, sempre terá uma caixa, mesmo que ela esteja vazia.

No contexto do Java, o `Optional` nos permite lidar com objetos nulos de forma mais segura, encapsulando o valor (ou a ausência dele) dentro dessa "caixa".

## Principais Métodos do `Optional`

- `empty`: Cria uma instância vazia do `Optional`.
- `of`: Retorna um `Optional` com o valor fornecido, mas esse valor não pode ser nulo.
- `ofNullable`: Retorna um `Optional` com o objeto fornecido se o valor não for nulo, ou uma instância vazia caso contrário.
- `isPresent`: Verifica se existe uma instância dentro do `Optional`.
- `isEmpty`: O contrário de `isPresent`, retorna verdadeiro se o `Optional` estiver vazio.
- `get`: Retorna o objeto que está guardado dentro do `Optional`, caso exista.

## Exemplo Prático

Suponhamos que tenhamos a seguinte classe `Pessoa`:

```java
public class Pessoa {
  private String nome;

  public Pessoa(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return this.nome;
  }
}
```

### Agora vamos utilizá-la em uma variável com Optional:

```java
import java.util.Optional;

public class App {

  public static void main(String[] args) {
    Optional<Pessoa> optional = Optional.empty();

    if (optional.isPresent()) {
      System.out.println("Pessoa existe");
      System.out.println(optional.get().getNome());
    } else {
      System.out.println("Pessoa não existe");
    }
  }
}
```

### Nesse caso, criamos uma instância vazia do Optional e, ao verificar com o método isPresent, conseguimos saber se existe ou não um objeto dentro dele. Vamos alterar nosso código:

```java
import java.util.Optional;

public class App {

  public static void main(String[] args) {
    Pessoa pessoa = new Pessoa("Bob");
    Optional<Pessoa> optional = Optional.ofNullable(pessoa);

    if (optional.isPresent()) {
      System.out.println("Pessoa existe");
      System.out.println(optional.get().getNome());
    } else {
      System.out.println("Pessoa não existe");
    }
  }
}
```
> Log =  **Pessoa existe
Bob**



> **É possível realizar a maioria das operações com os métodos previamente mencionados** da classe `Optional`. No entanto, o `Optional` oferece uma gama de outros métodos que podem simplificar ainda mais suas operações:

- **`map`**: Permite a transformação do valor contido no `Optional` por meio de uma função.
- **`orElse`**: Oferece um valor padrão caso o `Optional` esteja vazio.
- **`orElseThrows`**: Permite lançar uma exceção personalizada se o `Optional` estiver vazio.
- **`stream`**: Facilita a conversão do valor dentro do `Optional` em uma sequência `Stream`.

A combinação desses métodos pode tornar a funcionalidade do `Optional` ainda mais poderosa, permitindo operações avançadas com mais segurança contra valores nulos.

```java
String pegaNome(Optional<Pessoa> optional){
    return optional.map(Pessoa::getNome).orElse("pessoa ausente");
    }
```

> Caso o Optional esteja presente, retornaremos o nome da pessoa. Mas caso ele 
> esteja vazio, retornaremos uma String padrão.

[Documentação oficial do Java SE 17 - Classe Optional](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Optional.html)

# Conhecendo o bloco finally

Tanto o bloco `catch` quanto o bloco `finally` são opcionais, mas não é permitido criar um bloco `try` sem pelo menos ter um `catch` ou um `finally`.

Outro ponto importante é que, diferentemente do bloco `catch`, em que você pode ter vários encadeados (o que chamamos de multi-catch), só é possível utilizar um bloco `finally` por bloco `try`.

Existem algumas situações específicas em que esse bloco não será executado. São elas:

- Se o comando `System.exit()` for executado;
- Se a thread executando o bloco `try-catch` for interrompida;
- Se a JVM cair.

Caso essas situações não aconteçam, o bloco `finally` sempre será executado.


