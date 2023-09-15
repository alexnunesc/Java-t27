# Rotas POST e outros mapeamentos

Spring disponibiliza a anotação @RequestBody. Vamos criar uma nova rota em nossa API de podcasts:

```java
//@RestController
//@RequestMapping(path="/podcasts")
//public class PodcastRestController {

  // ... restante da classe ...
    

  @PostMapping
  public ResponseEntity<Podcast> newPodcast(@RequestBody Podcast newPodcast) {
    // Vamos fingir que estamos salvando o podcast 
    // ao atribuir um ID aleatório a ele
    newPodcast.setId(new Random().nextInt(0, 1000));
    
    return ResponseEntity.status(HttpStatus.CREATED).body(newPodcast);   
  }
  
//}
```

## Rota POST para Criação de Podcast

Neste método, estamos criando uma rota do tipo POST usando a anotação `@PostMapping`. Além disso, utilizamos a anotação `@RequestBody` para indicar que o parâmetro `newPodcast` será mapeado a partir do corpo da requisição, utilizando a desserialização do JSON.

No processo, geramos um ID aleatório como se estivéssemos simulando o salvamento do objeto e, em seguida, retornamos esse objeto como resposta com o status code 201 ("created").


## Outros Mapeamentos: PUT, PATCH e DELETE

Além das rotas GET e POST, o Spring oferece suporte para outros métodos HTTP. O uso dos métodos PUT e PATCH é semelhante ao método POST, mas utiliza as anotações `@PutMapping` e `@PatchMapping`, respectivamente. Da mesma forma, o método DELETE tem um funcionamento semelhante ao método GET, mas utiliza a anotação `@DeleteMapping`.

Como os usos desses métodos são muito similares ao que já vimos anteriormente, não entraremos em detalhes aqui. Se você desejar aprofundar seu conhecimento, pode consultar o guia na [documentação oficial do Spring](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-ann-httpmethods) e a documentação específica de cada anotação.
[link](https://spring.io/guides/tutorials/rest/)

