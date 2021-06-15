import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            Broker broker = new Broker();
            IntStream.generate(scanner::nextInt).limit(3)
                    .mapToObj(Main::toCommand)
                    .forEach(command -> {
                        broker.setCommand(command);
                        broker.executeCommand();
                    });
        }
    }

    private static Command toCommand(int amount) {
        return amount > 0 ? new BuyCommand(amount) : new SellCommand(amount);
    }
}

interface Command {
    void execute();
}

abstract class BaseCommand implements Command {
    protected int amount;

    public BaseCommand(int amount) {
        this.amount = amount;
    }
}

class BuyCommand extends BaseCommand {

    BuyCommand(int amount) {
        super(amount);
    }

    @Override
    public void execute() {
        System.out.println(amount + " was bought");
    }
}

class SellCommand extends BaseCommand {

    SellCommand(int amount) {
        super(amount);
    }

    @Override
    public void execute() {
        System.out.println(amount + " was sold");
    }
}

class Broker {
    private Command command;
    void setCommand(Command command) {
        this.command = command;
    }
    void executeCommand() {
        command.execute();
    }
}