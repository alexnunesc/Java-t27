# Testes em aplicações Spring

### ***Testes em aplicações REST***

> Suponha que tivéssemos a rota a seguir em nossa aplicação. Através dela,
> conseguimos pegar os dados de uma pessoa estudante através de um service:

```java
@GetMapping("/students/{id}")
// Este método é um controlador que lida com solicitações GET para "/students/{id}".

// O parâmetro "id" é anotado com @PathVariable, o que significa que seu valor será extraído
// automaticamente a partir do segmento de URL correspondente na solicitação HTTP.

// O objetivo deste método é obter as informações de um estudante com base no ID fornecido na URL.
public ResponseEntity<Student> getStudent(@PathVariable Long id) {
    // 1. Obtém um estudante com base no ID fornecido, retornando um Optional<Student>.
    Optional<Student> optionalStudent = service.getStudent(id);

    // 2. Verifica se um estudante foi encontrado.
    return optionalStudent
    // 3. Se um estudante foi encontrado, cria uma resposta HTTP 200 (OK) com o estudante encontrado.
    .map(student -> ResponseEntity.ok(student))
    // 4. Se nenhum estudante foi encontrado, cria uma resposta HTTP 404 (Not Found).
    .orElse(ResponseEntity.notFound().build());
    }

```

# RestTemplate vs MockMvc

> Classes **RestTemplate** e **MockMvc**.

Anota aí 📝: a **RestTemplate** precisa que o servidor seja realmente executado para os testes, enquanto a **MockMvc** apenas simula as requisições, sem necessidade do servidor.

Anota aí 📝:

- O Spring garante que o servidor está sendo executado.
- Nós só precisamos implementar o cliente em nossos testes.
- Para isso, podemos utilizar a classe **RestTemplate**.
- O principal objetivo da classe **RestTemplate** é fazer requisições REST, não só para testes, mas em qualquer caso.


Porém o melhor para economizar é usar o **MockMvc**

# Usando RestTemplate:

- Com o uso do **RestTemplate**, podemos indicar a URL da nossa API.
- Podemos efetuar a chamada correspondente ao verbo HTTP previamente indicado.
- Para uma requisição GET, usamos a função `getForEntity`.
- Para testar uma função do tipo POST, usaríamos `postForEntity`.


```java
// Anotação para configurar este como um teste Spring Boot em um ambiente com porta definida.
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
class StudentsApplicationTests {

  // Injeção de dependência do RestTemplate para fazer chamadas HTTP.
  @Autowired
  private RestTemplate restTemplate;

  // Método de teste para verificar a chamada GET a um aluno específico.
  @Test
  void testGetStudentById() {
    // Faz uma chamada HTTP GET para o URL "http://localhost:8080/students/123" e armazena a resposta.
    ResponseEntity<Student> response = restTemplate.getForEntity(
        "http://localhost:8080/students/123", Student.class);

    // Verifica se o código de status HTTP na resposta é igual a HttpStatus.OK (200).
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

    // Verifica se o corpo da resposta (objeto Student) não é nulo.
    assertThat(response.getBody()).isNotNull();
  }
}

```

### No teste apresentado acima, temos:

1. Indicação que queremos que o servidor de teste seja executado na porta padrão, que é 8080 no nosso caso, embora também seja possível usar uma porta aleatória.

2. Injeção de um bean do **RestTemplate**, que é uma instância que permite fazer requisições HTTP em nossos testes.

3. Realização de uma requisição para uma URL específica, aguardando um objeto do tipo **Student** como resposta.

4. Verificação do status code 200 (OK), indicando que a requisição foi bem-sucedida, e verificação da existência do corpo da resposta.

> Nesse exemplo, estamos usando o assertThat do AssertJ, uma dependência que o Spring Boot traz. Poderíamos utilizar os métodos do próprio JUnit como o assertEquals

Mas uma forma alternativa (que estamos utilizando) é simplesmente transformá-la em um bean.

```java
@Bean
public RestTemplate restTemplate() {
    return new RestTemplate();
}
```

Uma última nota sobre a RestTemplate: nas versões mais recentes do Spring ela 
vem sido gradualmente substituída pelo uso da classe **WebClient**.


# Usando MockMvc

>Com o uso da MockMvc, podemos indicar ao Spring boot que não será 
> necessário iniciar o servidor.

Para podermos utilizar a **MockMvc**
usamos a anotação **@AutoConfigureMockMvc**


# Isolando testes de camadas com @MockBean


Uma das anotações que a Mockito disponibiliza é a @MockBean. Ela permite que nós
controlemos as chamadas para beans que são injetados pelo Spring.


No nosso exemplo inicial, a rota GET foi definida pelo método getStudent do controller, que chamava o método de um service. Vamos supor que esse service é um bean controlado pelo Spring:

```java
@RestController
public class StudentsController {
  
  StudentsService service;

  @Autowired
  public StudentsController(StudentsService service) {
    this.service = service;
  }

  // ... restante da classe ...

}
```

E se quiséssemos isolar o teste, focando na camada de controle? 

Entra o **@MockBean**

```java
@SpringBootTest
@AutoConfigureMockMvc
class StudentsApplicationMockBeanTests {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private StudentsService service; // (1)

  @Test
  void testStudentNotFound() throws Exception {
    Mockito
        .when(service.getStudent(123L))
        .thenReturn(Optional.empty());  // (2)

    ResultActions result = mockMvc.perform(  // (3)
        get("/students/123"));

    result.andExpect(status().isNotFound());
  
    Mockito.verify(service).getStudent(123L);  // (4)
  }
}
```

No exemplo acima, fizemos o seguinte:

1. Primeiro (1), definimos o serviço (`StudentsService`) e anotamos com `@MockBean`. Isso substitui o bean injetado no controlador pelo nosso mock. Qualquer chamada feita pelo controlador ao serviço será redirecionada para o nosso mock.

2. Segundo (2), antes de realizar a chamada à rota (usando o `mockMvc`), configuramos nosso mock para que, se o serviço fosse chamado com `.getStudent(123L)`, ele retornaria `Optional.empty()`. Isso simula um cenário em que o serviço não encontra um estudante com o ID 123.

3. Terceiro (3), fizemos a chamada à API normalmente. No entanto, devido à configuração do mock do serviço, esperamos que a rota retorne um código de status 404 (não encontrado), indicando que o estudante não foi encontrado.

4. Por fim (4), utilizamos o Mockito para verificar se o mock do serviço foi chamado conforme esperado. Isso nos permite garantir que o controlador não tenha alcançado uma resposta correta por outros meios, sem usar o serviço. É um teste adicional para verificar a interação correta entre o controlador e o serviço.
