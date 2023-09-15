# Desserialização.

Da mesma forma será o mapeamento de JSON para Java:

```java
String json = "{\"name\": \"Maria\", \"age\": 30}";

ObjectMapper mapper = new ObjectMapper();

Person person = mapper.readValue(json, Person.class);

System.out.println(person.getName());    
System.out.println(person.age);
```
Saída:
> Maria
> 30

## Método `readValue` da Classe `ObjectMapper`

O método `readValue` da classe `ObjectMapper` em Java faz o seguinte:

1. **Conversão de JSON para Objeto Java:** Recebe uma String contendo um JSON e a classe Java para a qual deve ser convertido.

2. **Utilização de Setters:** Para cada atributo no objeto JSON, o método utiliza os setters apropriados na classe Java. Por exemplo, o `setName` do objeto Java será chamado com o valor do atributo `name` do JSON, e o `setAge` será chamado com o valor `age`.

3. **Mapeamento de Atributos:** A biblioteca faz o mapeamento dos atributos automaticamente, mesmo que os setters sejam privados. Isso é realizado utilizando técnicas avançadas, como reflexão.

4. **Gestão de Erros:** A biblioteca tenta mapear todos os atributos do JSON para a classe Java, mas gerará um erro se algum atributo não puder ser mapeado.

Portanto, o método `readValue` é usado para converter JSON em objetos Java, sendo capaz de mapear automaticamente atributos, mesmo que os setters sejam privados.

```java
String json = "{\"name\": \"Maria\", \"age\": 30, \"city\": \"Palmas\"}";
```

## Lidando com Atributos Não Reconhecidos usando `@JsonIgnoreProperties`

Ao tentar desserializar um JSON em uma classe Java, como no caso da classe `Person`, podem ocorrer erros se a classe não possui um atributo público correspondente ao JSON ou um método `getCity`. Um erro comum é o seguinte:

```java
Exception in thread "main" com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException: Unrecognized field "city" (class Person), not marked as ignorable (2 known properties: "name", "age"])
```

```java
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
```

### para solucionar isso usamos.

```java
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {
  // ... restante da classe ...
}
```