public interface Skillful {

  String getLanguage();

  default String mainSkill() {
    return "Learn " + getLanguage();
  }
}

public class Student implements Skillful {

  public boolean intern;
  private String language;

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public int yearsToGraduate() {
    int years = 2;
    if (intern) {
      years = 1;
    }
    return years;
  }
}

// Resumindo
// Interfaces são usadas para agrupar métodos em comum de classes que se encontram em contextos distintos — e que, portanto, não podem ter a mesma herança.
//
// Não possuem atributos e podem herdar mais de uma interface.
//
// Uma classe pode implementar mais de uma interface.
//
// Possuem baixo acoplamento em comparação com herança.