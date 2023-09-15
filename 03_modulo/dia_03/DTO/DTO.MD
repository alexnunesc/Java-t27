# O padrão DTO: Data Transfer Object

O padrão DTO, que significa "Data Transfer Object" em inglês, é uma abordagem em desenvolvimento de software que consiste em:

### 1. Separação de Classes de Dados

- Criar classes de dados internas que representam os dados internos da aplicação.

### 2. Classes para Comunicação de Dados

- Separar as classes utilizadas para a comunicação de dados, ou seja, aquelas que serão recebidas ou enviadas por meio de APIs, serviços web ou outras formas de transferência de dados.

### 3. Propósito dos DTOs

- Os DTOs são utilizados para o segundo caso mencionado acima, ou seja, são objetos criados com o propósito específico de transferir dados entre diferentes partes do sistema, como entre a aplicação e uma API.

Em resumo, o padrão DTO ajuda a organizar e separar as classes de dados internas das classes utilizadas para a comunicação de dados, facilitando a transferência eficiente de informações entre diferentes partes do sistema.

```java
  // ... restante da classe controller da API ...

  Podcast findPodcastById(Integer id) {
    Podcast podcast = new Podcast();
    podcast.setId(id);
    podcast.setName("Meu podcast");
    podcast.setUrl("http://www.meupodcast.com.br");
    podcast.setSecretToken("super-secret-token-123");
    
    return podcast;
  }

  @GetMapping("/{id}")
  public ResponseEntity<PodcastDto> getPodcast(@PathVariable Integer id) {
    if (id > 1000)
      return ResponseEntity.notFound().build();
  
    Podcast podcast = findPodcastById(id);
    
    PodcastDto podcastDto = new PodcastDto(
        podcast.getId(), podcast.getName(), podcast.getUrl()
    );
        
    return ResponseEntity.ok(podcastDto);
  }
```

## DTOs, objetos de requisição e de resposta
Um problema paralelo, mas relacionado, ao de DTOs é o de diferenciar objetos de
requisição dos objetos de resposta. Quando criamos nossa rota POST na API de podcasts, ela estava com a seguinte estrutura:

```java
  // ... restante da classe ...

  @PostMapping("/")
  public ResponseEntity<Podcast> newPodcast(@RequestBody Podcast newPodcast) {
    // Vamos fingir que estamos salvando o podcast 
    // ao atribuir um ID aleatório a ele
    newPodcast.setId(new Random().nextInt(0, 1000));
    
    return ResponseEntity.status(HttpStatus.CREATED).body(newPodcast);   
  }
```


# Refatorando

1. Vamos criar uma nova classe utilizando record:
```java
public record PodcastCreationDto (String name, String url) {}
```

2. E em seguida vamos refatorar nossa rota:

```java
  // ... restante da classe ...

  Podcast createPodcast(PodcastCreationDto newPodcastDto) {
    Podcast podcast = new Podcast();
    // Vamos fingir que estamos salvando o podcast 
    // ao atribuir um ID aleatório a ele
    podcast.setId(new Random().nextInt(0, 1000));
    podcast.setSecretToken("super-secret-token-123");

    podcast.setName(newPodcastDto.name());
    podcast.setUrl(newPodcastDto.url());

    return podcast;
  }

  @PostMapping
  public ResponseEntity<PodcastDto> newPodcast(@RequestBody PodcastCreationDto newPodcast) {
    Podcast podcast = createPodcast(newPodcast);
    
    PodcastDto podcastDto = new PodcastDto(
        podcast.getId(), podcast.getName(), podcast.getUrl()
    );
    
    return ResponseEntity.status(HttpStatus.CREATED).body(podcastDto);   
  }
```

## Conversões e Padrão DTO

Ao realizar algumas mudanças em nosso código, podemos observar algumas alterações importantes:

### 1. Alteração do Tipo de Objeto Recebido

- Modificamos o tipo de objeto que nossa requisição recebe para `PodcastCreationDto`, que contém apenas o nome e a URL do podcast.

### 2. Extração da Criação para um Método Separado

- Extraímos a lógica de criação para outro método chamado `createPodcast`.

### 3. Retorno de um Objeto do Tipo `PodcastDto`

- Passamos a retornar um objeto do tipo `PodcastDto`, que além do nome e URL também contém o ID do novo podcast.

### 4. Sequência de Conversão

- Observamos uma sequência de conversão: `PodcastCreationDto` -> `Podcast` -> `PodcastDto`.

### 5. Conversões Manuais e Bibliotecas

- Esse tipo de conversão é comum em aplicações que utilizam o padrão DTO. Embora seja útil para entender o processo, em aplicações reais pode ser prático utilizar funções auxiliares ou bibliotecas específicas para realizar essas conversões.

### 6. Bibliotecas de Conversão

- Existem bibliotecas como **ModelMapper** ou **MapStruct** que podem ser 
  usadas 
  para 
  simplificar o trabalho de conversão. No entanto, é importante notar que essas bibliotecas podem ter limitações e nem sempre se aplicam a todos os casos (algumas podem não ter suporte para tipos record, por exemplo).

Essas adaptações e conversões são comuns em aplicações que adotam o padrão DTO, permitindo uma melhor organização e transferência eficiente de dados entre diferentes partes do sistema.

