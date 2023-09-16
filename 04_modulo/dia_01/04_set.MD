# Set

**Resumo sobre a estrutura de dados Set:**

- Set é uma estrutura de dados que se assemelha a uma List, mas com duas diferenças essenciais.
- **Primeira diferença:** Não há garantia de ordem dos elementos no Set, embora algumas implementações possam apresentar ordenação.
- **Segunda diferença:** O Set não permite elementos duplicados, conforme sua especificação.

```java
public static void main(String[] args) {
    TreeSet<Integer> numeros = new TreeSet<Integer>();
    numeros.add(7);
    numeros.add(2);
    numeros.add(7);
    numeros.add(9);
    System.out.println(numeros);
}
```

Saída:
```java
[2, 7, 9]
```


**Como o Set identifica elementos repetidos em coleções de objetos personalizados:**

- Para tipos primitivos como `Integer` e `String`, a identificação de elementos repetidos é intuitiva.
- Para coleções de objetos criados pelo usuário, como um Set de estudantes, a verificação de igualdade é feita por meio do método `equals`.
- O método `equals` é uma função presente na classe base `Object` e é herdado por todas as classes Java.
- A implementação padrão do método `equals` compara a igualdade estrita dos objetos, ou seja, se eles apontam para o mesmo endereço de memória.
- No entanto, em classes personalizadas, costumamos sobrescrever o método `equals` para comparar objetos com base em atributos significativos, como comparar instâncias de `Estudante` com base em seus números de matrícula.
- Ao usar um Set com objetos personalizados, o Set chama o método `equals` para verificar se um novo objeto é igual a algum objeto já presente na coleção, evitando assim a adição de elementos duplicados.



```java
// Definindo a classe Estudante
class Estudante {

  // Declaração de variáveis de instância privadas
  private String matricula; // Matrícula do estudante
  private String nome;      // Nome do estudante

  // Método equals para comparar objetos Estudante
  public boolean equals(Object obj) {
    // Verifica se os objetos são idênticos na memória
    if (this == obj)
      return true;

    // Verifica se o objeto passado como argumento é nulo
    if (obj == null)
      return false;

    // Verifica se os objetos têm classes diferentes
    if (getClass() != obj.getClass())
      return false;

    // Faz um downcast do objeto passado para a classe Estudante
    Estudante other = (Estudante) obj;

    // Verifica se a matrícula do objeto atual é nula
    if (matricula == null) {
      // Se for nula, verifica se a matrícula do objeto other também é nula
      if (other.matricula != null)
        return false;
    } else {
      // Se a matrícula do objeto atual não for nula, compara as matrículas
      if (!matricula.equals(other.matricula))
        return false;
    }

    // Se todas as verificações anteriores passarem, os objetos são considerados iguais
    return true;
  }
}
```


### Resumo sobre Sets e TreeSet

Esta implementação permite que um conjunto (`Set`) de objetos da classe `Estudante` ignore a inserção de um objeto cuja matrícula seja igual à de outro objeto já presente no conjunto. No entanto, essa regra não se aplica ao `TreeSet`. O `TreeSet` armazena os elementos em uma árvore binária ordenada e exige que os objetos implementem a interface `java.lang.Comparable`.

Quando o `TreeSet` compara um novo elemento com os elementos existentes para determinar sua posição na árvore ordenada, ele usa o método `compareTo(T)`. Se o método `compareTo` retornar zero durante a comparação, o `TreeSet` considera o novo elemento como sendo idêntico a um elemento já existente e, portanto, descarta o novo elemento. Isso significa que, no `TreeSet`, apenas um único objeto com matrícula idêntica será mantido na coleção, garantindo assim a ordenação e a exclusão automática de duplicatas.


# Operações em Set

1. Um Set imutável] pode ser criado com a seguinte sintaxe:

```java
Set<String> estudantes = Set.of("João","Maria","Pedro","Rosa");
```

2. Já os mutáveis podem ser criados instanciando subclasses, como TreeSet e HashSet

```java
HashSet<String> estudantes = new HashSet<>();
```


### A operação de adição de elementos no Set retorna um boolean. Como o Set não admite elementos repetidos, esse valor retornado indica se houve sucesso na operação:

```java
public static void main(String[] args){
    HashSet<String> estudantes = new HashSet<>();
    boolean adicionouJoao = estudantes.add("João");
    boolean adicionouJoaoDeNovo = estudantes.add("João");
    boolean adicionouMaria = estudantes.add("Maria");
    System.out.println(String.format("adicionouJoao: %b",adicionouJoao));
    System.out.println(String.format("adicionouJoaoDeNovo: %b",adicionouJoaoDeNovo));
    System.out.println(String.format("adicionouMaria: %b",adicionouMaria));
}
```

Saída: 
```java
adicionouJoao: true
adicionouJoaoDeNovo: false
adicionouMaria: true
```


> A ordem não é garantida em coleções Set, implicando que não haverá índice 
> nos elementos, ao contrário do List. Sem índice, uma série de operações que
> existem em List deixam de fazer sentido no Set, como remover ou substituir um
> elemento a partir do índice.

#### A remoção por objeto

```java
public static void main(String[] args){
    HashSet<String> estudantes = new HashSet<>();
    estudantes.add("João");
    estudantes.add("Maria");
    System.out.println(estudantes);
    estudantes.remove("João");
    System.out.println(estudantes);
}
```

Saída:

```java
[João, Maria]
[Maria]
```

## E os métodos size()

```java
public static void main(String[] args){
    HashSet<String> estudantes = new HashSet<>();
    estudantes.add("João");
    estudantes.add("Maria");
    System.out.println(estudantes.size());
}
```
Saída:

```java
2
```
## E contains(T)

```java
public static void main(String[] args){
    HashSet<String> estudantes = new HashSet<>();
    estudantes.add("João");
    estudantes.add("Maria");
    System.out.println(estudantes.contains("Maria"));
}
```
Saída:

```java
true
```



