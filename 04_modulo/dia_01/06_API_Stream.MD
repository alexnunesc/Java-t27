# A API Stream

## Criando um Stream

```java
public class Estudante {

  private String matricula;

  private String nome;

  private String curso;

  public Estudante() {
  }

  public Estudante(String matricula, String nome, String curso) {
    this.matricula = matricula;
    this.nome = nome;
    this.curso = curso;
  }
  // GETs e SETs
}

public class CodeExamples {

  public static Collection<Estudante> obterEntrada() {
    return Set.of(
        new Estudante("2001", "Maria", "Computação"),
        new Estudante("2002", "João", "Computação"),
        new Estudante("2003", "José", "Pedagogia"),
        new Estudante("2004", "Ana", "Computação"),
        new Estudante("2005", "Bernardo", "Engenharia"),
        new Estudante("2006", "Antônia", "Computação"));
  }

  public static void main(String[] args) {
    Collection<Estudante> entrada = obterEntrada();
    List<String> matriculas = entrada.stream()
        .filter(e -> "Computação".equals(e.getCurso()))
        .sorted(Comparator.comparing(Estudante::getNome))
        .map(Estudante::getMatricula)
        .collect(Collectors.toList());
    System.out.println(matriculas);
  }

}
```

# Set.of na definição da Collection de Estudante.
> Refrescando sua memória: é apenas uma das maneiras de criar um Set passando 
> diretamente seus elementos.

### E se eu não tenho nada e já quero criar um stream?

```java
Stream<String> fluxoDeStrings = Stream.of("Maria","João","José");
```
> O Stream criado mantém a ordem sequencial fornecida. 

# Operações intermediárias da API Stream

Uma vez que temos um stream, podemos aplicar as operações que desejamos.

```java
Collection<Estudante> entrada = obterEntrada();
    List<String> matriculas = entrada.stream()
    .filter(e -> "Computação".equals(e.getCurso()))
    .sorted(Comparator.comparing(Estudante::getNome))
    .map(Estudante::getMatricula)
    .collect(Collectors.toList());
```
Nesse exemplo, foram várias operações: filtramos, ordenamos e transformamos para
outra coleção:

```java
.filter(e -> "Computação".equals(e.getCurso())) //filtrar    .sorted(Comparator.comparing(Estudante::getNome)) //ordenar
    .map(Estudante::getMatricula) //transformar
```

### Método `filter`
- O método `filter` recebe uma função lambda com um predicado.
- Apenas os objetos `Estudante` cujo teste `"Computação".equals(e.getCurso())` seja verdadeiro são incluídos no `Stream` de retorno desse passo.

### Método `sorted`
- O método `sorted` ordena o `Stream`.
- Ele recebe um objeto `java.util.Comparator` que indica como ordenar os elementos.
- A interface `java.util.Comparator` tem um método estático chamado `comparing` que, recebendo um método como parâmetro, gera o objeto `java.util.Comparator` de que precisamos.
- Neste caso, usamos o método `getNome` para ser usado na comparação.
- Strings já são comparáveis (possuem o método `compareTo`), por isso essa abordagem foi suficiente.

### Método `map`
- O método `map` transforma o `Stream` em outro `Stream` de mesmo tamanho, mas com outro conteúdo.
- É usada a função passada como parâmetro para aplicar a operação 1 a 1 nos elementos presentes.
- Nesse caso, tínhamos um `Stream` de `Estudante` e passamos a ter um `Stream` só com as matrículas.

### Encadeamento de operações
- Para ser possível aplicar infinitas operações em um `Stream` usando essa sintaxe, cada operação retorna o próprio `Stream<T>`.
- As operações da Stream API que retornam um objeto do tipo `Stream<T>` e possibilitam esse encadeamento de operações são chamadas “operações intermediárias”.
- Elas são responsáveis por toda a transformação dos dados.
