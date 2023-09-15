# Serialização e desserialização

## Mapeamento de Dados em APIs Java

Quando implementamos uma API em Java, há um processo importante que ocorre nos bastidores: o mapeamento de dados. Esse processo lida com a transformação de dados entre dois formatos diferentes:

### Serialização

A serialização é o processo de transformação de objetos Java em um formato específico, como JSON. Isso é necessário para que os dados possam ser enviados por meio de solicitações HTTP ou armazenados de forma persistente em um formato que não seja Java.

### Desserialização

A desserialização é o processo inverso da serialização. Ela envolve a transformação de dados de um formato, como JSON, de volta para objetos Java. Isso é essencial para receber dados de solicitações HTTP ou recuperar dados armazenados em formato não Java.

### Outros Nomes

Em inglês, esse processo de mapeamento de dados pode ser referido por diferentes termos:

- Object Mapping
- Data Binding
- Marshalling/Unmarshalling

Esses termos descrevem essencialmente o mesmo conceito de transformar dados entre a representação em Java e um formato externo, como JSON, XML, etc.

O mapeamento de dados é uma parte fundamental no desenvolvimento de APIs Java, permitindo a comunicação eficiente e a interoperabilidade com diferentes sistemas e formatos de dados.

## A biblioteca Jackson
Para fazer o mapeamento entre Java e JSON, o Spring utiliza a biblioteca Jackson. 

## Serialização

```java
public class Person {
  private String name;
  public Integer age;

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
}
```

## Perceba que temos um atributo privado e outro público. Apesar de não ser 
recomendado o uso de atributos públicos, eles têm efeito na forma com que o 
mapeamento acontece

Agora, vamos utilizar a **ObjectMapper** para converter a classe para JSON:

```java
Person person = new Person();
person.setName("Maria");
person.age = 30;

ObjectMapper mapper = new ObjectMapper();

String json = mapper.writeValueAsString(person);

System.out.println(json);
```

A saída do código acima será algo como:
> {"name": "Maria", "age": 30}

## Método `writeValueAsString` da Classe `ObjectMapper`

O método `writeValueAsString` da classe `ObjectMapper` em Java realiza o seguinte:

1. **Identificação de Atributos:** Ele examina um objeto Java em busca de atributos públicos e valores retornados por getters.

2. **Criação de JSON:** Utiliza esses atributos e valores para criar um objeto JSON.

3. **Nomes de Atributos:** Os nomes dos atributos no JSON correspondem aos nomes dos getters e dos atributos públicos do objeto Java.

4. **Identificação de Atributos Privados:** A `ObjectMapper` também utiliza os getters da classe, mesmo que sejam privados, para identificar os atributos.

Resumindo, o `writeValueAsString` transforma um objeto Java em um objeto JSON, considerando tanto atributos públicos quanto os valores retornados pelos getters da classe.


