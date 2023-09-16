# Mapas em Java

Map é a interface Java que define objetos que contêm mapeamentos estilo
chave/valor.

### Tipos
> Mapas podem ser mutáveis ou imutáveis. Semelhante ao List.of, que cria listas
imutáveis, existe o Map.of.


## Resumo das Classes de Map em Java

As classes de Map mais usadas em Java são `HashMap` e `TreeMap`. Ambas são implementações da interface `Map`, e compartilham semelhanças em relação à representação interna com as classes `HashSet` e `TreeSet`, que são tipos de `Set`.

Aqui está um resumo das principais diferenças entre elas:

- **HashMap**:
    - Utiliza uma tabela hash para armazenar pares chave-valor.
    - Projetado para otimizar o desempenho, oferecendo acesso rápido às chaves.
    - A ordem dos elementos não é garantida; eles não são armazenados em uma ordem específica.

- **TreeMap**:
    - Utiliza uma árvore ordenada (normalmente uma árvore vermelha-negra) para armazenar pares chave-valor.
    - Mantém os elementos em uma ordem natural ou com base em um comparador personalizado.
    - Os elementos são armazenados em ordem crescente, o que permite iterar pelos elementos em ordem.

Ambos `HashMap` e `TreeMap` são úteis em diferentes situações, dependendo das necessidades de ordenação e desempenho do seu programa.


# Aprendendo a usar Map nas operações de C.R.U.D.

1. Criando um mapa mutável. Por exemplo, um HashMap:

```java
HashMap<String, String> estudantes = new HashMap<String, String>();
```

Trataremos matrícula como String e mapearemos matrícula a nome de estudante.
Para preencher o mapa, o método mais comum é o put(K, V):

```java
HashMap<String, String> estudantes = new HashMap<String, String>();
    estudantes.put("x038702","João");
    estudantes.put("x784244","Maria");
    estudantes.put("x105852","Joana");
```

### Put
ele substitui o mapeamento e retorna o valor anterior. 

```java
HashMap<String, String> estudantes = new HashMap<String, String>();
estudantes.put("x038702","João");
estudantes.put("x784244","Maria");
estudantes.put("x105852","Joana");
String valorAnterior = estudantes.put("x038702","José"); // Mesma matricula usada no mapeamento com João
System.out.println("Valor anterior de x038702: "+valorAnterior);
System.out.println("Estudantes: "+estudantes);
```

Saída:
```java
Valor anterior de x038702: João
Estudantes: {x038702=José, x784244=Maria, x105852=Joana}
```

## Ler o valor associado a uma chave, usamos o get(K):

```java
HashMap<String, String> estudantes = new HashMap<String, String>();
estudantes.put("x038702","João");
estudantes.put("x784244","Maria");
estudantes.put("x105852","Joana");
System.out.println(estudantes.get("x105852"));
```
Saída:  Joana

E assim conseguimos ler o valor associado à chave “x105852”.

Map também possui as mesmas funções de List e Set para verificar tamanho:
**isEmpty()** e **size()**.

### Para remover um mapeamento do mapa

> **remove(Object)**, passando a chave como parâmetro:

```java
HashMap<String, String> estudantes = new HashMap<String, String>();
estudantes.put("x038702","João");
estudantes.put("x784244","Maria");
estudantes.remove("x038702");
System.out.println(estudantes);
```

Saída: {x784244=Maria}


