# List

A interface List deve ser uma lista **ordenada** de objetos e que 
**permite a presença de elementos duplicados.**


Qualquer lista de números inteiros terá como primeiro item o menor deles?
A resposta para essas perguntas é: não.

1. Vejamos um exemplo para entender isso:

```java
  public static void main(String[] args){
    ArrayList<Integer> numeros = new ArrayList<Integer>();
    numeros.add(7);
    numeros.add(2);
    numeros.add(1);
    numeros.add(9);
    System.out.println(numeros);
    }
```

A saída será: [7, 2, 1, 9]

> Quando você ouvir que a lista é um tipo ordenado, tenha em mente que isso se
> refere à propriedade que a lista tem de preservar a ordem dos elementos na
> leitura, mesmo que essa ordem não signifique nada comparativamente. Nesse
> nosso caso, a lista é lida na ordem de inserção, já que depois de ela ser
> populada não houve nenhum reposicionamento.


### Dá pra colocar em ordem crescente?
É possível reposicionar os elementos no List e, por isso, conseguimos também
ordená-los de forma comparativa (como do menor para o maior em uma lista de inteiros). 

```java
  public static void main(String[] args){
    ArrayList<Integer> numeros = new ArrayList<Integer>();
    numeros.add(7);
    numeros.add(2);
    numeros.add(1);
    numeros.add(9);
    System.out.println(numeros);
    Collections.sort(numeros);
    System.out.println(numeros);
    }
```

>O método sort da classe utilitária Collections(cuidado pra não confundir com a
> interface Collection 😅) 


### Se depois da ordenação você insere um novo elemento, o que acontece? Veremos a seguir:

```java
  public static void main(String[] args){
    List<Integer> numeros = new ArrayList<Integer>();
    numeros.add(7);
    numeros.add(2);
    numeros.add(1);
    numeros.add(9);
    System.out.println(numeros);
    Collections.sort(numeros);
    System.out.println(numeros);
    numeros.add(3);
    System.out.println(numeros);
    }
```

>O List faz aquilo que sabe: respeita a ordem atual dos elementos e posiciona o
> novo elemento no final:

```java
[7, 2, 1, 9]
[1, 2, 7, 9]
[1, 2, 7, 9, 3]
```

# **Implementações de List em Java:**

- List é uma interface em Java e não pode ser instanciada diretamente.

- Uma das implementações nativas da interface List é o ArrayList, que é amplamente utilizado e eficiente para a maioria dos cenários.

- Outra implementação de List é o LinkedList, que, assim como o ArrayList, é adequado para a maioria dos casos. A diferença principal está na forma como os dados são armazenados e recuperados, o que pode afetar o desempenho em casos de grande volume de dados.

- O Vector é uma implementação antiga de List e é thread-safe, mas suas operações tendem a ser mais lentas em comparação com outras implementações. É considerada uma classe legada e não é recomendada para uso atualmente. ❌


# Operações em List

1. Abaixo, confira o uso dela em um sistema escolar:

```java
  public static void main(String[] args){
    List<String> estudantes = Arrays.asList("João","Maria","Pedro","Rosa");
    System.out.println(estudantes);
    }
```

Saída: 
```java
[João, Maria, Pedro, Rosa]
```

> Esse trecho de código traz a criação de uma lista a partir da sintaxe
> simplificada de um array. É o equivalente a declarar:

```java
List<String> estudantes = Arrays.asList(new String[]{"João","Maria","Pedro","Rosa"});
```
OU
```java
String[]arrayDeEstudantes = new String[]{"João","Maria","Pedro","Rosa"};
    List<String> estudantes = Arrays.asList(arrayDeEstudantes);
```
### Outra forma ainda mais simples de se criarem listas, com a ressalva de que são listas imutáveis, é utilizando a sintaxe que estreou no Java 9:

```java
  List<String> estudantes = List.of("João","Maria","Pedro","Rosa");
```

Para recuperar um elemento da lista pelo seu índice, usamos o get(int):

```java
  public static void main(String[] args){
    List<String> estudantes = List.of("João","Maria","Pedro","Rosa");
    String estudanteDoIndice2 = estudantes.get(2);
    System.out.println(estudanteDoIndice2);
    }
```

Saída: Pedro

#### Nas coleções imutáveis, qualquer tentativa de modificação resulta em erro.

1. Exemplo: 
```java
  public static void main(String[] args){
    List<String> estudantes = List.of("João","Maria","Pedro","Rosa");
    estudantes.set(0,"Joana");
    }
```

```java
Exception in thread "main" java.lang.UnsupportedOperationException
	at java.base/java.util.ImmutableCollections.uoe(ImmutableCollections.java:142)
	at java.base/java.util.ImmutableCollections$AbstractImmutableList.set(ImmutableCollections.java:260)
	at com.betrybe.CodeExamples.main(CodeExamples.java:22)
```

### Para isso funcionar, poderíamos usar o método Arrays.asList:

```java
  public static void main(String[] args){
    List<String> estudantes = Arrays.asList("João","Maria","Pedro","Rosa");
    estudantes.set(0,"Joana");
    }
```

> O Arrays.asList retorna uma lista de tamanho fixo, cujos valores são mutáveis.
>No entanto, não poderemos adicionar ou remover elementos dela.


### Para adicionar ou remover elementos, podemos criar explicitamente um ArrayList

1. ADICIONANDO
```java
  public static void main(String[] args) {
    ArrayList<String> estudantes = new ArrayList<String>(Arrays.asList("João","Maria","Pedro","Rosa"));
    estudantes.add("Joana");
    System.out.println(estudantes);
  }
```
Saída: 

```java
[Joana, Maria, Pedro, Rosa, Joana]
```

2. REMOVENDO

```java
  public static void main(String[] args){
    ArrayList<String> estudantes = new ArrayList<String>(Arrays.asList("João","Maria","Pedro","Rosa"));
    estudantes.remove(1);
    System.out.println(estudantes);
    estudantes.remove("Pedro");
    System.out.println(estudantes);
    }
```

Saída:

```java
[João, Pedro, Rosa]
[João, Rosa]
```

### Outra operação comum em List(e outras coleções) é verificar o tamanho atual através do método size():

```java
  public static void main(String[] args){
    List<String> estudantes = Arrays.asList("João","Maria","Pedro","Rosa");
    System.out.println(estudantes.size());
    }
```

Saída: 4

### Assim como verificar com o contains(T) se um item pertence atualmente àquela instância:

```java
  public static void main(String[] args){
    List<String> estudantes = Arrays.asList("João","Maria","Pedro","Rosa");
    System.out.println(estudantes.contains("João"));
    }
```

Saída: true

[Documentação da Interface List em Java](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/List.html)
