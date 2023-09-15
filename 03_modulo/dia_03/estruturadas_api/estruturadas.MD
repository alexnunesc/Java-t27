# Respostas estruturadas da API

```java
public class Podcast {
  private Integer id;
  private String name;
  private String url;
  
  // ... getters e setters ...
}
```
Agora vamos alterar o controller do nosso exemplo de Podcasts para retornar um objeto desse tipo, assim:

```java

//@RestController
//@RequestMapping(path="/podcasts")
//public class PodcastRestController {

  // ... restante da classe ...
    
  @GetMapping("/{id}")
  public Podcast getPodcast(@PathVariable Integer id) {
    Podcast result = new Podcast();
    result.setId(id);
    result.setName("Meu podcast");
    result.setUrl("http://www.meupodcast.com.br");
    return result;
  }
  
//}
```

## Controlando a Resposta com `ResponseEntity`

Ao desenvolver APIs no Spring, retornar objetos estruturados diretamente em métodos pode ser conveniente, mas em algumas situações, você pode precisar de um maior controle sobre a resposta. Para isso, o Spring oferece a classe `ResponseEntity`.

A classe `ResponseEntity` permite representar uma resposta HTTP que a sua API pode retornar, incluindo:

1. **Status Code**: Você pode definir o código de status HTTP da resposta.
2. **Cabeçalhos**: É possível configurar cabeçalhos personalizados na resposta.
3. **Corpo da Resposta**: Você pode incluir o objeto de resposta que deseja retornar.

Aqui está um exemplo adaptado:

```java
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

// ...

@GetMapping("/exemplo")
public ResponseEntity<String> exemplo() {
    String mensagem = "Esta é uma resposta customizada com ResponseEntity.";
    HttpHeaders headers = new HttpHeaders();
    headers.add("Custom-Header", "Valor-Customizado");
    
    return new ResponseEntity<>(mensagem, headers, HttpStatus.OK);
}
``` 

### Exemplo trybe.
```java
import org.springframework.http.ResponseEntity;

  // ... restante da classe ...

  @GetMapping("/{id}")
  public ResponseEntity<Podcast> getPodcast(@PathVariable Integer id) {
    if (id > 1000)
      return ResponseEntity.notFound().build();
      
    Podcast result = new Podcast();
    result.setId(id);
    result.setName("Meu podcast");
    result.setUrl("http://www.meupodcast.com.br");
    
    return ResponseEntity.ok(result);
  }
  
  // ... restante da classe ...
```


