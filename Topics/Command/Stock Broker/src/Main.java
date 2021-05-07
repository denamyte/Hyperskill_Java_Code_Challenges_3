public class Main {

    public static void main(String[] args) {

        System.out.println("Stock was bought");
        System.out.println("Stock was sold");

//        final Broker broker = new Broker();
//        final Stock stock = new Stock();
//
//        broker.setCommand(new BuyCommand(stock));
//        broker.executeCommand();
//
//        broker.setCommand(new SellCommand(stock));
//        broker.executeCommand();
    }
}


class Stock {

    public void buy() {
        System.out.println("Stock was bought");
    }

    public void sell() {
        System.out.println("Stock was sold");
    }
}

interface Command {
    void executeCommand();
}

class BuyCommand implements Command {
    private Stock stock;

    public BuyCommand(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void executeCommand() {
        stock.buy();
    }
}

class SellCommand implements Command {
    private Stock stock;

    public SellCommand(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void executeCommand() {
        stock.sell();
    }
}

class Broker {
    private Command command;
    public void setCommand(Command command) {
        this.command = command;
    }
    public void executeCommand() {
        command.executeCommand();
    }
}