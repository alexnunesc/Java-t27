# A camada de controle até agora

##### Criando a camada de serviço
> A camada de serviço é responsável por cuidar da lógica de negócios da nossa 
> aplicação, e adicioná-la agora vai permitir que nossa aplicação cresça de forma mais organizada.

Vamos criar a camada de serviço extraindo os métodos **findPodcastById** e
**createPodcast** da classe **PodcastController** para uma outra classe, 
conforme 
abaixo:

```java
@Service
public class PodcastService {
  /**
   * Método para simular busca por um podcast pelo ID.
   */
  public Podcast findPodcastById(Integer id) {
    Podcast podcast = new Podcast();
    podcast.setId(id);
    podcast.setName("Meu podcast");
    podcast.setUrl("http://www.meupodcast.com.br");
    podcast.setSecretToken("super-secret-token-123");
    
    return podcast;
  }

  /**
   * Método para simular a criação de um novo podcast.
   */
  public Podcast createPodcast(PodcastCreationDto newPodcastDto) {
    Podcast podcast = new Podcast();
    // Vamos fingir que estamos salvando o podcast 
    // ao atribuir um ID aleatório a ele
    podcast.setId(new Random().nextInt(0, 1000));

    podcast.setName(newPodcastDto.name());
    podcast.setUrl(newPodcastDto.url());

    podcast.setSecretToken("super-secret-token-123");

    return podcast;
  }
  
}
```
