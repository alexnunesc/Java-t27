# Configurando o Maven através do arquivo pom.xml
1. Agora que já falamos sobre o Apache Maven, você pode estar se questionando: 
“Nossa, que legal! Mas como eu faço essa maravilha funcionar?” Vamos responder a essa pergunta a seguir!

2. Para utilizar todos os benefícios do Apache Maven, é necessário colocar um 
arquivo chamado “pom.xml” na raiz do seu projeto, indicando que ele é “guiado” pelo Maven.

3. POM significa “Project Object Model”, sendo um modelo em XML que levanta 
informações para que o Maven possa gerenciar o projeto com sucesso.

## Primeiramente, antes de colocarmos nossas dependências no arquivo “pom.xml”,
precisamos adicionar algumas informações básicas:

1. **groupId:** o nome dos pacotes da sua organização
2. **artifactId:** o nome do seu projeto ou produto
3. **version:** a versão em que se encontra o projeto ou produto
4. **packaging:** o tipo de arquivo que é disponibilizado no final
A seguir, podemos ver como deve estar preenchida a parte básica do seu arquivo pom.xml:


# Onde eu coloco as dependências do projeto?

> A **lista de dependências** é declarada no arquivo “pom.xml” sob a tag 
> **dependencies**
>
> onde cada dependência **será uma tag dependency**.


>Dentro de **dependency** é necessário informar pelo menos **groupId**, 
> **artifactId**,
> 
> version para que o Maven encontre essas dependências no **Maven 
> CentralMaven Central**
> 
> ou em outro repositório previamente configurado.
