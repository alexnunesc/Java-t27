# Nesse código estamos utilizando a anotação @SpringBootApplication como forma
de prover informações extra para o Spring.
No caso, estamos informando ao framework de que aquela classe é uma aplicação
Spring Boot.

## @SpringBootApplication na verdade é um “apelido” que ativa três outras anotações importantes:

1. @EnableAutoConfiguration: esta é uma anotação do Spring Boot responsável 
por fazer automaticamente diversas configurações do Spring;

2. @ComponentScan: indica que o Spring deve procurar por componentes (por 
   padrão a partir do pacote atual). Veremos mais detalhes abaixo, quando 
   falarmos sobre a anotação  @Component;

3. @Configuration: permite que a classe inclua outras configurações extra, ou 
   que defina beans adicionais.