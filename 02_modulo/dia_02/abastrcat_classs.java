public abstract class Developer {
  public String language;
  public int yearsOfExperience;

  public abstract double wage();
  public abstract String mainSkill();
}

public class JuniorDeveloper extends Developer {
  public double wage() {
    return 3000.0 + yearsOfExperience*100;
  }

  public String mainSkill() {
    return language + " Automated tests";
  }
}

public class SeniorDeveloper extends Developer {
  public double wage() {
    return 5000.0 + yearsOfExperience*500;
  }

  public String mainSkill() {
    return language + " Debug";
  }
}




//No entanto, podemos criar um objeto a partir de uma classe abstrata,
// desde que os métodos abstratos sejam implementados no momento
// da criação do objeto. Exemplo:

Developer developer = new Developer() {
    public double wage() {
        return 4000.0;
    }

    public String mainSkill() {
        return "Debug";
    }
};


//============================================================================//
                    // Classe abstrata e polimorfismo //
//============================================================================//
public class CompanyWages {
  public double totalWages(Developer[] developers) {

    double sum = 0.0;

    for (Developer developer : developers) {
      sum += developer.wage();
    }

    return sum;
  }
}

public abstract class Developer {
  protected String language;
  private int yearsOfExperience;

  public Developer(String language) {
    this.language = language;
  }

  public abstract double wage();

  public String mainSkill() {
    return "Coding";
  }
}

//Resumindo
//    Classes abstratas servem para declarar métodos abstratos
//    O método abstrato é usado quando o mesmo método é implementado de uma maneira diferente em cada classe herdeira
//    Classes abstratas são um tipo especial de classe: podem ter atributos, herdar e serem herdadas, mas não podem ser instanciadas — servem para definir como as classes herdeiras vão se comportar
