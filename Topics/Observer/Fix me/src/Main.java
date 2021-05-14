import java.util.*;

/**
 * Observable interface
 **/
interface Observable {

    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}

/** Concrete Observable */
class RockstarGames implements Observable {

    public String releaseGame;
    private List<Observer> observers = new ArrayList<>();


    public void release(String releaseGame) {
        this.releaseGame = releaseGame;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            System.out.println("Inform message to : " + observer);
            observer.update(releaseGame);
        }
    }
}


/**
 * Observer interface
 **/
interface Observer {

    public void update(String domain);
}

/** Concrete Observer */
class Gamer implements Observer {

    private String name;
    private String reaction;
    private Observable observable;
    private Set<String> games = new HashSet<>();

    public Gamer(String name,String reaction, Observable observable) {
        this.reaction = reaction;
        this.observable = observable;  // Why ???
        this.name = name;
    }

    @Override
    public void update(String domain) {
        buyGame(domain);
    }

    public void buyGame(String game) {
        games.add(game);
        System.out.printf("%s says: %s%n", name, reaction);
    }

    @Override
    public String toString() {
        return this.name;
    }
}

/** Main Class */

public class Main {
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        String game = null;
        RockstarGames rockstarGames = new RockstarGames();

        Gamer garry = new Gamer("Garry Rose", "I want to pre-order", rockstarGames);
        Gamer peter = new Gamer("Peter Johnston", "Pinch me...", rockstarGames);
        Gamer helen = new Gamer("Helen Jack", "Jesus, it's new game from Rockstar!", rockstarGames);

        rockstarGames.addObserver(garry);
        rockstarGames.addObserver(peter);
        rockstarGames.addObserver(helen);

        game = scanner.nextLine();
        System.out.println("It's happened! RockstarGames releases new game - " + game + "!");

        rockstarGames.release(game);

        scanner.close();
    }
}