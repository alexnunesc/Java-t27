# Lidando com exceções no Spring

> Vamos supor então que tivéssemos uma classe Pessoa contendo um id e um nome,
e é utilizada em um controller:

```java

@RestController
public class PessoaController {

  // ... restante da classe com definição do service ...

  @GetMapping("/pessoas/{nome}")
  public Pessoa buscarPessoaPeloNome(@PathVariable String nome) {
    return pessoaService.buscarPessoaPeloNome(nome);
  }
}
```

```java

@Service
public class PessoaService {
  // ... restante do service com definição do banco de dados...

  public Pessoa buscarPessoaPeloNome(String nome) {
    return bancoDeDados.findByNome(nome)
        .orElseThrow(() -> new PessoaNaoEncontradaException("Pessoa não encontrada"));
  }
}
```
> Note que neste caso estamos usando o método orElseThrow da classe Optional, 
> para
lançar a exceção caso não encontremos o resultado.

> Por padrão, quando uma exceção é lançada em um controller no Spring, o status
code retornado é o 500 (erro interno do servidor). Vamos ver agora formas de
especificar qual o resultado que queremos para nossa exceção.


# Gerando o status a partir da exceção
Para realizar o mapeamento entre exceção e status code, uma opção é usar a anotação ResponseStatus na própria exceção, por exemplo:

```java

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PessoaNaoEncontradaException extends RuntimeException {

  public PessoaNaoEncontradaException(String message) {
    super(message);
  }
}
```

# Tratamento de Exceções no Spring usando @ExceptionHandler

O Spring Framework oferece várias maneiras de lidar com exceções em seus controladores. Uma das abordagens é usar a anotação `@ExceptionHandler` para personalizar o tratamento de exceções em um controlador específico. Esta anotação permite agrupar várias exceções e definir um status HTTP personalizado para cada uma delas.

## Usando @ExceptionHandler

A anotação `@ExceptionHandler` permite que você defina um método em seu controlador para tratar exceções específicas e retornar uma resposta personalizada. Aqui está um exemplo de como usá-lo:

```java

@RestController
public class PessoaController {

  @GetMapping("/pessoas/{nome}")
  public Pessoa buscarPessoaPeloNome(@PathVariable String nome) {
    return pessoaService.buscarPessoaPeloNome(nome);
  }

  @ExceptionHandler
  public ResponseEntity<String> handlePessoaNaoEncontradaException(
      PessoaNaoEncontradaException exception) {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(exception.getMessage());
  }
}
```

## Usando varias casos.

```java
@ExceptionHandler({
    PessoaNaoEncontradaException.class,
    NomeNaoEncontradoException.class,
    DocumentoNaoEncontradoException.class
})
public ResponseEntity<String> handleRecursoNaoEncontradaException(RuntimeException exception){
    return ResponseEntity
    .status(HttpStatus.NOT_FOUND)
    .body(exception.getMessage());
    }
```
>Embora a anotação ExceptionHandler aparente ser prática, ela nos traz alguns problemas inerentes à sua praticidade. 

# Utilizando @ControllerAdvice

> Um dos problemas para o uso de @ExceptionHandler em uma classe controller é 
> a necessidade de reproduzir o mesmo trecho de código em todos os controladores que possam emitir exceções.


1. Vamos criar uma classe responsável por gerenciar as exceções emitidas 
  pelos nossos controllers:

```java

@ControllerAdvice
public class GerenciadorExceptionController {

  @ExceptionHandler({
      PessoaNaoEncontradaException.class,
      NomeNaoEncontradaException.class,
      MatriculaNaoEncontradaException.class
  })
  public ResponseEntity<String> handleRecursoNaoEncontrado(RuntimeException exception) {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(exception.getMessage());
  }
}
```

A anotação @ControllerAdvice utilizada faz com que o Spring a trate como um 
@Component. Sendo assim, não será necessário instanciar um objeto dessa classe 
em outro local, o Spring cuidará dela. Além disso, note que definimos um 
ExceptionHandler dentro dessa nova classe, e não precisamos mais que isso esteja
no controller.


# Hierarquia de tratamento


> Os métodos presentes no ControllerAdvice respeitam a ordem da hierarquia das 
exceções a serem tratadas,
buscando tratar as exceções mais específicas e, caso não existam, busca algum 
tratamento destinado a exceções genéricas.


```java

@ControllerAdvice
public class GerenciadorExceptionController {

  @ExceptionHandler(PessoaNaoEncontradaException.class)
  public ResponseEntity<String> handlePessoaNaoEncontradaException(
      PessoaNaoEncontradaException exception) {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(exception.getMessage());
  }

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<String> handleRuntimeException(RuntimeException exception) {
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(exception.getMessage());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleException(Exception exception) {
    return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(exception.getMessage());
  }

  @ExceptionHandler(Throwable.class)
  public ResponseEntity<String> handleThrowable(Throwable exception) {
    return ResponseEntity
        .status(HttpStatus.BAD_GATEWAY)
        .body(exception.getMessage());
  }
}
```


A partir de agora, as classes marcadas como `@RestController` não precisam mais da marcação `@ExceptionHandler` para o tratamento de erros. O Spring vai gerenciar os erros lançados pelos controllers e levá-los para o `@ControllerAdvice`. Assim, tendo essa sequência, a aplicação retornaria:

- **NOT_FOUND** caso `PessoaNaoEncontradaException` seja lançada;
- **BAD_REQUEST** caso `RuntimeException` seja lançada;
- **INTERNAL_SERVER_ERROR** caso `Exception` seja lançada;
- **BAD_GATEWAY** caso `Throwable` seja lançada.















