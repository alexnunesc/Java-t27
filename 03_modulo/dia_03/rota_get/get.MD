# Rotas GET
* A anotação @GetMapping

```java
@RestController
@RequestMapping("/podcasts")
public class PodcastRestController {
  @GetMapping
  public String getRoot() {
    return "Yay Podcasts!";
  }
}
```
> Rota GET simples e que retorna sempre o mesmo valor.

## Utilizando Variáveis de Caminho (Path Variables)

Uma das maneiras de parametrizar uma rota é por meio do uso de
"variáveis de caminho" (path variables).

```java
import org.springframework.web.bind.annotation.PathVariable;

// ... restante da classe ...

@GetMapping("/{id}")
public String getPodcast(@PathVariable Integer id) {
  return String.format("Você pediu pelo Podcast com id: %d", id);
}

// ... restante da classe ...
```

## Utilizando Variáveis de Caminho e `@PathVariable` no Spring

Nesta implementação, introduzimos dois elementos novos:

1. `@GetMapping("/{id}")`: Utilizamos chaves '{}' para indicar que nossa rota terá uma variável de caminho chamada 'id'. Observe que, como a classe está mapeada com a rota '/podcasts', a rota final do nosso mapeamento será '/podcasts/{id}'.

2. `@PathVariable`: Essa anotação é utilizada no parâmetro do método e indica que o valor daquele parâmetro deve ser mapeado automaticamente a partir da variável de caminho que tenha o mesmo nome do parâmetro (no caso, 'id').

Esses recursos permitem que você capture valores específicos da URL e os utilize como parâmetros em seus métodos no Spring, tornando a manipulação de variáveis de caminho muito mais conveniente.


## Parâmetros por “query string”

```java
import org.springframework.web.bind.annotation.RequestParam;

  // ... restante da classe ...

  @GetMapping("/search")
  public String searchPodcast(@RequestParam String title) {
    return String.format("Você buscou por Podcasts com o título: %s", title);
  }
  
  // ... restante da classe ...
```

Assim, se após reiniciar a aplicação, você acessar o endereço [http://localhost:8080/podcasts/search?title=podcasts sobre Java](http://localhost:8080/podcasts/search?title=podcasts%20sobre%20Java), terá como resposta:

"Você buscou por Podcasts com o título: podcasts sobre Java"
