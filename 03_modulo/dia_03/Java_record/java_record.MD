# Classes de dados com Java record

Vamos supor que quiséssemos definir uma classe Person com alguns atributos. 

```java
public record Person(String name, Integer age) {}
```
## Tipos Record em Java

Os tipos record em Java oferecem uma maneira concisa de definir classes com atributos imutáveis e métodos gerados automaticamente. Aqui estão os principais pontos:

- **Sintaxe Simples:** A definição de um tipo record é concisa, muitas vezes consistindo em apenas uma linha.

- **Métodos Gerados Automaticamente:** Os tipos record geram automaticamente métodos semelhantes a construtores e getters para seus atributos.

- **Imutabilidade:** Os objetos de um tipo record são imutáveis, o que significa que os valores de seus atributos não podem ser modificados após a criação.

- **Sem Setters:** Como os records são imutáveis, não possuem métodos setters para alterar os valores dos atributos.

- **Nomes de Métodos:** Os métodos gerados para acessar os atributos têm o mesmo nome dos atributos, sem o prefixo "get". Por exemplo, um atributo chamado "name" pode ser acessado pelo método "name()" e "age" pelo método "age()".

- **Valores Através do Construtor:** Devido à imutabilidade, os valores dos atributos de um tipo record devem ser passados obrigatoriamente através do construtor.

Os tipos record são uma adição útil ao Java moderno, tornando mais simples a definição de classes de objetos imutáveis com uma sintaxe mais enxuta.


## Utilizando record Person:

```java
// Precisamos passar os valores dos atributos no construtor
// e não podemos modificá-los depois
Person person = new Person("Maria", 30);

// Os métodos de acesso aos valores não têm 'get' no nome
System.out.println(person.name());
System.out.println(person.age());
```

### Veja na tabela abaixo um resumo das diferenças nos casos acima, da classe comum em contraste com a record:

|                            | **Classe Comum**                     | **Tipo Record**                    |
|----------------------------|-------------------------------------|------------------------------------|
| **Criação**                | Pode utilizar construtores com ou sem argumentos | Os valores dos atributos precisam ser informados durante a criação do objeto. |
| **Mutabilidade**           | Mutável (pode ter seus atributos alterados) | Imutável (uma vez definidos os atributos não podem ser alterados). |
| **Getters**                | getName() e getAge()                 | name() e age()                     |
| **Setters**                | setName() e setAge()                | Não possui.                         |
| **Métodos equals, toString e hashCode** | Herdados da classe Object ou implementados manualmente | Gerados automaticamente pelo Java.  |


## Criando métodos na classe record

> Os métodos não podem alterar o valor de nenhum atributo.

```java
public record Person(String name, Integer age) {
    public String greeting() {
        return String.format("Olá, meu nome é %s e tenho %s anos", name, age);
    }
}
```
#### Chamando os métodos
```java
Person person = new Person("Maria", 30);

System.out.println(person.greeting());
```

Saída:

```java
Olá, meu nome é Maria e tenho 30 anos
```