public interface Skillful {
  String mainSkill();
}

//  Implementando interfaces
//  Para que uma classe implemente uma interface,
//  basta usar a palavra implements.
//  Veja como ficam as classes Developer e Student:

public abstract class Developer implements Skillful {
  public String language;
  public int yearsOfExperience;

  public abstract double wage();
}

public class Student implements Skillful {
  public boolean intern;

  public int yearsToGraduate() {
    int years = 2;
    if (intern) {
      years = 1;
    }
    return years;
  }

  public String mainSkill() {
    return "Learn!!";
  }
}


//  Observe que somente as classes concretas são obrigadas a definir os
//  métodos de suas interfaces. No nosso exemplo,apenas a classe concreta
//  Student precisou implementar o método mainSkill, que foi definido na
//  interface Skillful. Em contraste, embora tenhamos especificado que a
//  classe abstrata Developer implementa a interface Skillful, podemos
//  delegar a implementação do método mainSkill para as subclasses concretas.



// Para implementar várias interfaces em uma classe, basta separá-las por
// vírgula. Exemplo:
class UmaClasse implements InterfaceA, InterfaceB, InterfaceC {

}

// Herança entre interfaces.
public interface Skillful {

  default String mainSkill() {
    return "Read?";
  }
}

public String mainSkill() {

  return Skillful.super.mainSkill() + " And learn!!";
}

