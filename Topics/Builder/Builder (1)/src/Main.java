import java.util.List;
import java.util.Scanner;

/**
 * ConcreteComponent - Geek.
**/
class Geek {

    private final String type;
    private final List<String> languages;
    private final int experience;

    public Geek(String type, List<String> languages, int experience) {
        this.type = type;
        this.languages = languages;
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Type : " + type + "\n" +
                "Languages : " + languages + "\n" +
                "Experience : " + experience + " years";
    }

}

/**
 * Builder interface describe step of object creation.
**/
interface Builder {
    void setType(String type);
    void setLanguages(List<String> languages);
    void setExperience(int experience);
}

/**
 * Concrete Builder build Geek component.
**/
class  GeekBuilder implements Builder {

    private String type;
    private List<String> languages;
    private int experience;

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    @Override
    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Geek getResult() {
        return new Geek(type, languages, experience);
    }
}

/**
  * Builder Director.
  */
class GeekDirector {

    public void buildAdmin(Builder builder) {
        build(builder, "Admin", 10, "Perl", "PowerShell");
    }

    public void buildRockstar(Builder builder) {
        build(builder, "Rockstar", 20, "Java", "Kotlin", "Scala", "Angular");
    }

    public void buildBackend(Builder builder) {
        build(builder, "Backend", 5, "Python", "PHP");
    }

    private void build(Builder builder, String type, int exp, String... languages) {
        builder.setType(type);
        builder.setExperience(exp);
        builder.setLanguages(List.of(languages));
    }

}

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String geekName = scanner.nextLine();
        final String geekType = scanner.nextLine();
        scanner.close();
        GeekDirector director = new GeekDirector();
        GeekBuilder builder = new GeekBuilder();
        Geek geek = null;
        if ("Rockstar".equals(geekType)) {
            director.buildRockstar(builder);
            geek = builder.getResult();
        } else if ("Backend".equals(geekType)) {
            director.buildBackend(builder);
            geek = builder.getResult();
        } else if ("Admin".equals(geekType)) {
            director.buildAdmin(builder);
            geek = builder.getResult();
        } else {
            System.out.println("Error");
            return;
        }
        System.out.println("Geek " + geekName + " created.");
        System.out.println(geek);

    }
}