# A anotação @RequestMapping

```java
@RestController
@RequestMapping("/podcasts")
public class PodcastRestController {
}
```
## Anotação `@RequestMapping` no Mapeamento de Rotas em API Rest

A anotação `@RequestMapping` desempenha um papel crucial no mapeamento de rotas em nossa API REST.

No exemplo `@RequestMapping("/podcasts")`, esse parâmetro indica o caminho da rota e é equivalente a `@RequestMapping(path="/podcasts")`. (Nota: Você pode encontrar lugares que usam os parâmetros `path` e outros que usam `value`, mas eles são equivalentes na `RequestMapping`.)

Isso permite definir a rota que a API responderá quando uma solicitação correspondente for feita, facilitando o roteamento e o controle de endpoints em nossa aplicação.

## A anotação também pode ser aplicada a métodos, como abaixo:

```java
@RestController
@RequestMapping("/podcasts")
public class PodcastRestController {
  @RequestMapping(method=RequestMethod.GET)
  public String getRoot() {
    return "Yay Podcasts!";
  }
}
```
> Nesse caso, como não há indicação da rota, é considerada a rota “raiz”.
Já o parâmetro method indica qual o método HTTP que estamos configurando (no caso, o método GET).
>

## Anotações de Método HTTP no Spring

No Spring, a anotação `@RequestMapping` possui parâmetros que permitem configurar diferentes elementos, como rota, cabeçalhos, tipo de retorno, etc. No entanto, é muito comum configurar o método HTTP que queremos atender. Para facilitar essa configuração e tornar o código mais direto e legível, o Spring disponibiliza outras anotações prontas, uma para cada método HTTP:

- `@GetMapping`: Configura uma rota para responder a solicitações HTTP GET.
- `@PostMapping`: Configura uma rota para responder a solicitações HTTP POST.
- `@PutMapping`: Configura uma rota para responder a solicitações HTTP PUT.
- `@DeleteMapping`: Configura uma rota para responder a solicitações HTTP DELETE.
- `@PatchMapping`: Configura uma rota para responder a solicitações HTTP PATCH.

Usar essas anotações é equivalente a usar a anotação `@RequestMapping` configurada com o método apropriado, mas elas tornam o código mais direto e fácil de ler. Portanto, sempre que possível, é recomendável dar preferência ao uso dessas anotações específicas de método HTTP.
