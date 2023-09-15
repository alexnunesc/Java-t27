# Controle de falhas

**Circuit Breaker**

Existem hoje um conjunto de ferramentas que, utilizadas em conjunto, podem nos ajudar a manter a capacidade de lidar com problemas e adaptar-nos a mudanças. Isso é o que chamamos de *Resiliência*.

O *Circuit Breaker* é implementado através de uma máquina de estados finitos com três estados normais:

- 🟢 **CLOSED**: Representa o status normal da aplicação, onde cada camada atua como esperado, sejam serviços externos ou internos à sua infraestrutura;

- 🔴 **OPEN**: Representa status a partir da identificação de alguma anomalia, alguma camada que não está respondendo informações como esperado ou que ficou inoperante;

- 🟡 **HALFOPEN**: Representa o _status intermediário e indica que o circuito já esteve no status OPEN e que está validando a possibilidade de se tornar CLOSED, dependendo da janela a ser observada.

⚠️ *Atenção*: Janela é a configuração que pode ser definida por quantidade de operações ou um tempo fixo.



### Vejamos uma camada de serviço que invoca um banco de dados (camada de 
persistência) para listar registros salvos na base de dados:

```java
public List<Pessoa> listarPessoas() {
  return bancoDeDados.findAll();
}
```


Para a aplicação, o serviço de banco de dados é um ponto de falha e, caso esteja indisponível
utilizaremos uma das bibliotecas destinadas para tratar falhas, conhecida como resilience-4j

```xml
<dependency>
  <groupId>io.github.resilience4j</groupId>
  <artifactId>resilience4j-all</artifactId>
  <version>2.0.2</version>
</dependency>
<dependency>
<groupId>io.github.resilience4j</groupId>
<artifactId>resilience4j-spring-boot2</artifactId>
<version>2.0.2</version>
</dependency>
```

🖊Anote aí: no exemplo, consideramos o uso da biblioteca original, mas o 
resilience-4j também pode ser encontrada internamente dentro do Spring Cloud
através da dependência spring-cloud-starter-circuitbreaker-resilience4j.

[Resilience4j Documentation](https://resilience4j.readme.io/)


### O que deveria ser alterado no método citado para garantir que o fluxo passasse a ser monitorado por um circuit breaker?

```java
@CircuitBreaker(name = "pessoas")
public List<Pessoa> listarPessoas() {
  return pessoaRepository.findAll();
}
```

Agora vamos configurar o arquivo **application.yml**  localizado na pasta resources do projeto.


```yaml
resilience4j.circuitbreaker:
  configs:
    default:
      waitDurationInOpenState: 10s
      failureRateThreshold: 10
  instances:
    pessoas:
      baseConfig: default
```

As configurações do Circuit Breaker são as seguintes:

- `failureRateThreshold`: Taxa de erro esperada para que o circuito seja aberto (10%).

- `waitDurationInOpenState`: Tempo que o Circuit Breaker deve esperar antes de fazer a transição de aberto para meio aberto (10 segundos).


Com isso, temos que o retorno do método deixaria de ser um possível erro relacionado ao banco e passaria para algo como:
> CircuitBreaker **'pessoas'** is OPEN and does not permit further calls


# Fallback

> Ao termos uma função anotada com @CircuitBreaker, temos a possibilidade de 
> informar qual será seu método de retorno em casos de falhas: o fallbackMethod.

>  importante lembrar que um método de fallback deve ser colocado na mesma 
> classe e deve ter a mesma sequência de argumentos. Opcionalmente, podemos acrescentar um parâmetro de exceção.

```java
@CircuitBreaker(name = "pessoas", fallbackMethod = "fallback")
public List<Pessoa> listarPessoas(){
    return pessoaRepository.findAll();
    }

private List<Pessoa> fallback(RuntimeException e){
    return List.of();
    }
```

> Assim, em caso de erro o método fallback seria chamado pelo circuit breaker e
> o retorno seria uma lista vazia (List.of()).

[Documentação do Retry no Resilience4j](https://resilience4j.readme.io/docs/retry)





